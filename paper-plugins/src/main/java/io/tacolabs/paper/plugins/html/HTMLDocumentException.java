package io.tacolabs.paper.plugins.html;

import io.tacolabs.paper.PaperException;

public class HTMLDocumentException extends PaperException {

    public HTMLDocumentException(final String message) {
        super(message);
    }

    public HTMLDocumentException(final String message, final Throwable cause) {
        super(message);
        this.initCause(cause);
    }

}
