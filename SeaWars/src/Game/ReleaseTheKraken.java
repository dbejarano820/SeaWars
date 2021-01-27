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
public class ReleaseTheKraken implements Superpower{
    
    //revision tentaculos
    @Override
    public String attack1(Player player,Player atacante){//Tentaculos
        atacante.cantidadAtaques++;
        String res = "";
        String fallo = "";
        
        int casilla1X = new Random().nextInt(30);
        int casilla1Y = new Random().nextInt(20);
        int casilla2X = new Random().nextInt(30);
        int casilla2Y = new Random().nextInt(20);
        int casilla3X = new Random().nextInt(30);
        int casilla3Y = new Random().nextInt(20);
        
        if(player.tablero[casilla1Y][casilla1X].vida > 0){
            player.tablero[casilla1Y][casilla1X].vida = 0;
            player.tablero[casilla1Y][casilla1X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            res += "La casilla ("+casilla1X+","+casilla1Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
        }
        else{
            fallo += "La casilla ("+casilla1X+","+casilla1Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
        }
        
        if(player.tablero[casilla2Y][casilla2X].vida > 0){
            player.tablero[casilla2Y][casilla2X].vida = 0;
            player.tablero[casilla2Y][casilla2X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            res += "La casilla ("+casilla2X+","+casilla2Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n"; 
        }
        else{
            fallo += "La casilla ("+casilla2X+","+casilla2Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
        }
        
        if(player.tablero[casilla3Y][casilla3X].vida > 0){
            player.tablero[casilla3Y][casilla3X].vida = 0;
            player.tablero[casilla3Y][casilla3X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            res += "La casilla ("+casilla3X+","+casilla3Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
        }
        else{
            fallo += "La casilla ("+casilla3X+","+casilla3Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
        }
        //los alrededores

        if(casilla1X > 0){
            if(player.tablero[casilla1Y][casilla1X-1].vida > 0){
                player.tablero[casilla1Y][casilla1X-1].vida = 0;
                player.tablero[casilla1Y][casilla1X-1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla1X-1)+","+casilla1Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla1X-1)+","+casilla1Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla2X > 0){
            if(player.tablero[casilla2Y][casilla2X-1].vida > 0){
                player.tablero[casilla2Y][casilla2X-1].vida = 0;
                player.tablero[casilla2Y][casilla2X-1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla2X-1)+","+casilla2Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla2X-1)+","+casilla2Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla3X > 0){
            if(player.tablero[casilla3Y][casilla3X-1].vida > 0){
                player.tablero[casilla3Y][casilla3X-1].vida = 0;
                player.tablero[casilla3Y][casilla3X-1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla3X-1)+","+casilla3Y+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla3X-1)+","+casilla3Y+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla1Y > 0){
            if(player.tablero[casilla1Y-1][casilla1X].vida > 0){
                player.tablero[casilla1Y-1][casilla1X].vida = 0;
                player.tablero[casilla1Y-1][casilla1X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n"; 
                res += "La casilla ("+(casilla1X)+","+(casilla1Y-1)+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla1X)+","+(casilla1Y-1)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla2Y > 0){
            if(player.tablero[casilla2Y-1][casilla2X].vida > 0){
                player.tablero[casilla2Y-1][casilla2X].vida = 0;
                player.tablero[casilla2Y-1][casilla2X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla2X)+","+(casilla2Y-1)+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla2X)+","+(casilla2Y-1)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla3Y > 0){
            if(player.tablero[casilla3Y-1][casilla3X].vida > 0){
                player.tablero[casilla3Y-1][casilla3X].vida = 0;
                player.tablero[casilla3Y-1][casilla3X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla3X)+","+(casilla3Y-1)+") fue destruida por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla ("+(casilla3X)+","+(casilla3Y-1)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        
        
        
        //menores que el maximo
        if(casilla1X < 29){
            if(player.tablero[casilla1Y][casilla1X+1].vida > 0){
                player.tablero[casilla1Y][casilla1X+1].vida = 0;
                player.tablero[casilla1Y][casilla1X+1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla1X+1)+","+casilla1Y+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla1X+1)+","+(casilla1Y)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla2X < 29){
            if(player.tablero[casilla2Y][casilla2X+1].vida > 0){
                player.tablero[casilla2Y][casilla2X+1].vida = 0;
                player.tablero[casilla2Y][casilla2X+1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla2X+1)+","+casilla2Y+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla2X+1)+","+(casilla2Y)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla3X < 29){
            if(player.tablero[casilla3Y][casilla3X+1].vida > 0){
                player.tablero[casilla3Y][casilla3X+1].vida = 0;
                player.tablero[casilla3Y][casilla3X+1].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla3X+1)+","+casilla3Y+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla3X+1)+","+(casilla3Y)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla1Y < 19){
            if(player.tablero[casilla1Y+1][casilla1X].vida > 0){
                player.tablero[casilla1Y+1][casilla1X].vida = 0;
                player.tablero[casilla1Y+1][casilla1X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n"; 
                res += "La casilla ("+(casilla1X)+","+(casilla1Y+1)+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla1X)+","+(casilla1Y+1)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla2Y < 19){
            if(player.tablero[casilla2Y+1][casilla2X].vida > 0){
                player.tablero[casilla2Y+1][casilla2X].vida = 0;
                player.tablero[casilla2Y+1][casilla2X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla2X)+","+(casilla2Y+1)+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla2X+1)+","+(casilla2Y)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(casilla3Y < 19){
            if(player.tablero[casilla3Y+1][casilla3X].vida > 0){
                player.tablero[casilla3Y+1][casilla3X].vida = 0;
                player.tablero[casilla3Y+1][casilla3X].historial += "Fue destruido por un tentaculo enviado por el jugador "+atacante.nombre+"\n";
                res += "La casilla ("+(casilla3X)+","+(casilla3Y+1)+") fue destruida por un tentaculo\n";
            }
            else{
                fallo += "La casilla ("+(casilla3X)+","+(casilla3Y+1)+") fallo al ser destruida por un tentaculo enviado por el jugador "+atacante.nombre+", porque la casilla ya estaba muerta\n";
            }
            
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;

        return res+fallo;
    }
    
    
    //revision kraken breath
    public String attack2(Player player,Player atacante, int x, int y){//Kraken breath
        String res = "";
        String fallo = "";
        int direccion = new Random().nextInt(4);
        int cantCasillas = new Random().nextInt(8)+1;
        atacante.cantidadAtaques++;
        
        if(direccion == 0){
            for(int i = 0; i < cantCasillas; i++){
                if(y<0){
                    break;
                }
                if(player.tablero[y][x].vida > 0){
                    player.tablero[y][x].vida = 0;
                    player.tablero[y][x].historial += "Fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                    res += "La casilla ("+x+","+y+") fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla ("+x+","+y+") no fue destruido por el aliento del Kraken, porque ya estaba destruido\n";
                }
                y--;
                
            }
            
        }
        
        else if(direccion == 1){
            for(int i = 0; i < cantCasillas; i++){
                if(x<0){
                    break;
                }
                if(player.tablero[y][x].vida > 0){
                    player.tablero[y][x].vida = 0;
                    player.tablero[y][x].historial += "Fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                    res += "La casilla ("+x+","+y+") fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla ("+x+","+y+") no fue destruido por el aliento del Kraken, porque ya estaba destruido\n";
                }
                x--;
            }
            
        }
        else if(direccion == 2){
            for(int i = 0; i < cantCasillas; i++){
                if(y>19){
                    break;
                }
                if(player.tablero[y][x].vida > 0){
                    player.tablero[y][x].vida = 0;
                    player.tablero[y][x].historial += "Fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                    res += "La casilla ("+x+","+y+") fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla ("+x+","+y+") no fue destruido por el aliento del Kraken, porque ya estaba destruido\n";
                }
                y++;
            }
            
        }
        else if(direccion == 3){
            for(int i = 0; i < cantCasillas; i++){
                if(x>29){
                    break;
                }
                if(player.tablero[y][x].vida > 0){
                    player.tablero[y][x].vida = 0;
                    player.tablero[y][x].historial += "Fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                    res += "La casilla ("+x+","+y+") fue destruido por el aliento del Kraken enviado por el jugador "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla ("+x+","+y+") no fue destruido por el aliento del Kraken, porque ya estaba destruido\n";
                }
                x++;
                
            }
            
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res;
    }
    
    //revision release the kraken
    @Override
    public String attack3(Player player,Player atacante){//Release the kraken
        
        if(player.krakenDefense){
            player.krakenDefense = false;
            attack3(atacante,player);
        }
        String fallo = "";
        String res = "";
        int casillaX = new Random().nextInt(30);
        int casillaY = new Random().nextInt(20);
        double distancia = new Random().nextInt(9)+1;
        double distanciaTmp;
        atacante.cantidadAtaques++;
        
        for(int i = 0; i<player.tablero.length; i++){
            
            for(int j = 0; j<player.tablero[i].length; j++){
                
                distanciaTmp = Math.sqrt(((casillaX-i)*(casillaX-i))+((casillaY-j)*(casillaY-j)));
                
                if(distanciaTmp <= distancia){
                    if(player.tablero[j][i].vida > 0){
                        player.tablero[j][i].vida = 0;
                        player.tablero[j][i].historial += "Fue destruida por el Kraken liberado por "+atacante.nombre+"\n";
                        res += "La casilla ("+i+","+j+") fue destruida por el Kraken liberado por "+atacante.nombre+"\n";
                    }
                    else{
                        fallo += "La casilla ("+i+","+j+") no fue destruida por el Kraken liberado por "+atacante.nombre+"\n";
                    }
                }
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    
    
    //No se usa
    @Override
    public String attack2(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}