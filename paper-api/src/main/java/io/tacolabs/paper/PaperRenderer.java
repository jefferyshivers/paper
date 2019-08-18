package io.tacolabs.paper;

/**
 * A PaperRenderer wraps any output "rendering" functionality and is compatible
 * with a specified PaperDocument implementation. For example, a PDF rendering library/service
 * such as Flying Saucer or LaTeX, or even an external API call.
 * @param <T>
 */
public interface PaperRenderer<T extends PaperDocument> {

    /**
     * Render the PaperDocument object
     * @param source
     * @throws PaperException
     */
    public void render(final T source) throws PaperException;

}
