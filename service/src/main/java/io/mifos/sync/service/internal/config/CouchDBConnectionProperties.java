package io.mifos.sync.service.internal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDBConnectionProperties {

    @Value("${couchdb.host}")
    private String couchDbHost ;

    @Value("${couchdb.port}")
    private String couchDbPort;

    @Value("${couchdb.user}")
    private String couchDbUser;

    @Value("${couchdb.password}")
    private String couchDbPassword;

    public CouchDBConnectionProperties(){

    }

    public String getCouchDbHost() {
        return couchDbHost;
    }

    public String getCouchDbPort() {
        return couchDbPort;
    }

    public String getCouchDbUser() {
        return couchDbUser;
    }

    public String getCouchDbPassword() {
        return couchDbPassword;
    }





}
