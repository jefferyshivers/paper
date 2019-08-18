package io.tacolabs.paper.plugins.html;

import org.w3c.dom.Element;

/**
 * Object for building a document from scratch
 */
public class BasicHTMLDocument extends HTMLDocument {

    private final Element head;
    private final Element body;

    public BasicHTMLDocument() throws HTMLDocumentException {
        super();

        Element html = document.createElement("html");
        document.appendChild(html);

        head = document.createElement("head");
        html.appendChild(head);

        body = document.createElement("body");
        html.appendChild(body);
    }

    public Element getHead() {
        return head;
    }

    public Element getBody() {
        return body;
    }

}
