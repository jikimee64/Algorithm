package com.soap.stack;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException() {
        super();
    }

    public StackEmptyException(String message) {
        super("Stack이 비어있습니다.");
    }
}
