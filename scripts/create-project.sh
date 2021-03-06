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

# Script for creating projects according to the archetype pattern for the engsb project.
# This script takes two parameters where the first one specifies which archetype to
# take where all archetypes could be found here: 
# http://www.mavenreposearch.com/browsegroups/o/org.apache.servicemix.tooling
# The second parameter takes the artifactId of the newly generated project. 

if [ $# -ne 2 ] ; then
  echo Usage: $0 ArchetypeArtifactId ArtifactId
  exit 1
fi

mvn archetype:create -DarchetypeGroupId=org.apache.servicemix.tooling -DarchetypeArtifactId=$1 -DgroupId=org.openengsb -DartifactId=$2

