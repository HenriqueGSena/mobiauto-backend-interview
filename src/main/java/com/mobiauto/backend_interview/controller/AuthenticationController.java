package com.mobiauto.backend_interview.controller;

import com.mobiauto.backend_interview.config.TokenService;
import com.mobiauto.backend_interview.dto.AuthenticationDTO;
import com.mobiauto.backend_interview.dto.LoginDTO;
import com.mobiauto.backend_interview.dto.UsuarioDTO;
import com.mobiauto.backend_interview.entities.Usuario;
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
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.nome(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UsuarioDTO data) {
        if (this.usuariosRepository.findByNome(data.getNome()) != null) {
            return ResponseEntity.badRequest().build();
        }
        if (this.usuariosRepository.findByEmail(data.getEmail()) != null) {
            return ResponseEntity.badRequest().body("E-mail já está em uso.");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getSenha());
        Usuario newUser = new Usuario(data.getNome(), data.getEmail(), encryptedPassword, data.getCargos());
        this.usuariosRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
