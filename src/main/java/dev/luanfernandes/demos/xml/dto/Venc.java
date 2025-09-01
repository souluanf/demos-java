package dev.luanfernandes.demos.xml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.namespace.QName;
import java.util.Map;
import java.util.TreeMap;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(FIELD)
public class Venc {
    
    @XmlAnyAttribute
    @Builder.Default
    private Map<QName, String> atributos = new TreeMap<>((q1, q2) -> {
        String name1 = q1.getLocalPart();
        String name2 = q2.getLocalPart();
        if (name1.startsWith("v") && name2.startsWith("v")) {
            try {
                Integer num1 = Integer.parseInt(name1.substring(1));
                Integer num2 = Integer.parseInt(name2.substring(1));
                return num1.compareTo(num2);
            } catch (NumberFormatException e) {
                return name1.compareTo(name2);
            }
        }
        return name1.compareTo(name2);
    });
    
    public void addAtributo(String nome, String valor) {
        atributos.put(new QName(nome), valor);
    }

    public Venc withAtributo(String nome, String valor) {
        addAtributo(nome, valor);
        return this;
    }

    public String getAtributo(String nome) {
        return atributos.get(new QName(nome));
    }
}