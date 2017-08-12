package com.github.spb.tget.uitests.utils;

import java.util.function.Supplier;

public class ExecutionContext {

    public static void executeForSuccess(Runnable runnable, int attemptsCount, long sleepIntervalInMillis) {
        RuntimeException targetException = null;

        for (int i = 0; i < attemptsCount; i++) {
            try {
                runnable.run();
                return;
            } catch (RuntimeException exception) {
                targetException = exception;
            }
            try {
                Thread.sleep(sleepIntervalInMillis);
            } catch (InterruptedException exception) {
                throw new RuntimeException(exception);
            }
        }

        throw targetException;
    }

    public static void executeForCondition(Supplier<Boolean> predicate, int attemptsCount, long sleepIntervalInMillis) {
        int i = 0;

        while (!predicate.get()) {
            i++;
            try {
                Thread.sleep(sleepIntervalInMillis);
            } catch (InterruptedException interruptedException) {
                throw new RuntimeException(interruptedException);
            }

            if (i >= attemptsCount) {
                throw new RuntimeException(
                        String.format("Cannot satisfy condition after %d attempts with %d milliseconds interval",
                                attemptsCount, sleepIntervalInMillis));
            }
        }
    }
}
