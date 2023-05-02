package com.senla.iaukhim.interceptorbootstarter.interceptor;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletRequest;

public interface Interceptor extends Filter {

    void handleRequest(HttpServletRequest request);
}
