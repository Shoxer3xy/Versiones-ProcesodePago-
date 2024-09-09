/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pagosdelaunp;

/**
 *
 * @author Johnfer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.AbstractDocument;



public class PagosdelaUNP extends JFrame {

    // Componentes de la interfaz
    private final JTextField campoCodigoEstudiante, campoMonto, campoNumeroTarjeta, campoFechaVencimiento, campoCodigoSeguridad;
    private final JComboBox<String> comboTarjeta;
    private final JButton botonPagar;

    public PagosdelaUNP() {
        // Configuración del JFrame (ventana principal)
        setTitle("Sistema de Pago de Matrícula");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10)); // 7 filas y 2 columnas

        // Crear etiquetas y campos de texto
        JLabel etiquetaCodigoEstudiante = new JLabel("Código de estudiante:");
        campoCodigoEstudiante = new JTextField(10);

        JLabel etiquetaMonto = new JLabel("Monto a pagar:");
        campoMonto = new JTextField(10);
        campoMonto.setText("151.50");
        campoMonto.setEditable(false); // El monto no es editable, se llena automáticamente

        JLabel etiquetaTarjeta = new JLabel("Tipo de tarjeta:");
        comboTarjeta = new JComboBox<>(new String[]{"Visa", "Mastercard", "Amex"});

        JLabel etiquetaNumeroTarjeta = new JLabel("Número de tarjeta:");
        campoNumeroTarjeta = new JTextField(16);

        JLabel etiquetaFechaVencimiento = new JLabel("Fecha de vencimiento (MM/AA):");
        campoFechaVencimiento = new JTextField(5);

        JLabel etiquetaCodigoSeguridad = new JLabel("Código de seguridad (CVV):");
        campoCodigoSeguridad = new JTextField(3);

        botonPagar = new JButton("Pagar");
       // Aplicar el filtro para que acepten solo números y se limiten al número de cifras
        ((AbstractDocument) campoNumeroTarjeta.getDocument()).setDocumentFilter(new NumericDocumentFilter(16));
        ((AbstractDocument) campoCodigoSeguridad.getDocument()).setDocumentFilter(new NumericDocumentFilter(3));

       
       
        botonPagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarPago();
            }
        });

        // Agregar componentes a la ventana
        add(etiquetaCodigoEstudiante);
        add(campoCodigoEstudiante);
        add(etiquetaMonto);
        add(campoMonto);
        add(etiquetaTarjeta);
        add(comboTarjeta);
        add(etiquetaNumeroTarjeta);
        add(campoNumeroTarjeta);
        add(etiquetaFechaVencimiento);
        add(campoFechaVencimiento);
        add(etiquetaCodigoSeguridad);
        add(campoCodigoSeguridad);
        add(new JLabel()); // Espacio vacío para el layout
        add(botonPagar);
    }



    // Método para procesar el pago
    private void realizarPago() {
        // Validar que el monto sea correcto
        if (!campoCodigoEstudiante.getText().equals("0512020015")) {
            JOptionPane.showMessageDialog(this, "El código de estudiante es incorrecto o no ha sido ingresado correctamente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String numeroTarjeta = campoNumeroTarjeta.getText();
            String fechaVencimiento = campoFechaVencimiento.getText();
            String codigoSeguridad = campoCodigoSeguridad.getText();
        // Validaciones para cada campo
        if (numeroTarjeta.length() != 16) {
            JOptionPane.showMessageDialog(this, "El número de tarjeta debe contener 16 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fechaVencimiento.length() != 5) {
            JOptionPane.showMessageDialog(this, "La fecha de vencimiento debe tener el formato MM/AA.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (codigoSeguridad.length() != 3) {
            JOptionPane.showMessageDialog(this, "El código de seguridad debe contener 3 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
           // Confirmar si el usuario desea proceder con el pago
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea realizar el pago?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            // Obtener datos de la tarjeta
            String tipoTarjeta = (String) comboTarjeta.getSelectedItem();
            // Simular la creación del pago
            double monto = Double.parseDouble(campoMonto.getText());
            String codigoEstudiante = campoCodigoEstudiante.getText();
            Pago pago = new Pago(tipoTarjeta, monto, numeroTarjeta, fechaVencimiento, codigoSeguridad, codigoEstudiante);
            Factura factura = new Factura(pago);

            // Mostrar mensaje de éxito
            JOptionPane.showMessageDialog(this, "Pago realizado con éxito.\nCódigo de transacción: " + pago.getCodigoTransaccion());

            // Mostrar la factura en la consola
            factura.imprimirFactura();
        }
    }
    
     

    
    // Método main para ejecutar la interfaz
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PagosdelaUNP interfaz = new PagosdelaUNP();
            interfaz.setVisible(true); // Hacer visible la ventana
        });
    }
}
  
