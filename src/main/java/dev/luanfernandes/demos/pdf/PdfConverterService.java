package dev.luanfernandes.demos.pdf;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Slf4j
@Service
public class PdfConverterService {

    /**
     * Converte um documento DOCX para PDF.
     *
     * @param docxInputStream InputStream do documento DOCX.
     * @return ByteArrayInputStream do documento PDF convertido.
     */
    public ByteArrayInputStream convertToPdf(ByteArrayInputStream docxInputStream) {
        try (ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
             XWPFDocument document = new XWPFDocument(docxInputStream)) {
            
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(document, pdfOutputStream, options);
            
            log.info("Conversão DOCX para PDF concluída com sucesso ({} bytes)", pdfOutputStream.size());
            return new ByteArrayInputStream(pdfOutputStream.toByteArray());
            
        } catch (Exception e) {
            log.error("Erro ao converter DOCX para PDF", e);
            throw new RuntimeException("Erro ao converter DOCX para PDF: " + e.getMessage(), e);
        }
    }
}