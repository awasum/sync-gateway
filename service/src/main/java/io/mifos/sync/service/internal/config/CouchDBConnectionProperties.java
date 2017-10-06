/*
 * Copyright 2017 The Mifos Initiative.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.sync.service.internal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouchDBConnectionProperties {

    @Value("${couchdb.host}")
    private String couchDbHost ;

    @Value("${couchdb.port}")
    private String couchDbPort;

    @Value("${couchdb.database}")
    private String couchDbDatabase;

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

    public String getCouchDbDatabase(){
        return couchDbDatabase;
    }

    public String getCouchDbUser() {
        return couchDbUser;
    }

    public String getCouchDbPassword() {
        return couchDbPassword;
    }





}
