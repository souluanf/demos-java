package dev.luanfernandes.demos.xml.service;

import dev.luanfernandes.demos.xml.dto.Cli;
import dev.luanfernandes.demos.xml.dto.Doc;
import dev.luanfernandes.demos.xml.dto.Op;
import dev.luanfernandes.demos.xml.dto.Venc;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class XmlMockGenerator {
    public static Doc criarDocumento() {
        return generateDoc()
                .toBuilder()
                .clientes(List.of(
                        generateCli()
                                .toBuilder()
                                .operacoes(List.of(
                                        getOp().toBuilder().vencimento(generateVenc()).build(),
                                        getOp().toBuilder().vencimento(generateVenc()).build())
                                )
                                .build(),
                        generateCli()
                                .toBuilder()
                                .operacoes(List.of(
                                        getOp().toBuilder().vencimento(generateVenc()).build(),
                                        getOp().toBuilder().vencimento(generateVenc()).build())
                                )
                                .build(),
                        generateCli()
                                .toBuilder()
                                .operacoes(List.of(
                                        getOp().toBuilder().vencimento(generateVenc()).build(),
                                        getOp().toBuilder().vencimento(generateVenc()).build())
                                )
                                .build()
                ))
                .build();
    }

    private static Op getOp() {
        return Op.builder()
                .detCli("95426862000197")
                .ipoc("04836002120529542686229022833")
                .contrt("2962833")
                .mod("1285")
                .cosif("1700000000")
                .origemRec("0199")
                .indx("11")
                .percIndx(".00")
                .varCamb("790")
                .cep("96630504")
                .taxEft("1.02")
                .dtContr("2023-01-09")
                .vlrContr("11828.22")
                .natuOp("01")
                .dtVencOp("2026-01-09")
                .classOp("0")
                .provConstId(".00")
                .dtaProxParcela("2025-02-28")
                .vlrProxParcela("1113.69")
                .qtdParcelas("11")
                .build();
    }

    private static Cli generateCli() {
        return Cli.builder()
                .cd("04636602")
                .tp("2")
                .iniRelactCli("2022-07-27")
                .autorzc("N")
                .fatAnual("100000.00")
                .porteCli("1")
                .tpCtrl("01")
                .classCli("0")
                .congEcon("4112739")
                .build();
    }

    private static Doc generateDoc() {
        return Doc.builder()
                .dtBase("2025-01")
                .cnpj("04636602")
                .parte("1")
                .remessa("1")
                .tpArq("F")
                .nomeResp("Gustavo Alves Jordão")
                .emailResp("gustavo.jordao@leaseplan.com")
                .telResp("+551132968600")
                .totalCli("401")
                .build();
    }

    private static Venc generateVenc() {
        return Venc.builder()
                .build()
                .withAtributo("v110", "1048.65")
                .withAtributo("v120", "1053.87")
                .withAtributo("v130", "1059.13")
                .withAtributo("v140", "3207.28")
                .withAtributo("v150", "5457.29");
    }
}
