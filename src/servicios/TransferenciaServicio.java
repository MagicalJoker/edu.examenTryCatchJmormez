package servicios;

import excepciones.SaldoInsuficienteException;
import excepciones.ErrorDeTransferenciaException;

import java.io.FileWriter;
import java.io.IOException;

public class TransferenciaServicio {
    private double saldo = 500.0;

    public void procesarTransferencia(double cantidad, double cuentaDestino) throws SaldoInsuficienteException, ErrorDeTransferenciaException, IOException, RuntimeException{
        if (cantidad > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para transferir " + cantidad);
        }

        try (FileWriter archivo = new FileWriter("transferencias.log", true)) {
            archivo.write("Transferencia de " + cantidad + " a la cuenta " + cuentaDestino + "\n");

            if (cuentaDestino < 1000) {
                throw new ErrorDeTransferenciaException("Número de cuenta inválido: " + cuentaDestino);
            }

            saldo -= cantidad;
            System.out.println("Transferencia exitosa. Nuevo saldo: " + saldo);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo de transferencias: " + e.getMessage(), e);
            //¿Capturar una excepción y lanzar otra excepción distinta?
        }
    }
}
