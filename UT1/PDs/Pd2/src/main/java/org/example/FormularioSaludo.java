package org.example;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioSaludo extends JFrame {
    private JTextField campoNombre;
    private JButton botonSaludar;
    private JLabel etiquetaSaludo;

    public FormularioSaludo() {
        setTitle("Saludo");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        campoNombre = new JTextField();
        campoNombre.setBounds(20, 20, 200, 25);
        add(campoNombre);

        botonSaludar = new JButton("Saludar");
        botonSaludar.setBounds(20, 60, 100, 25);
        add(botonSaludar);

        etiquetaSaludo = new JLabel("");
        etiquetaSaludo.setBounds(20, 90, 250, 25);
        add(etiquetaSaludo);

        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText();
                etiquetaSaludo.setText("Hola, " + nombre + "!");
            }
        });
    }

    public static void main(String[] args) {
        new FormularioSaludo().setVisible(true);
    }
}
