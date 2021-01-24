/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JLabel;

/**
 *
 * @author PERSSONAL
 */
public class Casilla {
    
    String historial;
    boolean ocupado;
    int vida;
    boolean activeVolcano;
    boolean activeWhirlpool;
    JLabel refLabel;
    
    public Casilla(){
        
        vida = 100;
        activeVolcano = false;
        activeWhirlpool = false;
        ocupado = false;
    }
    
    
    
    public JLabel generateLabel(){      // se utiliza para generar el reflabel de las casillas del cliente, el player no lo necesita
        JLabel newLabel = new JLabel();
        newLabel.setForeground(new java.awt.Color(0, 0, 0));
        newLabel.setText("");
        newLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        newLabel.setOpaque(true);
      //  getContentPane().add(newLabel);
        newLabel.setSize(20,20);
        newLabel.setLocation(0,0);
        this.refLabel = newLabel;
        return newLabel;
        
        
        
    }
    
    
    
    
}
