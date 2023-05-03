package com.senla.iaukhim.interceptorbootstarter.exceptions;

public class InterceptorPropertiesException extends RuntimeException {
    public InterceptorPropertiesException() {
        super("You have errors in interceptor properties configuration.");
    }
}
