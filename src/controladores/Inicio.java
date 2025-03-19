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
            servicio.procesarTransferencia(1000, 2000);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Fondos insuficientes: " + e.getMessage());
        } catch (ErrorDeTransferenciaException e) {
            System.out.println("Error en la transferencia: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Operación de transferencia finalizada.");
        }
    }
}


