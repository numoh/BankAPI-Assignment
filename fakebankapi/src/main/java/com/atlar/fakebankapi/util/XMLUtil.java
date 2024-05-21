package com.atlar.fakebankapi.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

@Component
public class XMLUtil {

    @Value("${camt053.filepath}")
    private Resource resource;

    public Document loadXMLDocument() {
        try {
            // Load the file from resources
            InputStream inputStream = resource.getInputStream();

            // Parse the XML file
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            return builder.parse(inputStream);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read camt.053.xml file", e);
        }
    }
}
