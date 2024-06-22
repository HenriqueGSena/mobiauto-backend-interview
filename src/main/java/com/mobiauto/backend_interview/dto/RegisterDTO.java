package com.mobiauto.backend_interview.dto;

import com.mobiauto.backend_interview.entities.enums.Cargos;

public record RegisterDTO(String login, String password, String email, Cargos cargos) {
}
