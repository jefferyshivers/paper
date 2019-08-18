package io.tacolabs.paper;

public interface PaperRenderer<T extends PaperDocument> {
    public void render(T source) throws PaperException;
}
