package io.tacolabs.paper;

/**
 * Implementations of Paper objects should throw an instance of this whenever possible
 */
public abstract class PaperException extends Exception {

    /**
     * Required super constructor
     * @param message
     */
    protected PaperException(final String message) {
        super(message);
    }

}
