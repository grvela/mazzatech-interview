package com.mazzatech.azship.domain.shipping;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
public class Shipping {

    @Id
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
