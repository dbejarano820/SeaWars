/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.Random;

/**
 *
 * @author XT
 */
public class ThundersUnderTheSea implements Superpower{
    
    String name = "thundersunderthesea";
    //Thunder rain
    
    public String attack1(Player player,Player atacante, int extra){
        String res = "";
        String fallo = "";
        int x;
        int y;
        atacante.cantidadAtaques++;
        
        for(int i = 0; i < 100;i++){
            
            double daño = new Random().nextInt(11)+10;
            
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            daño = daño +(daño*(extra/100.0))-(daño*(player.tablero[y][x].escudo/100.0));
            
            if(player.tablero[y][x].vida > 0){
                
                player.tablero[y][x].historial += "Se ataco la casilla con un rayo y paso su vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+" con un escudo de "+
                        player.tablero[y][x].escudo+" y un daño extra de "+extra+", el ataque fue enviado por "+atacante.nombre+" \n";
                
                res += "Se ataco la casilla("+x+","+y+") de "+player.nombre+" con un rayo y paso su vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+" con un escudo de "+
                        player.tablero[y][x].escudo+" y un daño extra de "+extra+", el ataque fue enviado por "+atacante.nombre+" \n";

                player.tablero[y][x].vida -= daño;
                
                if(player.tablero[y][x].vida < 0)
                    player.tablero[y][x].vida = 0;
                player.tablero[y][x].escudo = 0;
            }
            else{
                fallo += "Se intento atacar la casilla("+x+","+y+") de "+player.nombre+" con un rayo pero ya estaba muerta \n";
            }

        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    //Poseidon thunders
    @Override
    public String attack2(Player player,Player atacante){
        String res = "";
        String fallo = "";
        int cantRayos = new Random().nextInt(5)+5;
        int x;
        int y;
        int cantCasillas = new Random().nextInt(8)+1;
        double distanciaTmp;
        atacante.cantidadAtaques++;
        
        
        
        for(int i = 0; i < cantRayos; i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            for(int j = 0; j <player.tablero.length; j++){
                
                for(int k = 0; k<player.tablero[j].length; k++){
                    
                    distanciaTmp = Math.sqrt(((x-j)*(x-j))+((y-k)*(y-k)));
                    if(distanciaTmp <= cantCasillas){
                        if(player.tablero[k][j].vida > 0){
                            player.tablero[k][j].vida = 0;
                            player.tablero[k][j].historial += "La casilla  fue destruida por un rayo de Poseidon enviado por"+atacante.nombre+"\n";
                            res += "La casilla ("+j+","+k+") de "+player.nombre+" fue destruida por un rayo de Poseidon enviado por"+atacante.nombre+"\n";
                        }
                        else{
                            fallo += "La casilla ("+j+","+k+") de "+player.nombre+" iba a ser destruida por un rayo de Poseidon enviado por"+atacante.nombre+" pero ya estaba muerta\n";
                        }
                    }
                }
            }   
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    //Eel attack
    public String attack3(Player player,Player atacante, int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int cantAnguilas = new Random().nextInt(75)+25;
        int cantDescargas;
        int x;
        int y;
        
        
        for(int i = 0; i < cantAnguilas; i++){
            cantDescargas = new Random().nextInt(10)+1;
            for(int j = 0; j < cantDescargas; j++){
                x = new Random().nextInt(30);
                y = new Random().nextInt(20);
                double daño = 10 +(10*(extra/100.0))-(10*(player.tablero[y][x].escudo/100.0));
                if(player.tablero[y][x].vida > 0){
                    
                    player.tablero[y][x].historial += "Se redujo la vida  de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida - daño)+" por un ataque de Anguilas enviado por "+
                            atacante.nombre+", hubo un daño extra de "+extra+" y la casilla poseia un escudo de "+player.tablero[y][x].escudo+"\n";
                    
                    res += "Se redujo la vida de la casilla ("+x+","+y+")  de "+player.nombre+" de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida - daño)+" por un ataque de Anguilas enviado por "+
                            atacante.nombre+", hubo un daño extra de "+extra+" y la casilla poseia un escudo de "+player.tablero[y][x].escudo+"\n";
                    
                    player.tablero[y][x].vida -= daño;
                    
                    if(player.tablero[y][x].vida < 0)
                        player.tablero[y][x].vida = 0;
                    player.tablero[y][x].escudo = 0;
                }
                else{
                    fallo += "Se intento atacar la casilla ("+x+","+y+") de "+player.nombre+" con un ataque de anguilas enviado por "+
                            atacante.nombre+" pero esta ya estaba muerta\n";
                }
                
            }
            
        }
        
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }

    
    //no se usa
    @Override
    public String attack1(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //no se usa
    @Override
    public String attack3(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}    
