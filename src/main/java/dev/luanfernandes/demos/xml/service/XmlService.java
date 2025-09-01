package dev.luanfernandes.demos.xml.service;

import dev.luanfernandes.demos.xml.dto.Doc;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

import static javax.xml.bind.Marshaller.JAXB_ENCODING;
import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

@Service
public class XmlService {

    public String gerarXML(Doc doc) {
        try {
            JAXBContext context = JAXBContext.newInstance(Doc.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(JAXB_FORMATTED_OUTPUT, true);
            marshaller.setProperty(JAXB_ENCODING, "utf-8");
            marshaller.setProperty("com.sun.xml.bind.indentString", "   ");
            
            StringWriter writer = new StringWriter();
            marshaller.marshal(doc, writer);
            String xml = writer.toString();
            
            return xml.replace(" standalone=\"yes\"", "")
                     .replaceAll("\\r\\n", "\n")
                     .replaceAll("\\r", "\n");
        } catch (JAXBException e) {
            throw new RuntimeException("Erro ao gerar XML: " + e.getMessage(), e);
        }
    }
}
