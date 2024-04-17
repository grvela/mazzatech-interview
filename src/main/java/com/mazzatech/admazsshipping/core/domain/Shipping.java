package com.mazzatech.admazsshipping.core.domain;

import com.mazzatech.admazsshipping.web.dtos.PropertyDTO;
import com.mazzatech.admazsshipping.web.dtos.ShippingDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Shipping {
    private String id;
    private String clientId;
    private List<Property> properties;

    public Shipping(ShippingDTO shippingData){
        this.clientId = shippingData.clientId();
        this.properties = new ArrayList<>();
        for (PropertyDTO property : shippingData.properties()) {
            this.properties.add(new Property(property.name(), property.value()));
        }
    }
}
