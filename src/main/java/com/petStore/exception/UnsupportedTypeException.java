package com.petStore.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class UnsupportedTypeException extends IllegalArgumentException {

    public UnsupportedTypeException(String message) { super(message);}
}
