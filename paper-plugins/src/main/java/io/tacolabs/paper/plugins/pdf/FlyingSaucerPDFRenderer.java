package io.tacolabs.paper.plugins.pdf;

import io.tacolabs.paper.PaperRenderer;
import io.tacolabs.paper.plugins.html.HTMLDocument;
import java.io.IOException;
import java.io.OutputStream;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFCreationListener;
import org.xhtmlrenderer.pdf.util.XHtmlMetaToPdfInfoAdapter;

public class FlyingSaucerPDFRenderer implements PaperRenderer<HTMLDocument> {

    private final OutputStream outputStream;

    public FlyingSaucerPDFRenderer(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void render(HTMLDocument source) {
        try {
            ITextRenderer iTextRenderer = new ITextRenderer();

            Document document = source.getDocument();
            iTextRenderer.setDocument(document, null);

            // to apply metadata from html to the pdf
            PDFCreationListener metadataPopulation = new XHtmlMetaToPdfInfoAdapter(document);
            iTextRenderer.setListener(metadataPopulation);

            iTextRenderer.layout();
            iTextRenderer.createPDF(outputStream);
        } catch (Exception exception) {
            // ...

        } finally {
            closeOutputStream();
        }
    }

    private void closeOutputStream() {
        try {
            outputStream.close();
        } catch (IOException e) {
            // ...
        }
    }

}
