package com.soap.stack;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException() {
        super();
    }

    public EmptyStackException(String message) {
        super("Stack이 비어있습니다.");
    }
}
