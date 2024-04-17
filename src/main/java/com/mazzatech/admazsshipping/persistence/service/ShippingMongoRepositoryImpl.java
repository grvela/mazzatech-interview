package com.mazzatech.admazsshipping.persistence.service;

import com.mazzatech.admazsshipping.core.domain.Shipping;
import com.mazzatech.admazsshipping.core.interfaces.ShippingRepository;
import com.mazzatech.admazsshipping.persistence.interfaces.ShippingMongoRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ShippingMongoRepositoryImpl implements ShippingRepository {
    private final ShippingMongoRepository repository;

    public ShippingMongoRepositoryImpl(@Lazy ShippingMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipping create(Shipping shipping) {
        return this.repository.save(shipping);
    }

    @Override
    public Optional<Shipping> getById(String id) {
        return this.repository.findById(id);
    }

    @Override
    public Shipping update(Shipping shipping) {
        return this.repository.save(shipping);
    }

    @Override
    public void delete(Shipping shipping) {
        this.repository.delete(shipping);
    }

    @Override
    public Page<Shipping> getAllWithQuery(String query, Pageable pageable) {
        return this.repository.findByPropertiesName(query, pageable);
    }

    @Override
    public Page<Shipping> getAllWithQueryAndValue(String query, String value, Pageable pageable) {
        return this.repository.findByPropertiesNameAndPropertiesValue(query, value, pageable);
    }
}
