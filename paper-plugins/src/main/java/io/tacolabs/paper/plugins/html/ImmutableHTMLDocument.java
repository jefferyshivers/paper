package io.tacolabs.paper.plugins.html;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Create an immutable instance of HTMLDocument from any source that {@link DocumentBuilder} can parse
 */
public class ImmutableHTMLDocument extends HTMLDocument {

    private static final Logger logger = LoggerFactory.getLogger(ImmutableHTMLDocument.class);

    private ImmutableHTMLDocument(final Document document) throws HTMLDocumentException {
        super(duplicateDocument(document));
    }

    public static ImmutableHTMLDocument from(Document document) throws HTMLDocumentException {
        return new ImmutableHTMLDocument(document);
    }

    public static ImmutableHTMLDocument from(File file) throws HTMLDocumentException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(file));
    }

    public static ImmutableHTMLDocument from(String fileString) throws HTMLDocumentException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(fileString));
    }

    public static ImmutableHTMLDocument from(InputStream inputStream) throws HTMLDocumentException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(inputStream));
    }

    public static ImmutableHTMLDocument from(URI uri) throws HTMLDocumentException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(uri.toString()));
    }

    private static DocumentBuilder createDocumentBuilder() throws HTMLDocumentException {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException parserConfigException) {
            throw new HTMLDocumentException("", parserConfigException);
        }
    }

    private static Document duplicateDocument(final Document original) throws HTMLDocumentException {
        Node root = original.getDocumentElement();
        Document copy = createDocument();
        copy.importNode(root, true);
        return copy;
    }

}
