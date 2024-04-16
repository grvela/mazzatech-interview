package com.mazzatech.azship.services;

import com.mazzatech.azship.domain.shipping.Shipping;
import com.mazzatech.azship.domain.shipping.ShippingDTO;
import com.mazzatech.azship.repositories.ShippingRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ShippingService {
    private final ShippingRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(ShippingService.class);

    public ShippingService(ShippingRepository repository) {
        this.repository = repository;
    }

    public Shipping create(ShippingDTO shipping) {
            Shipping newShipping = new Shipping(shipping);
            return this.repository.save(newShipping);
    }

    public Shipping getById(String id){
        return this.repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    public Shipping updateById(String id, ShippingDTO shipping){
        Shipping existingShipping = this.repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        Shipping updatedShipping = new Shipping(shipping);

        existingShipping.setProperties(updatedShipping.getProperties());

        return this.repository.save(existingShipping);
    }

    public void deleteById(String id){
        Shipping existingShipping = this.repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        this.repository.delete(existingShipping);
    }

    public Page<Shipping> getAllWithQueryAndValue(String query, String value, Pageable pageable){
        return this.repository.findByPropertiesNameAndPropertiesValue(query, value, pageable);
    }

    public Page<Shipping> getAllWithQuery(String query, Pageable pageable){
        return this.repository.findByPropertiesName(query, pageable);
    }
}
