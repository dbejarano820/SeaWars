/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;
import Client.*;
import Server.*;
import java.util.Random;


/**
 *
 * @author PERSONAL
 */

/*
 1. En el volcan y para el remolino hay unos datos para que escoja el metodo que a usted le parezca mas
 2. Falta agregarle el atributo escudo a las casillas, no lo toque para evitar que se despiche
 3. Faltaria lo de las clases de volcan y remolino y agregarle un ArrayList a los players, tambien evite tocar eso para no dsespichar
 --4. Arreglar lo de los Strings, no se que le parece mejor si como a la hora de retornar el string que de una vez diga como el extra y el escudo que tiene aunque no tenga, asi evitamos hacer validaciones demas
           y siento yo que queda mas organizado, un ejemplo de eso esta en los ultimos algoritmos
 --5. Preguntar al profe lo del daño del volcan por eso solo falta ese algoritmo
 6. Alguna que otra validacion jajajaj

*/
public interface Superpower {
    
    String attack1(Player player,Player atacante);
    String attack2(Player player,Player atacante);
    String attack3(Player player,Player atacante);
    
}
//revision
class TheTrident implements Superpower{
    
    //revision three lines
    public String attack1(Player player,Player atacante, int x1, int x2, int x3, int y1, int y2, int y3){//three lines
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
                    res += "La casilla("+x1+","+y1+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y1--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(y2 < 0)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y2--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(y3 < 0)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
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
                    res += "La casilla("+x1+","+y1+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x1--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(x2 < 0)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x2--;
            }
            
            for(int i = 0; i<cantCasillas; i++){
                if(x3 < 0)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
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
                    res += "La casilla("+x1+","+y1+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y1++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(y3 > 19)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y1+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                y3++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(y2 > 19)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
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
                    res += "La casilla("+x1+","+y1+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x1+","+y1+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x1++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(x2 > 29)
                    break;
                if(player.tablero[y2][x2].vida > 0){
                    player.tablero[y2][x2].vida = 0;
                    player.tablero[y2][x2].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x2+","+y2+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x2+","+y2+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x2++;
            }
            for(int i = 0; i<cantCasillas; i++){
                if(x3 > 29)
                    break;
                if(player.tablero[y3][x3].vida > 0){
                    player.tablero[y3][x3].vida = 0;
                    player.tablero[y3][x3].historial += "Fue destruido por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                    res += "La casilla("+x3+","+y3+") fue destruida por un tridente de poseidon enviado por "+atacante.nombre+"\n";
                }
                else{
                    fallo += "La casilla("+x3+","+y3+") intento ser destruida por un tridente de poseidon enviado por "+atacante.nombre+" pero ya estaba muerta\n";
                }
                x3++;
            }
            
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    
    //tocar los casos de los threads
    // three numbers
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
            
            if(!player.estaVivo())
                break;
            if(player.tablero[y][x].vida > 0){
                player.tablero[y][x].vida = 0;
                player.tablero[y][x].historial += "Fue destruida por el Three Numbers enviado por "+atacante.nombre+"\n";
                res += "La casilla("+x+","+y+") fue destruida por el Three Numbers enviado por "+atacante.nombre+"\n";
            }
            else{
                fallo += "La casilla("+x+","+y+") iba a ser destruida por el Three Numbers enviado por "+atacante.nombre+" pero ya estaba muerta\n";
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    //revision
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

class ThundersUnderTheSea implements Superpower{
    
    
    //Thunder under the sea
    
    public String attack1(Player player,Player atacante, int extra){
        String res = "";
        String fallo = "";
        int x;
        int y;
        
        for(int i = 0; i < 100;i++){
            
            double daño = new Random().nextInt(11)+10;
            
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            daño = daño +(daño*(extra/100.0))-(daño*(player.tablero[y][x].escudo/100.0));
            
            if(player.tablero[y][x].vida > 0){
                
                player.tablero[y][x].historial += "La casilla fue atacada con un rayo y paso su vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño);
                res += "Se ataco la casilla("+x+","+y+") con un rayo y paso su vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+" con un escudo de "+
                        player.tablero[y][x].escudo+" y un daño extra de "+extra+", el ataque fue enviado por "+atacante.nombre+" \n";

                player.tablero[y][x].vida -= daño;
            }
            else{
                fallo += "Se intento atacar la casilla("+x+","+y+") con un rayo pero ya estaba muerta \n";
            }

        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    //poseidon thunders revision
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
                            player.tablero[k][j].historial += "La casilla fue destruida por un rayo de Poseidon enviado por "+atacante.nombre+"\n";
                            res += "La casilla ("+j+","+k+") fue destruida por un rayo de Poseidon enviado por"+atacante.nombre+"\n";
                        }
                        else{
                            fallo += "La casilla ("+j+","+k+") iba a ser destruida por un rayo de Poseidon enviado por"+atacante.nombre+" pero ya estaba muerta\n";
                        }
                    }
                }
            }   
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    //anguilas revision
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
                    
                    player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida - daño)+" por un ataque de Anguilas enviado por "+
                            atacante.nombre+", hubo un daño extra de "+extra+" y la casilla poseia un escudo de "+player.tablero[y][x].escudo+"\n";
                    
