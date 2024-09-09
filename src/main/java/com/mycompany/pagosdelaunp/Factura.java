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
   

    public Factura(Pago pago) {
        this.pago = pago;
       
    }

    public void imprimirFactura() {
        System.out.println("Código de estudiante: " + pago.getCodigoEstudiante());
        System.out.println("Monto pagado: S/" + pago.getMonto());
        System.out.println("Código de transacción: " + pago.getCodigoTransaccion());
    }
}
