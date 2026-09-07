#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

set -e

PROG="$0"
while [ -h "$PROG" ] ; do
    ls=$(ls -ld "$PROG")
    link=$(expr "$ls" : '.*-> \(.*\)$')
    if expr "$link" : '/.*' > /dev/null; then
        PROG="$link"
    else
        PROG=$(dirname "$PROG")/"$link"
    fi
done

SCRIPTDIR=$(dirname "$PROG")
APP_HOME=$(cd "$SCRIPTDIR" && pwd)

APP_NAME="Gradle"
APP_BASE_NAME=$(basename "$0")

JAR="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
if [ ! -r "$JAR" ]; then
    echo "Error: Gradle wrapper jar not found at $JAR" >&2
    exit 1
fi

if ! command -v java >/dev/null 2>&1; then
    echo "Error: Java not found in PATH" >&2
    exit 1
fi

exec java -Dorg.gradle.appname="$APP_BASE_NAME" -classpath "$JAR" org.gradle.wrapper.GradleWrapperMain "$@"