package com.mazzatech.admazsshipping.core.interfaces;

import com.mazzatech.admazsshipping.core.domain.Property;
import com.mazzatech.admazsshipping.core.domain.Shipping;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public interface ShippingRepository {
    Shipping create(Shipping shipping);
    Optional<Shipping> getById(String id);
    Shipping update(Shipping shipping);
    void delete(Shipping shipping);
    Page<Shipping> getAllWithQuery(String query, Pageable pageable);
    Page<Shipping> getAllWithQueryAndValue(String query, String value, Pageable pageable);
}
