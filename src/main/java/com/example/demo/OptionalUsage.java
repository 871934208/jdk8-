package com.example.demo;

import java.util.Optional;

public class OptionalUsage {

    public static void main(String[] args) {

        Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//        Insurance insurance = insuranceOptional.get();
        Optional<Insurance> insuranceOptional1 = Optional.of(new Insurance());
        Insurance insurance = insuranceOptional1.get();

        Optional<Object> objectOptional = Optional.ofNullable(null);
        objectOptional.orElseGet(Insurance::new);
        objectOptional.orElse(new Insurance());
        objectOptional.orElseThrow(RuntimeException::new);

    }
}
