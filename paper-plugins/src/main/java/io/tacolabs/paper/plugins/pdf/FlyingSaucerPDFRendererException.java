package io.tacolabs.paper.plugins.pdf;

import io.tacolabs.paper.PaperException;

public class FlyingSaucerPDFRendererException extends PaperException {

    public FlyingSaucerPDFRendererException(final String message) {
        super(message);
    }

    public FlyingSaucerPDFRendererException(final String message, Throwable cause) {
        super(message);
        this.initCause(cause);
    }

}
