package com.senla.iaukhim.interceptorbootstarter.service;

import com.senla.iaukhim.interceptorbootstarter.entities.RequestInfo;
import com.senla.iaukhim.interceptorbootstarter.repository.RequestInfoRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class RequestInfoServiceImpl implements RequestInfoService {

    @Autowired
    private final RequestInfoRepository requestInfoRepository;

    public RequestInfoServiceImpl(RequestInfoRepository requestInfoRepository) {
        this.requestInfoRepository = requestInfoRepository;
    }

    @Override
    public String save(RequestInfo requestInfo) {
        RequestInfo savedEntity = requestInfoRepository.save(requestInfo);
        return savedEntity.getId();
    }

    @Override
    public RequestInfo fromHttpServletRequest(HttpServletRequest request) {
        RequestInfo requestInfo = new RequestInfo();
        requestInfo.setRequestUrl(request.getRequestURL().toString());

        List<String> headersNames = new ArrayList<>();
        Iterator<String> iterator = request.getHeaderNames().asIterator();
        iterator.forEachRemaining(n -> {
            if (Objects.nonNull(n)) {
                headersNames.add(n);
            }
        });
        Map<String, String> headers = requestInfo.getHeaders();
        headersNames.forEach(n -> {
            Enumeration<String> requestHeaders = request.getHeaders(n);
            StringBuilder headerValue = new StringBuilder();
            requestHeaders.asIterator().forEachRemaining(value -> headerValue.append(value + "/n"));
            headers.put(n, headerValue.toString());
        });

        return requestInfo;
    }
}
