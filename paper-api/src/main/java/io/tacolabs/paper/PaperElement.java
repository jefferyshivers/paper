package io.tacolabs.paper;

/**
 * A building block class based on PaperDocument
 * @param <T>
 */
public interface PaperElement<T> {

    /**
     * Retrieve the source "element" object
     * @return T element
     */
    public T getElement();

}
