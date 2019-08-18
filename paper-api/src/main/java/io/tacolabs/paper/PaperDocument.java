package io.tacolabs.paper;

/**
 * The parent object processed by a PaperRenderer
 * @param <T>
 */
public interface PaperDocument<T> {

    /**
     * Retrieve the source "document" object
     * @return T document
     */
    public T getDocument();

}
