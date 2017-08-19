package com.github.spb.tget.uitests.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomUtils {

    private static long TICKS_AT_EPOCH = 621355968000000000L;

    private static Random random = new Random(System.currentTimeMillis() * 10000 + TICKS_AT_EPOCH);

    public static Boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    public static Integer getRandomInteger() {
        return random.nextInt();
    }

    public static String getRandomString(int charactersCount) {
        return RandomStringUtils.randomAlphanumeric(charactersCount);
    }

    public static Object getRandomElement(Collection collection) {
        int i = random.nextInt(collection.size());
        return collection.toArray()[i];
    }

    public static List<String> getRamdomEmailAddresses(int count) {
        List<String> emails = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            emails.add(String.format("%s@%s.test", getRandomString(20), getRandomString(20)));
        }
        return emails;
    }

    public static String getRandomEmailAddress(){
        return getRamdomEmailAddresses(1).stream().findFirst().get();
    }
}
