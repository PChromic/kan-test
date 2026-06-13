package com.sii.utils;

import net.datafaker.Faker;

public class KanFaker {

    private static final Faker faker = new Faker();

    public static String username() {
        return faker.naruto().character();
    }

    public static String password() {
        return faker.naruto().demon();
    }

    public static String boardName() {
        return faker.numerify(faker.lordOfTheRings().character()+"###");
    }
}
