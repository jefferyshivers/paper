package io.tacolabs.paper.plugins.html;

import io.tacolabs.paper.PaperDocumentException;
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

    private ImmutableHTMLDocument(Document document) throws ParserConfigurationException {
        super(document);
    }

    public static ImmutableHTMLDocument from(File file) throws ParserConfigurationException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(file));
    }

    public static ImmutableHTMLDocument from(String fileString) throws ParserConfigurationException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(fileString));
    }

    public static ImmutableHTMLDocument from(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(inputStream));
    }

    public static ImmutableHTMLDocument from(URI uri) throws ParserConfigurationException, SAXException, IOException {
        return new ImmutableHTMLDocument(createDocumentBuilder().parse(uri.toString()));
    }

    private static DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    @Override
    public Document getDocument() throws PaperDocumentException {
        Node root = document.getDocumentElement();
        Document copy;

        try {
            copy = createDocument();
            copy.importNode(root, true);
            return copy;
        } catch (ParserConfigurationException parserConfigException) {
            logger.info(parserConfigException.getMessage());
            throw new PaperDocumentException();
        }
    }

}
