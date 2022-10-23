package intraclasses;
import org.junit.jupiter.api.Test;


/*
 Métodos:
 Construtor()
 revele(posicao, letra)
 isAindaComTracinhos()

 -> Métodos padrões foram ignorados.


 1.1
 Para a classe Tracinhos existem tres estados relevantes:
 quando todas as letras foram reveladas = palavra revelada;
 quando pelo menos uma letra foi reveladas = palavra parcialmente revelada;
 quando nenhuma letra foi revelada = palavra não revelada

 Transições:
 palavra não revelada - palavra parcialmente revelada;
 palavra parcialmente revelada - palavra revelada;

 1.2
 Sequências que alteram estado:
 Construtor(4) -> revele(0, J)[alteração de estado];
 Construtor(4) -> revele(0, J)[alteração de estado]; revele(1, A); revele(3, A); revele(2, V)[alteração do estado];

*/

import jogo.Tracinhos;

import static org.junit.jupiter.api.Assertions.assertEquals;

//1.3
public class TracinhosTest {
    @Test
    public void partialRevealTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(4);
            String str = tracinhos.toString(); // palavra não revelada
            tracinhos.revele(0, 'J');
            str = tracinhos.toString(); // palavra-parcialmente-revelada
            String assertion = "J _ _ _ ";

            assertEquals(str, assertion);
        } catch ( Exception e) {
            System.out.println(e.toString());
        }
    }
    @Test
    public void allRevealTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(4);
            String str = tracinhos.toString(); // palavra não revelada
            tracinhos.revele(0, 'J');
            tracinhos.revele(1, 'A');
            tracinhos.revele(3, 'A');
            tracinhos.revele(2, 'V');
            str = tracinhos.toString(); // palavra-revelada
            String assertion = "J A V A ";

            assertEquals(str, assertion);
        } catch ( Exception e) {
            System.out.println(e.toString());
        }
    }
}
