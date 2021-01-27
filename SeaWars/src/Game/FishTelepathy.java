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
public class FishTelepathy implements Superpower{
    
    //Revision Cardumen
    public String attack1(Player player,Player atacante, int extra){
        String res = "";
        String fallos = "";
        int cantPeces = new Random().nextInt(200)+100;
        int x;
        int y;
        atacante.cantidadAtaques++;
        
        for(int i = 0; i < cantPeces; i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            if(player.tablero[y][x].vida > 0){
                double damage = (33 + (33*(extra/100.0)))-(33*(player.tablero[y][x].escudo/100.0));
                
                player.tablero[y][x].historial += "Se redujo la vida de la casilla de "+" por un ataque del Cardumen enviado por "+atacante.nombre+"\n";
                
               
                res+= "Se redujo la vida de la casilla ("+x+","+y+") de"+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-damage)+" por un ataque de Cardumen que hizo "+(33 + (33*(extra/100.0)))+
                        " de daño y un escudo de "+player.tablero[y][x]+" enviado por "+atacante.nombre+"\n";
                
                
                player.tablero[y][x].vida -= damage;
                
            }
            else{
                fallos += "Un cardumen intento atacar la casilla ("+x+","+y+") pero ya estaba muerta\n";
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallos;
    }
    
    //Revision tiburones
    @Override
    public String attack2(Player player,Player atacante){
        atacante.cantidadAtaques++;
        String res = "";
        String fallo = "";
        int distancia = new Random().nextInt(10)+1;
        
        
        for(int i = 0; i < player.tablero.length; i++){
            
            for(int j = 0; j< player.tablero[i].length; j++){
                
                if(player.tablero[j][i].vida > 0){
                    double SupDer = Math.sqrt(((29-i)*(29-i))+((0-j)*(0-j)));
                    double SupIzq = Math.sqrt(((0-i)*(0-i))+((0-j)*(0-j)));
                    double BotDer = Math.sqrt(((29-i)*(29-i))+((19-j)*(19-j)));
                    double BotIzq = Math.sqrt(((0-i)*(0-i))+((19-j)*(19-j)));
                    if(SupDer<= distancia || SupIzq<= distancia || BotDer<= distancia || BotIzq<= distancia){
                        player.tablero[j][i].vida = 0;
                        player.tablero[j][i].historial += "Fue destruido por un ataque de tiburon enviado por "+atacante.nombre+"\n";
                        res+= "La casilla ("+i+","+j+") fue destruida por un ataque de tiburon enviado por "+atacante.nombre+"\n";     
                    }
                }
                else{
                    fallo += "La casilla ("+i+","+j+") intento ser destruida por un ataque de tiburon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res;
    }
    //Revision pulpos
    
    public String attack3(Player player,Player atacante, int extra){
        atacante.cantidadAtaques++;
        String res = "";
        int cantPulpos = new Random().nextInt(30)+20;
        int x;
        int y;
        for(int i = 0; i < cantPulpos; i++){
            
            for(int j = 0; j< 8; j++){
                x = new Random().nextInt(30);
                y = new Random().nextInt(20);
                if(player.tablero[y][x].vida > 0){
                    double daño = (25 + (25*(extra/100.0))-(25*(player.tablero[y][x].escudo/100.0)));
                    
                    player.tablero[y][x].historial += "Se redujo la vida de la casilla por un ataque del Pulpo enviado por "+atacante.nombre;
                    res+= "Se redujo la vida de la casilla ("+x+","+y+") por un ataque de Pulpo que hizo "+daño+" de daño y tenia un escudo de "
                            +player.tablero[y][x].escudo+" enviado por "+atacante.nombre+"\n";
                    player.tablero[y][x].vida -= daño;
                }
                else{
                    res += "Un pulpo intento atacar la casilla ("+x+","+y+") pero ya estaba muerta\n";
                }
                
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res;
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
