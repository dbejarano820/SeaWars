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
public class UnderseaVolcanoes implements Superpower{
    
    String name = "underseavolcanoes";
    
    @Override//Volcanoe Raising
    public String attack1(Player player,Player atacante){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        
        int volcanTamaño = new Random().nextInt(10)+1;
        double distanciaTmp;
        int x = new Random().nextInt(30);
        int y = new Random().nextInt(20);
        player.volcanes.add(new Volcan(x,y,volcanTamaño));
        
        for(int i = 0; i < player.tablero.length; i++){
            for (int j = 0; j < player.tablero[i].length; j++){
                distanciaTmp = Math.sqrt(((x-j)*(x-j))+((y-i)*(y-i)));
                
                if(distanciaTmp <= volcanTamaño){
                    if( !player.tablero[i][j].activeWhirlpool){
                        player.tablero[i][j].activeVolcano  = true;
                        player.tablero[i][j].vida = 0;
                        player.tablero[i][j].historial += "Se creo un volcan enviado por "+atacante.nombre+"\n";
                        res += "En la casilla ("+j+","+i+") de "+player.nombre+" se creo un volcan enviado por "+atacante.nombre+"\n";
                        
                    }
                    
                    else{
                        fallo += "En la casilla ("+j+","+i+") de "+player.nombre+" no se creo un volcan enviado por "+atacante.nombre+" porque ya tenia un remolino\n";
                    }
                }  
            }
        }
        if(!res.equals("")){
            res = "Se creo un volcan en la casilla("+x+","+y+")\n"+res;
            atacante.cantidadAtinados++;
        }
        
        return res+fallo;
    }
    
    //Volcanoe Explosion
    public String attack2(Player player,Player atacante, int extra, int xV, int yV){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        Volcan volcan = player.buscarVolcan(xV, yV);
        if(volcan == null)
            return "El jugador "+atacante.nombre+" no ha seleccionado un volcan valido";
        
        
        
        int cantPiedras = volcan.tamaño*volcan.tamaño*10;
        int x;
        int y;
        for(int i = 0; i < cantPiedras;i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            double daño = 20 +(20*(extra/100.0))-(20*(player.tablero[y][x].escudo/100.0));
            if(player.tablero[y][x].vida > 0){
                
                player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+" con un daño extra de "+extra+
                        " y un escudo de "+player.tablero[y][x].escudo+" por una roca enviada por un volcan enviado de "+atacante.nombre+"\n";
                
                res += "Se redujo la vida de la casilla("+x+","+y+") de "+player.nombre+" de"+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " con un daño extra de "+extra+" y un escudo de "+player.tablero[y][x].escudo+" por una roca enviada por un volcan enviado de "+atacante.nombre+"\n";
                player.tablero[y][x].vida -= daño;
                
                if(player.tablero[y][x].vida < 0)
                    player.tablero[y][x].vida = 0;
                player.tablero[y][x].escudo = 0;
            }
            else{
                fallo += "No se redujo la vida de la casilla("+x+","+y+") de "+player.tablero[y][x].vida+" por una roca enviada por un volcan enviado de "+atacante.nombre+
                        " porque la casillas ya estba muerta \n";
            }
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    //Thermal rush
    public String attack3(Player player,Player atacante, int xV, int yV, int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        
        Volcan volcan = player.buscarVolcan(xV, yV);
        if(volcan == null)
            return "El jugador "+atacante.nombre+" no ha seleccionado un volcan valido";
        
        double distanciaTmp;
        int segundos = new Random().nextInt(2)+5;
        int dañoTmp = volcan.tamaño*segundos;
        double daño;
        
        for(int i = 0; i < player.tablero.length;i++){
            for(int j = 0; j <player.tablero[i].length;j++){
                distanciaTmp = Math.sqrt(((xV-j)*(xV-j))+((yV-i)*(yV-i)));
                
                if(distanciaTmp>volcan.tamaño && distanciaTmp < (volcan.tamaño+5)){
                    
                    daño  = dañoTmp+(dañoTmp*(extra/100.0))-(dañoTmp*(player.tablero[i][j].escudo/100.0));
                    if(player.tablero[i][j].vida > 0){
                        player.tablero[i][j].historial += "La vida de la casilla se redujo de "+player.tablero[i][j].vida+" a "+(player.tablero[i][j].vida-daño)+" por un Thermal Rush enviado por "
                                +atacante.nombre+" con un daño extra de "+extra+" y un escudo de "+player.tablero[i][j].escudo+"\n";
                        
                        res += "La vida de la casilla("+j+","+i+") de "+player.nombre+" se redujo de "+player.tablero[i][j].vida+" a "+(player.tablero[i][j].vida-daño)+" por un Thermal Rush con daño extra de "+extra
                                +" y un escudo de "+player.tablero[i][j].escudo+", el ataque fue enviado por "+atacante.nombre+"\n";
                        player.tablero[i][j].vida -= daño;
                        
                        if(player.tablero[i][j].vida < 0)
                            player.tablero[i][j].vida = 0;
                        player.tablero[i][j].escudo = 0;
                    }
                    else{
                        fallo += "La vida de la casilla ("+j+","+i+") de "+player.nombre+" no se redujo por el ataque de Thermal Rush enviado por "+atacante.nombre+" porque la casillas ya estaba muerta";
                    }
                    
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
    //no se usa
    @Override
    public String attack3(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}