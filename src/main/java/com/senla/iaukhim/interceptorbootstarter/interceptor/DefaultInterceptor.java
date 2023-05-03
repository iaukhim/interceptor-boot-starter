package com.senla.iaukhim.interceptorbootstarter.interceptor;

import com.senla.iaukhim.interceptorbootstarter.entities.RequestInfo;
import com.senla.iaukhim.interceptorbootstarter.service.RequestInfoService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class DefaultInterceptor extends OncePerRequestFilter implements Interceptor{

    private final RequestInfoService requestInfoService;

    @Autowired
    public DefaultInterceptor(RequestInfoService requestInfoService) {
        this.requestInfoService = requestInfoService;
    }

    @Override
    public void handleRequest(HttpServletRequest request) {
        requestInfoService.save(new RequestInfo(request));

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        handleRequest(request);
        filterChain.doFilter(request, response);
    }
}
