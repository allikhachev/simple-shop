package com.ocmwdt.edu.simpleshop.exceptions;

public class AppError extends RuntimeException {
    public AppError() {
    }

    public AppError(String message) {
        super(message);
    }
}
