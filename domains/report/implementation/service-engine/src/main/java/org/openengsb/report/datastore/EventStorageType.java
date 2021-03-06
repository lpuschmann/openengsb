/**

   Copyright 2010 OpenEngSB Division, Vienna University of Technology

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
 */
package org.openengsb.report.datastore;

import edu.emory.mathcs.backport.java.util.Arrays;

public enum EventStorageType {

    contextId, correlationId, workflowId, workflowInstanceId;

    public static EventStorageType fromString(String string) {
        for (EventStorageType type : EventStorageType.values()) {
            if (type.toString().equals(string)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown event storage type. Only "
                + Arrays.toString(EventStorageType.values()) + " are supported.");
    }

}
