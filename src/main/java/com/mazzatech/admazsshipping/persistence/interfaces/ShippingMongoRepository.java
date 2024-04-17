package com.mazzatech.admazsshipping.persistence.interfaces;

import com.mazzatech.admazsshipping.core.domain.Shipping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingMongoRepository extends MongoRepository<Shipping, String> {
    Page<Shipping> findByPropertiesNameAndPropertiesValue(String name, String value, Pageable pageable);
    Page<Shipping> findByPropertiesName(String name, Pageable pageable);
}