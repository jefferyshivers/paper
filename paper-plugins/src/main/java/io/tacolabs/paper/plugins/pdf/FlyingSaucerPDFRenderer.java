package io.tacolabs.paper.plugins.pdf;

import io.tacolabs.paper.PaperRenderer;
import io.tacolabs.paper.plugins.html.HTMLDocument;
import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.PDFCreationListener;
import org.xhtmlrenderer.pdf.util.XHtmlMetaToPdfInfoAdapter;

public class FlyingSaucerPDFRenderer implements PaperRenderer<HTMLDocument> {

    private static final Logger logger = LoggerFactory.getLogger(FlyingSaucerPDFRenderer.class);

    private final OutputStream outputStream;

    public FlyingSaucerPDFRenderer(final OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void render(final HTMLDocument source) throws FlyingSaucerPDFRendererException {
        try {
            ITextRenderer iTextRenderer = new ITextRenderer();

            Document document = source.getDocument();
            iTextRenderer.setDocument(document, null);

            // to apply metadata from html to the pdf
            PDFCreationListener metadataPopulation = new XHtmlMetaToPdfInfoAdapter(document);
            iTextRenderer.setListener(metadataPopulation);

            // render the PDF
            iTextRenderer.layout();
            iTextRenderer.createPDF(outputStream);
        } catch (Exception exception) {
            String customMessage = "Unexpected exception, failed to render PDF";
            logger.error("{}. Exception message: " + exception.getMessage(), customMessage);
            throw new FlyingSaucerPDFRendererException(customMessage, exception);
        } finally {
            closeOutputStream();
        }
    }

    private void closeOutputStream() throws FlyingSaucerPDFRendererException {
        try {
            outputStream.close();
        } catch (IOException e) {
            String message = "Failed to close output stream";
            logger.error(message);
            throw new FlyingSaucerPDFRendererException(message);
        }
    }

}
