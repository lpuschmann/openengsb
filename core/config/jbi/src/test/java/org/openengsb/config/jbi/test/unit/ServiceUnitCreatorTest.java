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
package org.openengsb.config.jbi.test.unit;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.openengsb.config.jbi.ServiceUnitCreator;
import org.openengsb.config.jbi.types.ComponentType;
import org.w3c.dom.Document;

public class ServiceUnitCreatorTest {
    @Test
    public void writeJbiXmlFile_shouldWriteTheComponentType() throws Exception {
        MapNamespaceContext ns = new MapNamespaceContext();
        ns.addNamespace("jbi", "http://java.sun.com/xml/ns/jbi");
        XPath xpath = newXPath(ns);

        ComponentType component = new ComponentType();
        component.setBindingComponent(true);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ServiceUnitCreator.writeJbiXmlFile(out, component);

        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        Document doc = parseDocument(in);
        Object attr = xpath.evaluate("/jbi:jbi/jbi:services/@binding-component", doc.getDocumentElement(), XPathConstants.STRING);
        assertEquals("true", attr);
    }

    private Document parseDocument(InputStream in) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        try {
            return dbf.newDocumentBuilder().parse(in);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private XPath newXPath(MapNamespaceContext ns) {
        XPathFactory fac = XPathFactory.newInstance();
        XPath xpath = fac.newXPath();
        xpath.setNamespaceContext(ns);
        return xpath;
    }
}
