package com.mazzatech.azship.domain.shipping;

import jakarta.validation.constraints.NotBlank;

public record PropertyDTO(
        @NotBlank(message="Property name can't be blank") String name,
        @NotBlank(message="Property value can't be blank") String value) {}
