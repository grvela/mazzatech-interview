package com.mazzatech.admazsshipping.web.controllers;

import com.mazzatech.admazsshipping.core.domain.Shipping;
import com.mazzatech.admazsshipping.core.interfaces.ShippingService;
import com.mazzatech.admazsshipping.web.dtos.ShippingDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/shipping")
public class ShippingController {
    private final ShippingService service;

    public ShippingController(ShippingService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Shipping> create(@Valid @RequestBody ShippingDTO shipping) {
        Shipping newShipping = this.service.create(shipping);
        return ResponseEntity.ok().body(newShipping);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getById(@PathVariable String id){
        Shipping shipping = this.service.getById(id);
        return ResponseEntity.ok().body(shipping);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shipping> updateById(@PathVariable String id, @RequestBody ShippingDTO shipping){
        Shipping updatedShipping = this.service.updateById(id, shipping);
        return ResponseEntity.ok().body(updatedShipping);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        this.service.deleteById(id);
    }

    @GetMapping
    public Page<Shipping> getAllWithQuery(
            @RequestParam(name="query", required = true) String query,
            @RequestParam(name="value", required = false) String value,
            @RequestParam(name="page", defaultValue="0", required = false) int page,
            @RequestParam(name="size", defaultValue="10", required = false) int size
    ){
        Pageable pageable = PageRequest.of(page, size);

        if(value == null){
            return this.service.getAllWithQuery(query, pageable);
        }

        return this.service.getAllWithQueryAndValue(query, value, pageable);
    }


}
