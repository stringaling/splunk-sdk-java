/*
 * Copyright 2011 Splunk, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"): you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.splunk;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LicenseSlaveTest extends SplunkTestCase {
    final static String assertRoot = "License Slave assert: ";

    @Test public void testLicenseSlave() throws Exception {
        Service service = connect();

        EntityCollection<LicenseSlave> licenseSlaves = 
                service.getLicenseSlaves();

        // list of pools
        List<String> pools = Arrays.asList(
            "auto_generated_pool_download-trial",
            "auto_generated_pool_enterprise",
            "auto_generated_pool_forwarder",
            "auto_generated_pool_free");

        List<String> stacks = Arrays.asList(
             "download-trial", "enterprise", "forwarder", "free");

        for (LicenseSlave licenseSlave: licenseSlaves.values()) {
            assertTrue(assertRoot + "#1", licenseSlave.getLabel().length() > 0);
            for (String pool: licenseSlave.getPoolIds()) {
                // Special-case, fixed sourcetype has a hash at the end; so
                // no fixed value will match. Thus only check versus known
                // fixed values from list.
                if (!pool.startsWith("auto_generated_pool_fixed-sourcetype_")) {
                    assertTrue(assertRoot + "#2", pools.contains(pool));
                }
            }
            for (String stack: licenseSlave.getStackIds()) {
                assertTrue(assertRoot + "#3", stacks.contains(stack));
            }
        }
    }
}
