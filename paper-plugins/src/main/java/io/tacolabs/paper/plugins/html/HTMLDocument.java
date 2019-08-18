package io.tacolabs.paper.plugins.html;

import io.tacolabs.paper.PaperDocument;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 * PaperDocument wrapper around {@link org.w3c.dom.Document}
 */
public abstract class HTMLDocument implements PaperDocument<Document> {

    protected final Document document;

    protected HTMLDocument() throws HTMLDocumentException {
        this.document = createDocument();
    }

    protected HTMLDocument(Document document) {
        this.document = document;
    }

    protected static Document createDocument() throws HTMLDocumentException {
        try {
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException parserConfigException) {
            throw new HTMLDocumentException("failed to create new Document instance", parserConfigException);
        }
    }

    public Document getDocument() {
        return document;
    }

}
