/*
 * Copyright 2016 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.dmn.core.impl;

import org.kie.dmn.core.runtime.DMNContext;
import org.kie.dmn.core.runtime.DMNModel;
import org.kie.dmn.core.runtime.DMNResult;
import org.kie.dmn.feel.model.v1_1.Definitions;

public class DMNModelImpl implements DMNModel {

    private Definitions definitions;

    public DMNModelImpl() {
    }

    public DMNModelImpl(Definitions definitions) {
        this.definitions = definitions;
    }

    public Definitions getDefinitions() {
        return definitions;
    }

    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }

    public String getName() {
        return definitions != null ? definitions.getName() : null;
    }

    @Override
    public DMNResult evaluateAll(DMNContext context) {
        return null;
    }

    @Override
    public DMNResult evaluateDecision(String decisionName, DMNContext context) {
        return null;
    }
}