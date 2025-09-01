package dev.luanfernandes.demos.xml.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(FIELD)
public class Op {
    
    @XmlAttribute(name = "DetCli")
    private String detCli;
    
    @XmlAttribute(name = "IPOC")
    private String ipoc;
    
    @XmlAttribute(name = "Contrt")
    private String contrt;
    
    @XmlAttribute(name = "Mod")
    private String mod;
    
    @XmlAttribute(name = "Cosif")
    private String cosif;
    
    @XmlAttribute(name = "OrigemRec")
    private String origemRec;
    
    @XmlAttribute(name = "Indx")
    private String indx;
    
    @XmlAttribute(name = "PercIndx")
    private String percIndx;
    
    @XmlAttribute(name = "VarCamb")
    private String varCamb;
    
    @XmlAttribute(name = "CEP")
    private String cep;
    
    @XmlAttribute(name = "TaxEft")
    private String taxEft;
    
    @XmlAttribute(name = "DtContr")
    private String dtContr;
    
    @XmlAttribute(name = "VlrContr")
    private String vlrContr;
    
    @XmlAttribute(name = "NatuOp")
    private String natuOp;
    
    @XmlAttribute(name = "DtVencOp")
    private String dtVencOp;
    
    @XmlAttribute(name = "ClassOp")
    private String classOp;
    
    @XmlAttribute(name = "ProvConstId")
    private String provConstId;
    
    @XmlAttribute(name = "DtaProxParcela")
    private String dtaProxParcela;
    
    @XmlAttribute(name = "VlrProxParcela")
    private String vlrProxParcela;
    
    @XmlAttribute(name = "QtdParcelas")
    private String qtdParcelas;
    
    @XmlElement(name = "Venc")
    private Venc vencimento;
}