                    res += "Se redujo la vida de la casilla ("+x+","+y+") de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida - daño)+" por un ataque de Anguilas enviado por "+
                            atacante.nombre+", hubo un daño extra de "+extra+" y la casilla poseia un escudo de "+player.tablero[y][x].escudo+"\n";
                    
                    player.tablero[y][x].vida -= daño;
                    if(player.tablero[y][x].vida < 0)//agregar a los casos donde se reduce una cantidad de vida especifica
                        player.tablero[y][x].vida = 0;
                }
                else{
                    fallo += "Se intento atacar la casilla ("+x+","+y+") con un ataque de anguilas enviado por "+
                            atacante.nombre+" pero esta ya estaba muerta";
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
//revision    
class ReleaseTheKraken implements Superpower{
    
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


class FishTelepathy implements Superpower{
    
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
                            +player.tablero[y][x].escudo+" enviado por "+atacante.nombre;
                    player.tablero[y][x].vida -= daño;
                }
                else{
                    res += "Un pulpo intento atacar la casilla ("+x+","+y+") pero ya estaba muerta";
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

class UnderseaVolcanoes implements Superpower{
    
    @Override//crear volcan revision
    public String attack1(Player player,Player atacante){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        
        int volcanTamaño = new Random().nextInt(10)+1;
        double distanciaTmp;
        int x = new Random().nextInt(30);
        int y = new Random().nextInt(20);
        //player.listaVolcanes.add(new Volcan(x,y,volcanTamaño));
        
        for(int i = 0; i < player.tablero.length; i++){
            for (int j = 0; j < player.tablero[i].length; j++){
                distanciaTmp = Math.sqrt(((x-i)*(x-i))+((y-j)*(y-j)));
                
                if(distanciaTmp <= volcanTamaño){
                    if( !player.tablero[j][i].activeWhirlpool){
                        player.tablero[j][i].activeVolcano  = true;
                        player.tablero[j][i].vida = 0;
                        player.tablero[j][i].historial += "Se creo un volcan enviado por "+atacante.nombre+"\n";
                        res += "En la casilla ("+i+","+j+") se creo un volcan enviado por "+atacante.nombre+"\n";
                        
                    }
                    
                    else{
                        fallo +=   "En la casilla ("+i+","+j+") se intento crear un volcan enviado por "+atacante.nombre+" porque ya tenia un remolino\n";
                    }
                }  
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
    }
    
    
    public String attack2(Player player,Player atacante, int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        //bro aqui no se si quiere como extraer un volcan random de la lista del player o que el atacante intente buscar uno conm un metodo de buscar por mediod e coordenadas
        int cantPiedras = volcan.tamaño*volcan.tamaño*10;
        int x;
        int y;
        for(int i = 0; i < cantPiedras;i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            double daño = 20 +(20*(extra/100.0))-(20*(player.tablero[y][x].escudo/100.0));
            if(player.tablero[y][x].vida > 0){
                
                player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " por una roca enviada por un volcan enviado de "+atacante.nombre;
                
                res += "Se redujo la vida de la casilla("+x+","+y+") de"+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " con un daño extra de "+extra+" y un escudo de "+player.tablero[y][x].escudo+" por una roca enviada por un volcan enviado de "+atacante.nombre;
                player.tablero[y][x].vida -= daño;
            }
            else{
                fallo += "No se redujo la vida de la casilla("+x+","+y+")  por una roca enviada por un volcan enviado de "+atacante.nombre+" porque la casillas ya estba muerta";
            }
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    @Override//preguntarle al profe lo del daño
    public String attack3(Player player,Player atacante){
        String res = "";
        
        return res;
    }
    
    //no se usa
    @Override
    public String attack2(Player player, Player atacante) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class WavesControl implements Superpower{
    
    
    @Override//crear remolino
    public String attack1(Player player,Player atacante){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        
        int remolinoTamaño = new Random().nextInt(9)+2;
        double distanciaTmp;
        int x = new Random().nextInt(30);
        int y = new Random().nextInt(20);
        //player.listaRemolinos.add(new Volcan(x,y,volcanTamaño));
        
        for(int i = 0; i < player.tablero.length; i++){
            for (int j = 0; j < player.tablero[i].length; j++){
                distanciaTmp = Math.sqrt(((x-i)*(x-i))+((y-j)*(y-j)));
                
                if(distanciaTmp <= remolinoTamaño){
                    if( !player.tablero[j][i].activeVolcano){
                        player.tablero[j][i].activeWhirlpool  = true;
                        player.tablero[j][i].vida = 0;
                        player.tablero[j][i].historial += "Se creo un remolino enviado por "+atacante.nombre+"\n";
                        res += "En la casilla ("+i+","+j+") se creo un remolino enviado por "+atacante.nombre+"\n";
                        
                    }
                    
                    else{
                        fallo +=   "En la casilla ("+i+","+j+") se intento crear un remolino enviado por "+atacante.nombre+" porque ya tenia un volcan\n";
                    }
                }  
            }
        }
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        
        return res+fallo;
        
    }
    
    
    //enviar basura revision
    public String attack2(Player player,Player atacante, int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        //bro aqui no se si quiere como extraer un remolino random de la lista del player o que el atacante intente buscar uno conm un metodo de buscar por mediod e coordenadas
        int cantBasura = (remolino.tamaño/2)*10;
        int x;
        int y;
        for(int i = 0; i < cantBasura;i++){
            x = new Random().nextInt(30);
            y = new Random().nextInt(20);
            double daño;
            int radioactiva = new Random().nextInt(2);
            
            if(player.tablero[y][x].vida > 0){
                if(radioactiva == 0)
                    daño = 25 +(25*(extra/100.0))-(25*(player.tablero[y][x].escudo/100.0));
                else{
                    daño = 50 +(50*(extra/100.0))-(50*(player.tablero[y][x].escudo/100.0));
                    player.tablero[y][x].cantBasuraRactiva++;
                }
                    
                
                player.tablero[y][x].historial += "Se redujo la vida de "+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " por basura enviada por un remolino enviado de "+atacante.nombre;
                
                res += "Se redujo la vida de la casilla("+x+","+y+") de"+player.tablero[y][x].vida+" a "+(player.tablero[y][x].vida-daño)+
                        " con un daño extra de "+extra+" y un escudo de "+player.tablero[y][x].escudo+" por basura enviada por un remolino enviado de "+atacante.nombre;
                player.tablero[y][x].vida -= daño;
            }
            else{
                fallo += "No se redujo la vida de la casilla("+x+","+y+")  por una roca enviada por un volcan enviado de "+atacante.nombre+" porque la casilla ya estba muerta";
            }
        }
        
        if(!res.equals(""))
            atacante.cantidadAtinados++;
        return res+fallo;
    }
    
    public String attack3(Player player,Player atacante,int extra){
        String res = "";
        String fallo = "";
        atacante.cantidadAtaques++;
        int segundos = new Random().nextInt(10)+1;
        int preDaño;
        double daño;
        
        for(int i = 0; i < player.tablero.length;i++){
            
            for(int j = 0; j < player.tablero[i].length;j++){
                
                if(player.tablero[j][i].vida > 0){
                    preDaño = 10*segundos*player.tablero[j][i].cantBasuraRactiva;
                    daño  = preDaño + (preDaño*(extra/100.0))-(preDaño*(player.tablero[j][i].escudo/100.0));
                    player.tablero[j][i].historial += "La casilla redujo su vida de "+player.tablero[j][i].vida+" a "+(player.tablero[j][i].vida-daño);
                    res+= "La casilla("+i+","+j+") redujo su vida de "+player.tablero[j][i].vida+" a "+(player.tablero[j][i].vida-daño)+" con un daño extra de "+extra+" y un escudo de "
                            +player.tablero[j][i].escudo+" por una reaccion radioactiva enviada por "+atacante.nombre+"\n";
                    
                    player.tablero[j][i].vida -= daño;
                    
                    if(player.tablero[j][i].vida<0)
                        player.tablero[j][i].vida = 0;
                    
                }
                else{
                    fallo += "La casilla("+i+","+j+") no redujo su vida de  por una reaccion radioactiva enviada por "+atacante.nombre+" porque ya estaba muerta\n";
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
            
 //otros superpowers
    

