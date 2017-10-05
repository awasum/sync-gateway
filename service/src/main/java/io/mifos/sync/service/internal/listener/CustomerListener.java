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
package io.mifos.sync.service.internal.listener;

import io.mifos.core.lang.config.TenantHeaderFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import io.mifos.core.test.listener.EventRecorder;
import io.mifos.customer.api.v1.CustomerEventConstants;



public class CustomerListener {

    private final EventRecorder eventRecorder;

    @Autowired
    public CustomerListener(final EventRecorder eventRecorder) {
        this.eventRecorder = eventRecorder;
    }

    @JmsListener(
            destination = CustomerEventConstants.DESTINATION,
            selector = CustomerEventConstants.SELECTOR_POST_CUSTOMER
    )
    public void customerCreatedEvent(@Header(TenantHeaderFilter.TENANT_HEADER) final String tenant,
                                     final String payload) {
        this.eventRecorder.event(tenant, CustomerEventConstants.POST_CUSTOMER, payload, String.class);

        //We get the customer (JSON) via REST by making a call to Kuelap IO
        // using the customerId as Filter.
        //Get CouchDB Connection properties and connect
        //we find the customer document in the couchdb {tenant} database.
        // Making sure it does not exist.
        //We update the customer document with the new customer.
    }

    @JmsListener(
            destination = CustomerEventConstants.DESTINATION,
            selector = CustomerEventConstants.SELECTOR_PUT_CUSTOMER
    )
    public void customerUpdatedEvents(@Header(TenantHeaderFilter.TENANT_HEADER) final String tenant,
                                      final String payload) {
        this.eventRecorder.event(tenant, CustomerEventConstants.PUT_CUSTOMER, payload, String.class);
    }

    @JmsListener(
            destination = CustomerEventConstants.DESTINATION,
            selector = CustomerEventConstants.SELECTOR_ACTIVATE_CUSTOMER
    )
    public void customerActivatedEvent(@Header(TenantHeaderFilter.TENANT_HEADER) final String tenant,
                                       final String payload) {
        this.eventRecorder.event(tenant, CustomerEventConstants.ACTIVATE_CUSTOMER, payload, String.class);
    }
}
