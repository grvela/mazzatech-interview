package com.mazzatech.admazsshipping.core.interfaces;

import com.mazzatech.admazsshipping.core.domain.Property;
import com.mazzatech.admazsshipping.core.domain.Shipping;
import com.mazzatech.admazsshipping.web.dtos.ShippingDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface ShippingService {
    Shipping create(ShippingDTO shipping);
    Shipping getById(String id) throws ResponseStatusException;
    Shipping updateById(String id, ShippingDTO shipping) throws ResponseStatusException;
    void deleteById(String id) throws ResponseStatusException;
    Page<Shipping> getAllWithQuery(String query, Pageable pageable);
    Page<Shipping> getAllWithQueryAndValue(String query, String value, Pageable pageable);
}
