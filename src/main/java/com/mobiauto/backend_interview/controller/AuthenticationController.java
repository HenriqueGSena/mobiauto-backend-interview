package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.config.TokenService;
import com.mobiauto.backend_interview.dto.AuthenticationDTO;
import com.mobiauto.backend_interview.dto.LoginDTO;
import com.mobiauto.backend_interview.dto.RegisterDTO;
import com.mobiauto.backend_interview.entities.Usuarios;
import com.mobiauto.backend_interview.repository.UsuariosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuarios) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.usuariosRepository.findByLogin(data.login()) != null) {
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuarios newUser = new Usuarios(data.login(), data.email(), encryptedPassword, data.cargos());
        this.usuariosRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
