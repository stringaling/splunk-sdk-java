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

import org.junit.Test;

public class OutputServerTest extends SplunkTestCase {
    @Test public void testOutputServer() throws Exception {
        Service service = connect();

        EntityCollection<OutputServer> outputServers =
                service.getOutputServers();

        if (outputServers.values().size() == 0) {
            System.out.println("WARNING: OutputServer not configured");
            return;
        }

        for (OutputServer outputServer: outputServers.values()) {
            OutputServerAllConnections outputServerAllConnections =
                    outputServer.allConnections();
            outputServerAllConnections.getDestHost();
            outputServerAllConnections.getDestIp();
            outputServerAllConnections.getDestPort();
            outputServerAllConnections.getSourcePort();
            outputServerAllConnections.getStatus();

            // things we an get
            outputServer.getDestHost();
            outputServer.getDestIp();
            outputServer.getDestPort();
            outputServer.getMethod();
            outputServer.getSourcePort();
            outputServer.getStatus();

            // things we can set.
            // NOTE well, these are only writable, so we cannot check.
            /*
            outputServer.setMethod();
            outputServer.setSslAltNameToCheck();
            outputServer.setSslCertPath();
            outputServer.setSslCipher();
            outputServer.setSslCommonNameToCheck();
            outputServer.setSslPassword();
            outputServer.setsslRootCAPath();
            outputServer.setSslVerifyServerCert();
            */
        }
    }
}
