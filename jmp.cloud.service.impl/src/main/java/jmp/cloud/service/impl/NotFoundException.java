package jmp.cloud.service.impl;

/**
 * Custom Exception
 */
public class NotFoundException extends Exception {
    public NotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
