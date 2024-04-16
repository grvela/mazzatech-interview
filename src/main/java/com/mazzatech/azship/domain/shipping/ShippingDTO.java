package com.mazzatech.azship.domain.shipping;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record ShippingDTO(
        @NotBlank(message = "Client ID can't be blank") String clientId,
        @NotEmpty(message = "Property list can't be empty") List<@Valid PropertyDTO> properties
){}
