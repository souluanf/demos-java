package dev.luanfernandes.demos.xml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Doc3040")
@XmlAccessorType(FIELD)
public class Doc {
    
    @XmlAttribute(name = "DtBase")
    private String dtBase;
    
    @XmlAttribute(name = "CNPJ")
    private String cnpj;
    
    @XmlAttribute(name = "Parte")
    private String parte;
    
    @XmlAttribute(name = "Remessa")
    private String remessa;
    
    @XmlAttribute(name = "TpArq")
    private String tpArq;
    
    @XmlAttribute(name = "NomeResp")
    private String nomeResp;
    
    @XmlAttribute(name = "EmailResp")
    private String emailResp;
    
    @XmlAttribute(name = "TelResp")
    private String telResp;
    
    @XmlAttribute(name = "TotalCli")
    private String totalCli;
    
    @XmlElement(name = "Cli")
    private List<Cli> clientes;
}