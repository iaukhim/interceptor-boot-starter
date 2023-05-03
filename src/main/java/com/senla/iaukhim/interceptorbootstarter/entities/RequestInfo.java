package com.senla.iaukhim.interceptorbootstarter.entities;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Document
public class RequestInfo {

    @Id
    private String Id;

    private String requestUrl;

    private Map<String, String> headers = new HashMap<>();


    public RequestInfo(HttpServletRequest request) {
        setRequestUrl(request.getRequestURL().toString());

        List<String> headersNames = new ArrayList<>();
        Iterator<String> iterator = request.getHeaderNames().asIterator();
        iterator.forEachRemaining(n -> {
            if (Objects.nonNull(n)) {
                headersNames.add(n);
            }
        });
        headersNames.forEach(n -> {
            Enumeration<String> requestHeaders = request.getHeaders(n);
            StringBuilder headerValue = new StringBuilder();
            requestHeaders.asIterator().forEachRemaining(value -> headerValue.append(value + "/n"));
            headers.put(n, headerValue.toString());
        });
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
