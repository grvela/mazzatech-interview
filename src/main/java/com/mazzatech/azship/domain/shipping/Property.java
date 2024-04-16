package com.mazzatech.azship.domain.shipping;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Property {
    private String name;
    private String value;

    public Property(String name, String value){
        this.name = name;
        this.value = value;
    }
}
