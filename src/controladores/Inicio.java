package controladores;

import excepciones.SaldoInsuficienteException;
import excepciones.ErrorDeTransferenciaException;
import servicios.TransferenciaServicio;

/**
 * @author jmormez
 * @date 19/03/2025
 * Puerta de entrada a mi aplicación
 */
public class Inicio {
	
	/**
	 * @author jmormez
	 * @date 19/03/2025
	 * Clase controladora de mi aplicación
	 * @param paámetros de configuración
	 */
    public static void main(String[] args) {
        TransferenciaServicio servicio = new TransferenciaServicio();

        try {
            servicio.procesarTransferencia(1000, 5000);
        } catch (SaldoInsuficienteException e) {
            System.err.println("Fondos insuficientes: " + e.getMessage());
        } catch (ErrorDeTransferenciaException e) {
            System.err.println("Error en la transferencia: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Operación de transferencia finalizada.");
        }
    }
}


