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
        }}
  
