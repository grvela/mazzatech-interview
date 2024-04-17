package com.mazzatech.admazsshipping.core.domain;

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
