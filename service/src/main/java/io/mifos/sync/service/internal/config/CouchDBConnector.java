package io.mifos.sync.service.internal.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CouchDBConnector {

    private RestTemplate restTemplate;

    private final CouchDBConnectionProperties couchDBConnectionProperties;

    @Autowired
    public CouchDBConnector(RestTemplateBuilder restTemplateBuilder, CouchDBConnectionProperties couchDBConnectionProperties){
        this.restTemplate = restTemplateBuilder.build();
        this.couchDBConnectionProperties = couchDBConnectionProperties;

    }

    public ResponseEntity<Object> connectToCouchDB(){
        return this.restTemplate.getForEntity(couchDBConnectionProperties.getCouchDbHost() +
                ":" + couchDBConnectionProperties.getCouchDbPort()
                + "/{database}", Object.class, couchDBConnectionProperties.getCouchDbDatabase());
    }


}
