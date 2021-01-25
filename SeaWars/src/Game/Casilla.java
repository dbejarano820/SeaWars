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
    
    public String historial;
    int vida;
    public boolean activeVolcano;
    public boolean activeWhirlpool;
    public JLabel refLabel;
    public int cantBasura;
    public String heroOwner;
    
    public Casilla(){
        
        vida = 100;
        activeVolcano = false;
        activeWhirlpool = false;
        heroOwner = "";
        historial = "";
    }
    
    
    
    public JLabel generateLabel(){      // se utiliza para generar el reflabel de las casillas del cliente, el player no lo necesita
        JLabel newLabel = new JLabel();
        
        newLabel.setForeground(new java.awt.Color(0, 0, 0));
        newLabel.setText("");
        newLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        newLabel.setOpaque(true);
        newLabel.setSize(20,20);
        newLabel.setLocation(0,0);
        this.refLabel = newLabel;
        return newLabel;
       
    }
    
    public void addHistorial(String msj){
        historial += msj;
    }
    
    public boolean estaViva(){
        if(vida <= 0)
            return false;
        else
            return true;
    }
    
    
    public String update(){
        String msj = "";
        msj += "Vida de la casilla: " + vida + "\n" + historial;
        return msj;
        
    }
    
}
