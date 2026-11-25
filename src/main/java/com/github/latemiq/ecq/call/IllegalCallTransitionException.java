package com.github.latemiq.ecq.call;

public class IllegalCallTransitionException extends RuntimeException {

        public IllegalCallTransitionException(CallStatus from, CallStatus to) {
            super("Call cannot go from " + from + " to " + to);
        }

    }
