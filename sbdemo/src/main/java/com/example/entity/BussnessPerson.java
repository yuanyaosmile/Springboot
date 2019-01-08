package com.example.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Author Barry
 * @date 2019/1/7
 */
@Component
public class BussnessPerson implements Person{

    public Animal animal = null;

    public BussnessPerson(@Autowired @Qualifier("dog") Animal animal){
        this.animal = animal;
    }

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnmial(Animal anmial) {
        this.animal = anmial;
    }
}
