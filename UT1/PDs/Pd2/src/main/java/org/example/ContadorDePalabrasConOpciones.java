package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorDePalabrasConOpciones extends JFrame {
    private JTextArea areaTexto;
    private JButton botonOk;
    private JLabel etiquetaResultado;
    private JRadioButton opcion1, opcion2, opcion3;
    private ButtonGroup grupoOpciones;

    public ContadorDePalabrasConOpciones() {
        setTitle("Contador de Palabras con Opciones");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Área de texto
        areaTexto = new JTextArea("Esto es una prueba");
        areaTexto.setBounds(20, 20, 380, 80);
        add(areaTexto);

        // Opciones con botones de radio
        opcion1 = new JRadioButton("Opción 1");
        opcion2 = new JRadioButton("Opción 2");
        opcion3 = new JRadioButton("Opción 3");

        opcion1.setBounds(20, 110, 100, 25);
        opcion2.setBounds(130, 110, 100, 25);
        opcion3.setBounds(240, 110, 100, 25);

        // Grupo para que solo se pueda elegir una
        grupoOpciones = new ButtonGroup();
        grupoOpciones.add(opcion1);
        grupoOpciones.add(opcion2);
        grupoOpciones.add(opcion3);

        add(opcion1);
        add(opcion2);
        add(opcion3);

        // Botón OK
        botonOk = new JButton("OK");
        botonOk.setBounds(20, 150, 80, 25);
        add(botonOk);

        // Etiqueta de resultado
        etiquetaResultado = new JLabel("Cantidad de palabras: ");
        etiquetaResultado.setBounds(20, 190, 300, 25);
        add(etiquetaResultado);

        // Acción del botón
        botonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Contar palabras
                String texto = areaTexto.getText().trim();
                int cantidad = texto.isEmpty() ? 0 : ContadorDePalabras.contadorPalabras(texto);
                etiquetaResultado.setText("Cantidad de palabras: " + cantidad);

                // Mostrar opción seleccionada
                String seleccionada = null;
                if (opcion1.isSelected()) seleccionada = "Opción 1";
                else if (opcion2.isSelected()) seleccionada = "Opción 2";
                else if (opcion3.isSelected()) seleccionada = "Opción 3";

                if (seleccionada != null) {
                    JOptionPane.showMessageDialog(null, "Opción seleccionada: " + seleccionada);
                } else {
                    JOptionPane.showMessageDialog(null, "No seleccionaste ninguna opción.");
                }
            }
        });
    }

    public static void main(String[] args) {
        new ContadorDePalabrasConOpciones().setVisible(true);
    }
}
