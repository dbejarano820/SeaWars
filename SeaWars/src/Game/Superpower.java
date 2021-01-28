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
    
    public String nombre = "";
    String attack1(Player player,Player atacante);
    String attack2(Player player,Player atacante);
    String attack3(Player player,Player atacante);
    
}


