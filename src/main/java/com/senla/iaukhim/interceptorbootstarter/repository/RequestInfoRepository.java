package com.senla.iaukhim.interceptorbootstarter.repository;

import com.senla.iaukhim.interceptorbootstarter.entities.RequestInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestInfoRepository extends MongoRepository<RequestInfo, String> {
}
