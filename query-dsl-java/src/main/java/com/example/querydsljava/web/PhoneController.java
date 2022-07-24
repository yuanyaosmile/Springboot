package com.example.querydsljava.web;

import com.example.querydsljava.dao.entity.PhoneEntity;
import com.example.querydsljava.service.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PhoneController {

    private final PhoneService phoneService;

    @GetMapping("phone/{criteria}")
    public ResponseEntity<PhoneEntity> getPhone(@PathVariable String criteria) {
        return ResponseEntity.of(phoneService.getPhone(criteria));
    }
}
