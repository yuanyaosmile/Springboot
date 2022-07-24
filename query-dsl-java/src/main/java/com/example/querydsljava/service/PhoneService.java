package com.example.querydsljava.service;

import com.example.querydsljava.dao.entity.PhoneEntity;
import com.example.querydsljava.dao.entity.QPhoneEntity;
import com.example.querydsljava.dao.repository.PhoneRepository;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public Optional<PhoneEntity>  getPhone(String criteria) {
        BooleanBuilder predicate = new BooleanBuilder();
        predicate.and(QPhoneEntity.phoneEntity.name.eq(criteria));
       return phoneRepository.findOne(predicate);
    }
}
