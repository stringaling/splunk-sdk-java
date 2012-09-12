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

import java.util.Map;

/**
 * The {@code SavedSearchCollection} class represents a collection of saved
 * searches.
 */
public class SavedSearchCollection extends EntityCollection<SavedSearch> {

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     */
    SavedSearchCollection(Service service) {
        super(service, "saved/searches", SavedSearch.class);
    }

    /**
     * Class constructor.
     *
     * @param service The connected {@code Service} instance.
     * @param args Arguments to use when you instantiate the entity, such as 
     * "count" and "offset".
     */
    SavedSearchCollection(Service service, Args args) {
        super(service, "saved/searches", SavedSearch.class, args);
    }

    /** {@inheritDoc} */
    @Override public SavedSearch create(String name) {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates a saved search from a name and search expression.
     *
     * @param name The name for the search.
     * @param search The search expression.
     * @return The new saved search.
     */
    public SavedSearch create(String name, String search) {
        Args args = new Args("search", search);
        return create(name, args);
    }

    /**
     * Creates a saved search from a name, search expression, and
     * additional arguments.
     *
     * @param name The name for the search.
     * @param search The search expression.
     * @param args Additional arguments.
     * @return The new saved search.
     */
    public SavedSearch create(String name, String search, Map args) {
        args = Args.create(args).add("search", search);
        return create(name, args);
    }
}