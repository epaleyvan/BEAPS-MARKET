package com.beapsmarket.webapp.presentation.api;

import com.beapsmarket.webapp.model.dto.DeliveryDto;
import com.beapsmarket.webapp.service.IDelivery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/delivery")
@Slf4j
public class DeliveryRestController {

    @Autowired
    IDelivery iDelivery;

    @PostMapping("/save")
    public void saveDelivery(@RequestBody DeliveryDto deliveryDto){
        iDelivery.saveDelivery(deliveryDto);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<DeliveryDto>> getAllDelivery(){
        return ResponseEntity.ok(iDelivery.findAllDelivery());
    }

    @GetMapping("/{reference}/data")
    public ResponseEntity<DeliveryDto> getDeliveryByReference(@PathVariable String reference){
        return ResponseEntity.ok(iDelivery.findDeliveryByReference(reference));
    }
}
