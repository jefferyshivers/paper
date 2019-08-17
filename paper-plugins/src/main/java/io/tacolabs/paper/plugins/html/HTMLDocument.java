package io.tacolabs.paper.plugins.html;

import io.tacolabs.paper.PaperDocument;
import io.tacolabs.paper.PaperDocumentException;
import io.tacolabs.paper.PaperInstantiationException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

/**
 * Paper wrapper around {@link org.w3c.dom.Document}
 */
public abstract class HTMLDocument implements PaperDocument<Document> {

    protected final Document document;

    protected HTMLDocument() throws PaperInstantiationException {
        try {
            this.document = createDocument();
        } catch (ParserConfigurationException parserConfigException) {
            throw new PaperInstantiationException("failed to create new Document");
        }
    }

    protected HTMLDocument(Document document) {
        this.document = document;
    }

    protected static Document createDocument() throws ParserConfigurationException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    }

    public Document getDocument() throws PaperDocumentException {
        return document;
    }

}
