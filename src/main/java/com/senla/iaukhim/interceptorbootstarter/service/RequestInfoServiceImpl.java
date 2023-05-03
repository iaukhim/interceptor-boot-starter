package com.senla.iaukhim.interceptorbootstarter.service;

import com.senla.iaukhim.interceptorbootstarter.entities.RequestInfo;
import com.senla.iaukhim.interceptorbootstarter.repository.RequestInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RequestInfoServiceImpl implements RequestInfoService {

    private final RequestInfoRepository requestInfoRepository;

    @Autowired
    public RequestInfoServiceImpl(RequestInfoRepository requestInfoRepository) {
        this.requestInfoRepository = requestInfoRepository;
    }

    @Override
    public String save(RequestInfo requestInfo) {
        RequestInfo savedEntity = requestInfoRepository.save(requestInfo);
        return savedEntity.getId();
    }
}
