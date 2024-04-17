package com.mazzatech.admazsshipping.core.service;

import com.mazzatech.admazsshipping.core.domain.Property;
import com.mazzatech.admazsshipping.core.domain.Shipping;
import com.mazzatech.admazsshipping.core.interfaces.ShippingRepository;
import com.mazzatech.admazsshipping.core.interfaces.ShippingService;
import com.mazzatech.admazsshipping.web.dtos.ShippingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public class ShippingServiceImpl implements ShippingService {

    private final ShippingRepository repository;

    public ShippingServiceImpl(ShippingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Shipping create(ShippingDTO shipping) {
        Shipping newShipping = new Shipping(shipping);
        return this.repository.create(newShipping);
    }

    @Override
    public Shipping getById(String id) {
        return this.repository.getById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Shipping updateById(String id, ShippingDTO shipping) {
        Shipping existingShipping = this.repository.getById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        Shipping updatedShipping = new Shipping(shipping);

        existingShipping.setProperties(updatedShipping.getProperties());

        return this.repository.update(existingShipping);
    }

    @Override
    public void deleteById(String id) {
        Shipping existingShipping = this.repository.getById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        this.repository.delete(existingShipping);
    }

    @Override
    public Page<Shipping> getAllWithQuery(String query, Pageable pageable) {
        return this.repository.getAllWithQuery(query, pageable);
    }

    @Override
    public Page<Shipping> getAllWithQueryAndValue(String query, String value, Pageable pageable) {
        return this.repository.getAllWithQueryAndValue(query, value, pageable);
    }
}
