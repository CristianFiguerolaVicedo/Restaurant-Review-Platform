package com.cristian.restaurant.exceptions;

public class StorageException extends BaseException {

    public StorageException() {
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageException(String message) {
        super(message);
    }

    public StorageException(Throwable cause) {
        super(cause);
    }
}
