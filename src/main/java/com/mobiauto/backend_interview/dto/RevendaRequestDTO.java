package com.mobiauto.backend_interview.dto;

import jakarta.validation.constraints.NotBlank;

public record RevendaRequestDTO(

        @NotBlank
        String nomeSocial,

        @NotBlank
        String cnpj
) {
}
