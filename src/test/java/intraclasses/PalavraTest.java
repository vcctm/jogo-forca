package intraclasses;

import jogo.Palavra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Métodos:
 Construtor()
 registreUmErro()
 isAtingidoMaximoDeErros()

 -> Métodos padrões foram ignorados.


 1.1
 Para a classe Palavra não indentificamos um estado definido
 então faremos o particionamento por categorias de métodos.

 Categorias:
 -> Inicialização: Contrutor()
 -> Consulta: getQuantidade(), getPosicaoDaIezimaOcorrencia(), getTamanho()

 // (deconsideramos os métodos padrões como: hashCode, equals, compareTo, toString)

 1.2
 Não há estados relevantes;


*/


// 1.3
public class PalavraTest {
    @Test
    public void inicializationTest() {
        try {
            Palavra palavra = new Palavra("JAVA");
            assertEquals("JAVA",palavra.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @Test
    public void getTest() {
        try {
            Palavra palavra = new Palavra("JAVA");
            int qtd = palavra.getQuantidade('A');
            assertEquals(2, qtd);

            int pos = palavra.getPosicaoDaIezimaOcorrencia(0,'A');
            assertEquals(1, pos);

            int size = palavra.getTamanho();
            assertEquals(size, 4);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
