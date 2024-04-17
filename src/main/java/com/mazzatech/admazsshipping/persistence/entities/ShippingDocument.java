package com.mazzatech.admazsshipping.persistence.entities;


import com.mazzatech.admazsshipping.core.domain.Property;
import com.mazzatech.admazsshipping.web.dtos.PropertyDTO;
import com.mazzatech.admazsshipping.web.dtos.ShippingDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "shipping")
public class ShippingDocument {
        @Id
        private String id;
        private String clientId;
        private List<Property> properties;

        public ShippingDocument(ShippingDTO shippingData){
            this.clientId = shippingData.clientId();
            this.properties = new ArrayList<>();
            for (PropertyDTO property : shippingData.properties()) {
                this.properties.add(new Property(property.name(), property.value()));
            }
        }
}
