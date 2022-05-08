package com.socurites.twootr.util;

import org.bouncycastle.crypto.generators.SCrypt;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * Using Bouncy Castle with Scrypt hashing
 */
public class KeyGenerator {
    private static final int SCRYPT_COST = 16384; // 2^14
    private static final int SCRYPT_BLOCK_SIZE = 8;
    private static final int SCRYPT_PARALLELISM = 1;
    private static final int SCRYPT_KEY_LENGTH = 20;

    private static final int SALT_LENGTH = 16;

    private static final SecureRandom secureRandom = new SecureRandom();

    public static byte[] hash(final String password, final byte[] salt) {

        return SCrypt.generate(password.getBytes(StandardCharsets.UTF_16),
                salt,
                SCRYPT_COST,
                SCRYPT_BLOCK_SIZE,
                SCRYPT_PARALLELISM,
                SCRYPT_KEY_LENGTH);
    }

    public static byte[] newSalt() {
        final byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);

        return salt;
    }
}
