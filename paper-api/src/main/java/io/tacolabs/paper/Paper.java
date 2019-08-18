package io.tacolabs.paper;

import javax.validation.constraints.NotNull;

/**
 * Encapsulates a pair of PaperDocument and PaperRenderer
 * @param <T> an implementation of PaperDocument
 */
public abstract class Paper<T extends PaperDocument> {

    @NotNull
    protected final T paperDocument;
    @NotNull
    protected final PaperRenderer<T> paperRenderer;

    /**
     * Required super constructor
     * @param paperDocument an instance or extended instance of <code>T</code>
     * @param paperRenderer PaperRenderer of <code>T</code>
     */
    public Paper(final T paperDocument, final PaperRenderer<T> paperRenderer) {
        this.paperDocument = paperDocument;
        this.paperRenderer = paperRenderer;
    }

    /**
     * Render the PaperDocument object
     * Simply calls {@link PaperRenderer#render(PaperDocument)}
     * NOTE: This should <i>not</i> be overridden.
     * To change how the document is rendered, change {@link PaperRenderer#render(PaperDocument)} directly.
     * @throws PaperException
     */
    public void render() throws PaperException {
        paperRenderer.render(paperDocument);
    }

}
