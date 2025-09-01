package dev.luanfernandes.demos.xml;

import dev.luanfernandes.demos.xml.dto.Doc;
import dev.luanfernandes.demos.xml.service.XmlService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import static dev.luanfernandes.demos.xml.service.XmlMockGenerator.criarDocumento;

@Component
@RequiredArgsConstructor
public class XmlInitGenerator implements CommandLineRunner {

    private final XmlService xmlService;

    @Override
    public void run(String... args) {
        Doc doc = criarDocumento();
        String xml = xmlService.gerarXML(doc);
        System.out.println(xml);
    }


}
