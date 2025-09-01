package dev.luanfernandes.demos.xml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;

import java.util.List;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(FIELD)
public class Cli {

    @XmlAttribute(name = "Cd")
    private String cd;

    @XmlAttribute(name = "Tp")
    private String tp;

    @XmlAttribute(name = "IniRelactCli")
    private String iniRelactCli;

    @XmlAttribute(name = "Autorzc")
    private String autorzc;

    @XmlAttribute(name = "FatAnual")
    private String fatAnual;

    @XmlAttribute(name = "PorteCli")
    private String porteCli;

    @XmlAttribute(name = "TpCtrl")
    private String tpCtrl;

    @XmlAttribute(name = "ClassCli")
    private String classCli;

    @XmlAttribute(name = "CongEcon")
    private String congEcon;

    @XmlElement(name = "Op")
    private List<Op> operacoes;
}