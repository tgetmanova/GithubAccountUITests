package com.github.spb.tget.uitests.utils;

import net.schmizz.sshj.common.Buffer;

import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class SshKeyUtils {

    private static final String[] KEY_PAIR_GENERATION_ALGORITHMS = new String[]{"RSA", "DSA"};

    private static final String NUMBER_GENERATION_ALGORITHM = "SHA1PRNG";

    public static String getValidSshKey() {
        KeyPairGenerator generator;
        String algorithm = getRandomAlgorithm();
        try {
            generator = KeyPairGenerator.getInstance(algorithm);
            SecureRandom random = SecureRandom.getInstance(NUMBER_GENERATION_ALGORITHM);
            generator.initialize(1024, random);
        } catch (NoSuchAlgorithmException algException) {
            throw new RuntimeException(algException);
        }

        KeyPair keys = generator.generateKeyPair();

        PublicKey publicKey = keys.getPublic();

       return Base64.getEncoder().encodeToString(new Buffer.PlainBuffer().putPublicKey(publicKey).getCompactData());
    }

    private static String getRandomAlgorithm(){
        return (String)RandomUtils.getRandomElement(Arrays.asList(KEY_PAIR_GENERATION_ALGORITHMS));
    }
}
