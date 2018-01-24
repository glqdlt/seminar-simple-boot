package com.glqdlt.simple.ui.services;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;


    public Object postDataPage(String apiUrl, MultiValueMap<?,?> multiValueMap) {
        return this.restTemplate.postForObject(apiUrl, multiValueMap, Object.class);
    }

    public Object[] postDataAll(String apiUrl, MultiValueMap<?,?> multiValueMap) {


        return this.restTemplate.postForObject(apiUrl, multiValueMap, Object[].class);
    }


    public Object[] getDataAll(String apiUrl) {
        return this.restTemplate.getForObject(apiUrl, Object[].class);
    }

    public Object getDataPage(String apiUrl) {
        return this.restTemplate.getForObject(apiUrl, Object.class);
    }


    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
}
