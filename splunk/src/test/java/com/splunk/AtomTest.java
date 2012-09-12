/*
 * Copyright 2012 Splunk, Inc.
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
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AtomTest extends SplunkTestCase {

    private static 
    InputStream openFile(String filename) throws FileNotFoundException {
        InputStream inputStream = AtomTest.class.getResourceAsStream(filename);
        return inputStream;
    }

    @Test public void test() throws FileNotFoundException {
        String tests[] = { "/com/splunk/jobs.xml" };

        for (String test : tests) {
            InputStream stream = openFile(test);
            AtomFeed feed = AtomFeed.parseStream(stream);
            // UNDONE: Validate feed.
        }
    }
}

