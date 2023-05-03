package com.senla.iaukhim.interceptorbootstarter.service;

import com.senla.iaukhim.interceptorbootstarter.entities.RequestInfo;
import jakarta.servlet.http.HttpServletRequest;

public interface RequestInfoService {

    String save(RequestInfo requestInfo);

    RequestInfo fromHttpServletRequest(HttpServletRequest httpServletRequest);
}
