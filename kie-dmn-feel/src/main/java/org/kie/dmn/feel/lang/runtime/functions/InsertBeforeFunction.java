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

package org.kie.dmn.feel.lang.runtime.functions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InsertBeforeFunction
        extends BaseFEELFunction {

    public InsertBeforeFunction() {
        super( "insert before" );
    }

    public List apply(@ParameterName( "list" ) List list, @ParameterName( "position" ) BigDecimal position, @ParameterName( "newItem" ) Object newItem) {
        if ( list == null || position == null || position.intValue() == 0 || position.abs().intValue() > list.size() ) {
            return null;
        }
        // spec requires us to return a new list
        List result = new ArrayList( list );
        if( position.intValue() > 0 ) {
            result.add( position.intValue()-1, newItem );
        } else {
            result.add( list.size()+position.intValue(), newItem );
        }
        return result;
    }
}