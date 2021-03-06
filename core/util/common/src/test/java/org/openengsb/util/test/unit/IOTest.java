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
package org.openengsb.util.test.unit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;

import org.junit.Ignore;
import org.junit.Test;
import org.openengsb.util.IO;


public class IOTest {
    @Test
    public void combineWithNoArguments() {
        assertThat(IO.combine(""), is(""));
    }

    @Test
    public void combineWithOneRelativeFile() {
        assertThat(IO.combine("relativeFile"), is("relativeFile"));
    }

    @Test
    public void combineTwoPaths() {
        final File file = new File(IO.combine("foo", "bar.txt"));
        assertThat(file.getName(), is("bar.txt"));
        assertThat(file.getParent(), is("foo"));
    }

    @Test
    public void relativizeWithTwoAbsolutePaths() {
        final String base = "/foo/bar";
        final String path = base + "/baz.txt";
        assertThat(IO.relativize(base, path), is("baz.txt"));
    }

    @Test
    @Ignore
    // TODO find a way this works for windows
    public void relativizeWithDifferentBase() {
        final String base = "/foo/bar";
        final String path = "/bar/foo/baz.txt";
        assertThat(IO.relativize(base, path), is(path));
    }
}
