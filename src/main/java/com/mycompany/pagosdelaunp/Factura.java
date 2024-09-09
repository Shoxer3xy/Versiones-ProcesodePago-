/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagosdelaunp;

/**
 *
 * @author Johnfer
 */
public class Factura {
      private final Pago pago;
    private final String fecha;

    public Factura(Pago pago) {
        this.pago = pago;
        this.fecha = java.time.LocalDate.now().toString();
    }

    public void imprimirFactura() {
        System.out.println("Factura:");
        System.out.println("Fecha: " + fecha);
        System.out.println("Código de estudiante: " + pago.getCodigoEstudiante());
        System.out.println("Monto pagado: S/" + pago.getMonto());
        System.out.println("Tipo de tarjeta: " + pago.getTipoTarjeta());
        System.out.println("Código de transacción: " + pago.getCodigoTransaccion());
    }
}
