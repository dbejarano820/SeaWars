/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import javax.swing.JLabel;

/**
 *
 * @author PERSONAL
 */
public class MainCliente {
    
    
        public static void main(String[] args) {
        
            try{
            PantallaCliente pantalla = new PantallaCliente();
            Cliente p = new Cliente(pantalla); 
            p.conectar();
            pantalla.generarTablero();
            pantalla.setVisible(true);
            
                System.out.println( (int)(((double)35/ (double)100)* (double)600));
            
            
            }
            catch(Exception e){

            }
        }
}
        
