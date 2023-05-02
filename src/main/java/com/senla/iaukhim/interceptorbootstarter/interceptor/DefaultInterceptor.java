package com.senla.iaukhim.interceptorbootstarter.interceptor;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class DefaultInterceptor extends OncePerRequestFilter implements Interceptor{
    @Override
    public void handleRequest(HttpServletRequest request) {
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");
        System.out.println("*&*&*&*&*&*&*&*&");

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        handleRequest(request);
        filterChain.doFilter(request, response);
    }
}
