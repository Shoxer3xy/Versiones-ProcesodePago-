/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pagosdelaunp;

/**
 *
 * @author Johnfer
 */
public class Pago {
     private final String tipoTarjeta;
    private final double monto;
    private final String numeroTarjeta;
    private final String fechaVencimiento;
    private final String codigoSeguridad;
    private final String codigoEstudiante;
    private final String codigoTransaccion;

    public Pago(String tipoTarjeta, double monto, String numeroTarjeta, String fechaVencimiento, String codigoSeguridad, String codigoEstudiante) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
        if (numeroTarjeta.length() != 16 || !numeroTarjeta.matches("\\d+")) {
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos numéricos.");
        }
        if (!fechaVencimiento.matches("\\d{2}/\\d{2}")) {
            throw new IllegalArgumentException("La fecha de vencimiento debe tener el formato MM/AA.");
        }
        if (codigoSeguridad.length() != 3 || !codigoSeguridad.matches("\\d+")) {
            throw new IllegalArgumentException("El código de seguridad debe tener 3 dígitos numéricos.");
        }
        if (codigoEstudiante.isEmpty()) {
            throw new IllegalArgumentException("El código de estudiante no puede estar vacío.");
        }

        this.tipoTarjeta = tipoTarjeta;
        this.monto = monto;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.codigoSeguridad = codigoSeguridad;
        this.codigoEstudiante = codigoEstudiante;
        this.codigoTransaccion = generarCodigoTransaccion();
    }

    private String generarCodigoTransaccion() {
        return "TXN" + (int)(Math.random() * 100000);
    }

    public String getCodigoTransaccion() { return codigoTransaccion; }
    public String getCodigoEstudiante() { return codigoEstudiante; }
    public double getMonto() { return monto; }
    public String getTipoTarjeta() { return tipoTarjeta; }
    public String numeroTarjeta() { return numeroTarjeta; }
    public String fechaVencimiento() { return fechaVencimiento; }
    public String codigoSeguridad() { return codigoSeguridad; }

    @Override
    public String toString() {
        return "Pago con tarjeta " + tipoTarjeta + "\nMonto: $" + monto + 
               "\nCódigo de transacción: " + codigoTransaccion +
               "\nCódigo de estudiante: " + codigoEstudiante;
    }
}
