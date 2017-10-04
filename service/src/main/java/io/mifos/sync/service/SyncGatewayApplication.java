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
package io.mifos.sync.service;

import io.mifos.sync.service.internal.config.CouchDBConnectionProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SyncGatewayApplication {

  public SyncGatewayApplication() {
    super();
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(SyncGatewayConfiguration.class, args);

    CouchDBConnectionProperties cdb  = context.getBean(CouchDBConnectionProperties.class);

    System.out.printf("CouchDB Host: %s%n CouchDB Port: %s%n " +
            "CouchDB User: %s%n CouchDB Password: %s%n",
            cdb.getCouchDbHost(), cdb.getCouchDbPort(),
            cdb.getCouchDbUser(), cdb.getCouchDbPassword());

  }
}
