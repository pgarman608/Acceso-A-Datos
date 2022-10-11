/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.swing.*;

/**
 *
 * @author Serrperry
 */
public class Frame1 extends JFrame{
    private JPanel panel;
    private JButton boton;
    private JTextField texto;
    private int inc;
    public Frame1() {
        initComponent();
        this.setVisible(rootPaneCheckingEnabled);
    }
    public void initComponent(){
        this.setSize(300,120);
        this.setLocationRelativeTo(this);
        texto = new JTextField("0",20);
        texto.setEditable(false);
        boton = new JButton("Pulse para incrementar");
        panel = new JPanel();
        panel.add(texto);
        panel.add(boton);
        this.setContentPane(panel);
    }
}
