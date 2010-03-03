#!/bin/bash
#
#   Copyright 2010 OpenEngSB Division, Vienna University of Technology
#
#   Licensed under the Apache License, Version 2.0 (the "License");
#   you may not use this file except in compliance with the License.
#   You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#   Unless required by applicable law or agreed to in writing, software
#   distributed under the License is distributed on an "AS IS" BASIS,
#   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#   See the License for the specific language governing permissions and
#   limitations under the License.
#

# general introduction to handle whitespaces in files may be introduced in future
set -eu
IFS=`printf '\n\t'`

cd $(dirname $0)
SCRIPT_DIR=`pwd`
cd $SCRIPT_DIR/../package/test
mvn jbi:projectDeploy -DforceUpdate=true
cd $SCRIPT_DIR/../core/testclient/jms/swingclient 
mvn -e exec:java -Dexec.mainClass=org.openengsb.swingclient.Start

