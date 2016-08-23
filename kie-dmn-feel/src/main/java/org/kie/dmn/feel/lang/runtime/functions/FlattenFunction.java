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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class FlattenFunction
        extends BaseFEELFunction {

    public FlattenFunction() {
        super( "flatten" );
    }

    public List apply(@ParameterName( "list" ) Object list) {
        if ( list == null ) {
            return null;
        }
        // spec requires us to return a new list
        List result = new ArrayList();
        flattenList( list, result );
        return result;
    }

    private void flattenList(Object list, List result) {
        if( list instanceof Collection ) {
            for( Object element : ((Collection)list) ) {
                if( element instanceof Collection ) {
                    flattenList( element, result );
                } else {
                    result.add( element );
                }
            }
        } else {
            result.add( list );
        }
    }

}