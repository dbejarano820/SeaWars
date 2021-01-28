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
public class TheTrident implements Superpower{
    
    String name = "thetrident";
    
    //Three lines
    public String attack1(Player player,Player atacante, int x1, int x2, int x3, int y1, int y2, int y3){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int cantCasillas = new Random().nextInt(4)+1;
        int direccion = new Random().nextInt(4);
        
        if(direccion == 0){
            for(int i = 0; i<cantCasillas; i++){
                if(y1 < 0)
                    break;
                if(player.tablero[y1][x1].vida > 0){
                    player.tablero[y1][x1].vida = 0;
                    player.tablero[y1][x1].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x1+","+y1+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y1--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(y2 < 0)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y2--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(y3 < 0)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y3--;
            }
            
        }
        else if(direccion == 1){
            for(int i = 0; i<cantCasillas; i++){
                if(x1 < 0)
                    break;
                if(player.tablero[y1][x1].vida > 0){
                    player.tablero[y1][x1].vida = 0;
                    player.tablero[y1][x1].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x1+","+y1+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x1--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(x2 < 0)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x2--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(x3 < 0)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x3--;
            }
            
        }
        
        else if(direccion == 2){
            for(int i = 0; i<cantCasillas; i++){
                if(y1 > 19)
                    break;
                if(player.tablero[y1][x1].vida > 0){
                    player.tablero[y1][x1].vida = 0;
                    player.tablero[y1][x1].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x1+","+y1+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y1++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(y3 > 19)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y1+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y3++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(y2 > 19)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y2++;
            }
            
        }
        
        else if(direccion == 3){
            for(int i = 0; i<cantCasillas; i++){
                if(x1 > 29)
                    break;
                if(player.tablero[y1][x1].vida > 0){
                    player.tablero[y1][x1].vida = 0;
                    player.tablero[y1][x1].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x1+","+y1+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x1++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(x2 > 29)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x2++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(x3 > 29)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") de "+player.nombre+" fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") de "+player.nombre+" intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x3++;
            }
            
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    
    //tocar los casos de los threads
    // Three numbers
    public String attack2(Player player,Player atacante, int cantDestrucciones){
        
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int x;
        int y;
        int i = 0;
        while(i < cantDestrucciones){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            
        //    if(!player.estaVivo())
//      break;
            if(player.tablero[y][x].vida > 0){
                player.tablero[y][x].vida = 0;
                player.tablero[y][x].historial += "Fue destruida por el Three Numbers enviado por "+atacante.nombre+"\n";
                res += "La casilla("+x+","+y+") de "+player.nombre+" fue destruida por el Three Numbers enviado por "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla("+x+","+y+") de "+player.nombre+" iba a ser destruida por el Three Numbers enviado por "+atacante.nombre+" pero ya estaba muerta\n";
            }
            i++;
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
     
    
    //Control the kraken
    @Override
    public String attack3(Player player,Player atacante){//control the kraken
        String res = "";
        atacante.krakenDefense = true;
        res += atacante.nombre+" se protegera del siguiente ataque del Kraken en esta ronda \n";
        atacante.cantidadAtaques++;
        atacante.cantidadAtinados++;
        return res;
    }
    
    
    
    // no se usa
    @Override
    public String attack1(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // no se usa
    @Override
    public String attack2(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
