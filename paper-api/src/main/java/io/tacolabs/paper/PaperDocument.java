package io.tacolabs.paper;

/**
 * The parent object processed by a PaperRenderer
 * @param <T>
 */
public interface PaperDocument<T> {
    public T getDocument() throws PaperDocumentException;
}
