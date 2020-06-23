/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sigic.view.utils;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ederc
 */
public class LimpaTela {

    public static void limpaTela(JPanel container) {
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField){
                ((JTextField) component).setText(null);
                ((JTextField) component).setBackground(new java.awt.Color(255, 255, 255));
            }
        }
    }
}
