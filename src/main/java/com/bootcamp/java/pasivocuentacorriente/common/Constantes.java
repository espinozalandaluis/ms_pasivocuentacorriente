package com.bootcamp.java.pasivocuentacorriente.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Constantes {
    public static final Integer ClientTypePersonal = 1;
    public static final Integer ClientTypeEmpresarialMype = 4;
    public static final Integer ProductTypePasivo = 1;
    public static final Integer ProductSubTypePasivoCuentaCorriente = 2;
    public static final Integer TransactionTypeDeposito = 1;
    public static final Double MaintenanceCost = 8.55;
    public static final Integer TransferenciasPropiaCuenta = 1;
    public static final Integer TipoTrxDeposito = 1;
    public static final Integer TipoTrxRetiro = 2;
    public static final Integer TipoTrxPago = 3;
    public static final Integer TipoTrxConsumo = 4;
    public static final Integer TipoTrxTransferenciaSalida = 5;
    public static final Integer TipoTrxTransferenciaEntrada = 6;
    public static final Integer ProductoPasivoAhorros = 1;
    public static final Integer ProductoPasivoCuentaCorriente = 2;
    public static final Integer ProductoPasivoPlazoFijo = 3;
    public static final Integer ProductoActivoPersonal = 4;
    public static final Integer ProductoActivoEmpresarial = 5;
    public static final Integer ProductoActivoTarjetaCredito = 6;
    public static final long TimeOutWebClients = 10_000;

    public static final String WebClientUriMSCliente = "http://localhost:8080/v1/client";
    public static final String WebClientUriMSProducto = "http://localhost:8080/v1/product";

    //Products Activos

    public static final String WebClientUriMSPasivoAhorro = "http://localhost:8080/v1/pasivocuentacorriente/getByAccountNumber";
    public static final String WebClientUriMSPasivoAhorroTrx = "http://localhost:8080/v1/pasivocuentacorriente/externalTransaction";

    public static final String WebClientUriMSPasivoPlazoFijo = "http://localhost:8080/v1/pasivoplazofijo/getByAccountNumber";
    public static final String WebClientUriMSPasivoPlazoFijoTrx = "http://localhost:8080/v1/pasivoplazofijo/externalTransaction";


    //Products Activos
    public static final String WebClientUriMSActivoTarjetaCredito = "http://localhost:8080/v1/activotarjetacredito/getByAccountNumber";
    public static final String WebClientUriMSActivoTarjetaCreditoTrx = "http://localhost:8080/v1/activotarjetacredito/externalTransaction";

    public static final String WebClientUriMSActivoCreditoPersonal = "http://localhost:8080/v1/activocreditopersonal/getByAccountNumber";
    public static final String WebClientUriMSActivoCreditoPersonalTrx = "http://localhost:8080/v1/activocreditopersonal/externalTransaction";

    public static final String WebClientUriMSActivoCreditoEmpresarial = "http://localhost:8080/v1/activocreditoempresarial/getByAccountNumber";
    public static final String WebClientUriMSActivoCreditoEmpresarialTrx = "http://localhost:8080/v1/activocreditoempresarial/externalTransaction";

    //Para consulta de tarjeta de credito
    public static final String WebClientUriMSActivoTarjetaCreditoDocumentNumber = "http://localhost:8080/v1/activotarjetacredito/getByDocumentNumber";

}