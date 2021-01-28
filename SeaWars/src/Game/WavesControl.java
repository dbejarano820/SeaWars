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
public class WavesControl implements Superpower{
    
    String name = "wavescontrol";
    
    @Override//Swirl raising
    public String attack1(Player player,Player atacante){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        
        int remolinoTamaño = new Random().nextInt(9)+2;
        double distanciaTmp;
        int x = new Random().nextInt(30);
        int y = new Random().nextInt(20);
        player.remolinos.add(new Remolino(x,y,remolinoTamaño));
        
        for(int i = 0; i < player.tablero.length; i++){
            for (int j = 0; j < player.tablero[i].length; j++){
                distanciaTmp = Math.sqrt(((x-j)*(x-j))+((y-i)*(y-i)));
                
                if(distanciaTmp <= remolinoTamaño){
                    if( !player.tablero[i][j].activeVolcano){
                        player.tablero[i][j].activeWhirlpool  = true;
                        player.tablero[i][j].vida = 0;
                        player.tablero[i][j].historial += "Se creo un remolino enviado por "+atacante.nombre+"\n";
                        res += "En la casilla ("+j+","+i+") de "+player.nombre+" se creo un remolino enviado por "+atacante.nombre+"\n";
                        
                    }
                    
                    else{
                        fallo +=   "En la casilla ("+j+","+i+") de "+player.nombre+" no se creo un remolino enviado por "+atacante.nombre+" porque ya tenia un volcan\n";
                    }
                }  
            }
        }
        if(!res.equals("")){
            res = "Se creo un remolino en la casilla("+x+","+y+")\n"+res;
            atacante.cantidadAtinados++;
        }
        
        return res+fallo; 
    }
    
    
    //Send human garbage
    public String attack2(Player player,Player atacante, int extra, int xR, int yR){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int selecRemolino = new Random().nextInt();
        Remolino remolino = player.buscarRemolino(xR, yR);
        if(remolino == null)
            return "El jugador "+atacante.nombre+" no ha seleccionado un remolino valido";
        
        int cantBasura = (remolino.tamaño/2)*10;
        int x;
        int y;
        for(int i = 0; i < cantBasura;i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            double daño;
            int radioactiva = new Random().nextInt(2);
            
            if(player.tablero[y][x].vida > 0){
                if(radioactiva == 0){
                    daño = 25 +(25*(extra/100.0))-(25*(player.tablero[y][x].escudo/100.0));
                    player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        "con un daño extra de "+extra+" y con un escudo de "+ player.tablero[y][x]+" por basura enviada por un remolino enviado de "+atacante.nombre+"\n";
                
                    res += "Se redujo la vida de la casilla("+x+","+y+") de "+player.nombre+" de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " con un daño extra de "+extra+" y un escudo de "+player.tablero[y][x].escudo+" por basura enviada por un remolino enviado de "+atacante.nombre+"\n";
                }
                else{
                    daño = 50 +(50*(extra/100.0))-(50*(player.tablero[y][x].escudo/100.0));
                    player.tablero[y][x].cantBasuraRactiva++;
                    
                    
                    player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        "con un daño extra de "+extra+" y con un escudo de "+ player.tablero[y][x]+" por basura radioactiva enviada por un remolino enviado de "+atacante.nombre+"\n";
                
                    res += "Se redujo la vida de la casilla("+x+","+y+") de "+player.nombre+" de"+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " con un daño extra de "+extra+" y un escudo de "+player.tablero[y][x].escudo+" por basura radioactiva enviada por un remolino enviado de "+atacante.nombre+"\n";
                }
                    
                
                
                player.tablero[y][x].vida -= daño;
                
                if(player.tablero[y][x].vida < 0)
                            player.tablero[y][x].vida = 0;
                        player.tablero[y][x].escudo = 0;
            }
            else{
                fallo += "No se redujo la vida de la casilla("+x+","+y+") de "+player.nombre+" por basura enviada por un remolino enviado de "+atacante.nombre+" porque la casilla ya estaba muerta\n";
            }
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    
    //Radioactive rush
    public String attack3(Player player,Player atacante,int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int segundos = new Random().nextInt(10)+1;
        int preDaño;
        double daño;
        
        for(int i = 0; i < player.tablero.length;i++){
            
            for(int j = 0; j < player.tablero[i].length;j++){
                
                if(player.tablero[i][j].cantBasuraRactiva == 0)
                    continue;
                
                if(player.tablero[i][j].vida > 0){
                   
                    System.out.println("si entra al if de cantbasuraractiva");
                    
                    preDaño = 10*segundos*player.tablero[i][j].cantBasuraRactiva;
                    
                    daño  = preDaño + (preDaño*(extra/100.0))-(preDaño*(player.tablero[i][j].escudo/100.0));
                    
                    System.out.println("daño: " + daño + "predaño: " + preDaño);
                    
                    player.tablero[i][j].historial += "La casilla redujo su vida de "+player.tablero[i][j].vida+" a "+(player.tablero[i][j].vida-daño)+" con un daño extra de "+extra+" y un escudo de " +
                            player.tablero[i][j].escudo+"\n";
                    
                    res+= "La casilla ("+j+","+i+") de"+player.nombre+" redujo su vida de "+player.tablero[i][j].vida+" a "+(player.tablero[i][j].vida-daño)+" con un daño extra de "+extra+" y un escudo de "
                            +player.tablero[i][j].escudo+" por una reaccion radioactiva enviada por "+atacante.nombre+"\n";
                    
                    player.tablero[i][j].vida -= daño;
                    
                    if(player.tablero[i][j].vida<0)
                        player.tablero[i][j].vida = 0;
                    player.tablero[i][j].escudo = 0;
                    
                }
                else{
                    fallo += "La casilla ("+j+","+i+") de "+player.nombre+" no redujo su vida de  por una reaccion radioactiva enviada por "+atacante.nombre+" porque ya estaba muerta\n";
                }
            }
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    //no se usa
    @Override
    public String attack2(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // no se usa
    @Override
    public String attack3(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
