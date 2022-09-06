package com.redhat.simple.calculator;

import java.security.SecureRandom;
import java.util.Random;

public final class BasicCalculator extends Calculator {

    public static final Random RAND = new SecureRandom();

    public int random() {
        //var r = new Random();
        return RAND.nextInt();
    }
}
