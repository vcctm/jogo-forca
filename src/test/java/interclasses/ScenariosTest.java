package interclasses;

import interclasses.utils.GFG;
import jogo.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScenariosTest {
  /*
   Cenário: Jogador Ganha o Jogo
   Test: winGameTest

   Sequência de métodos:
   1 - palavra = BancoDePalavras.getPalavraSorteada();
   2 - tamanho = word.getTamanho();
   3 - tracinhos = Tracinhos(size);
   4 - ctrLetras = ControladorDeLetrasJaDigitadas();
   5 - ctrErros = ControladorDeErros(tamanho*0.6);
   // desconsideramos getChar do teclado para automatizar o teste
   6 - Tracinhos.isAindaComTracinhos() // condição do loop
   7 - ctrLetras.isJaDigitada() // quebra o teste caso tenha digitado
   8 - palavra.getQuantidade()
   9 - palavra.getPosicaoDaIezimaOcorrencia(i, letra);
   10 - tracinhos.revele(posicao, letra);
   11 - ctrLetras.registre()
   12 - FIM // venceu o jogo
  */

  @Test
  public void winGameTest() {
    try {
      Palavra palavra = BancoDePalavras.getPalavraSorteada();
      int tamanho = palavra.getTamanho();
      List<Character> removedDuplicatesLetters = GFG.removeDuplicate(palavra.toString().toCharArray(), tamanho);
      Tracinhos tracinhos = new Tracinhos(tamanho);
      ControladorDeLetrasJaDigitadas ctrLetras = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros ctrErros = new ControladorDeErros((int) (tamanho * 0.6));
    /*
     Com o for abaixo garantimos que não tera o uso de letras repetidas em algum momento.
    */
      for (int i = 0; tracinhos.isAindaComTracinhos(); i++) {
        char letra = removedDuplicatesLetters.get(i);
        if (ctrLetras.isJaDigitada(letra)) break;
        int qtd = palavra.getQuantidade(letra);
        for (int j = 0; j < qtd; j++) {
          int posicao = palavra.getPosicaoDaIezimaOcorrencia(j, letra);
          tracinhos.revele(posicao, letra);
        }
        ctrLetras.registre(letra);
      }
      String assertion = "";
      for (int i = 0; i < palavra.getTamanho(); i++) {
        char letra = palavra.toString().charAt(i);
        assertion += letra + " ";
      }
      assertEquals(assertion, tracinhos.toString());
      if (!tracinhos.isAindaComTracinhos() && !ctrErros.isAtingidoMaximoDeErros()) {
        System.out.println("Fim do teste! jogador ganhou!");
      }
    } catch (Exception e) {
      System.out.println(e.toString());
    }
  }

  /*
    Cenário: Jogador perde o Jogo
    Test: loseGameTest

    Sequência de métodos:
    1 - palavra = BancoDePalavras.getPalavraSorteada();
    2 - tamanho = palavra.getTamanho();
    3 - ctrLetras = ControladorDeLetrasJaDigitadas();
    4 - ctrErros = ControladorDeErros(tamanho*0.6);
    5 - GFG.removeDuplicates(palavra, tamanho); // remove as letras duplicadas.
    // desconsideramos getChar do teclado para automatizar o teste
    6 - ctrErros.isAtingidoMaximoDeErros() // condição do for
    7 - palavra.getQuantidade() // garante que nenhuma letra correta foi digitada.
    8 - ctrLetras.registre()
    9 - ctrErros.registreUmErro() // registra o erro.
  */

  @Test
  public void loseGameTest() throws Exception {
    Character[] alphabet = new Character[26];
    for (int i = 0; i < "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray().length; i++) {
      char[] arr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
      alphabet[i] = arr[i];
    }
    try {
      Palavra palavra = BancoDePalavras.getPalavraSorteada();
      int tamanho = palavra.getTamanho();
      ControladorDeLetrasJaDigitadas ctrLetras = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros ctrErros = new ControladorDeErros((int) (tamanho * 0.6));
      /*
        Buscamos a criação de um método automático de errar em todas as tentativas.
        basicamente criamos um vetor de chars, com todas as letras do alfabeto e iremos remover
        as letras da palavra, assim tentaremos apenas letras erradas.
      */
      List<Character> listLetters = GFG.removeDuplicate(palavra.toString().toCharArray(), tamanho);
      Character[] wrongLetters = new Character[alphabet.length - listLetters.size()];
      int index = 0;
      int count = 0;
      while(count < alphabet.length) {
        if(!listLetters.contains(alphabet[count])) {
          wrongLetters[index] = alphabet[count];
          index++;
        }
        count++;
      }
      /*
       Com o for abaixo garantimos que não serão usadas letras que pertencem a palavra.
      */
      for (int i = 0; !ctrErros.isAtingidoMaximoDeErros(); i++) {
        char letra = wrongLetters[i];
        int qtd = palavra.getQuantidade(letra);
        ctrLetras.registre(letra);
        assertEquals(0, qtd); // garante que não achou letra.
        ctrErros.registreUmErro();
      }
      assertTrue(ctrErros.isAtingidoMaximoDeErros());
      if (ctrErros.isAtingidoMaximoDeErros()) {
        System.out.println("Fim do teste! jogador perdeu!");
      }
    } catch (Exception e) {
        throw e;
    }
  }


/*
    Cenário: Jogador perde o Jogo
    Test: loseGameTest

    Sequência de métodos:
    1 - palavra = Palavra("");
    2 - Fim "Erro: Texto inválido!"
  */

  @Test
  public void wordSizeZero() {
    try {
      Palavra palavra = new Palavra("");
    } catch (Exception e) {
      assertEquals("Texto inválido!", e.getMessage());
    }
  }


/*
    Cenário: Jogador perde o Jogo + letras repetidas
    Test: loseGameTestLetters

    Sequência de métodos:
    1 - palavra = Palavra("CLASSE");
    2 - palavra.getTamanho();
    3 - new ControladorDeLetrasJaDigitadas();
    4 - new ControladorDeErros((int) (tamanho * 0.6));
    5 - ctrErros.isAtingidoMaximoDeErros() // condição de for
    6 - ctrLetras.isJaDigitada()
    7 - ctrErros.registreUmErro();
    8 - palavra.getQuantidade();
    9 - tracinhos.revele();
    10 - ctrLetras.registre();
    11 - FIM!
  */

  @Test
  public void loseGameTestLetters() throws Exception {
    try {
      char[] wordLetters = "JAVA".toCharArray();
      Palavra palavra = new Palavra("JAVA");
      int tamanho = palavra.getTamanho();
      Tracinhos tracinhos = new Tracinhos(tamanho);
      ControladorDeLetrasJaDigitadas ctrLetras = new ControladorDeLetrasJaDigitadas();
      ControladorDeErros ctrErros = new ControladorDeErros((int) (tamanho * 0.6));
      for (int i = 0; !ctrErros.isAtingidoMaximoDeErros(); i++) {
        char letter = wordLetters[i];
        if(ctrLetras.isJaDigitada(letter)) {
          assertTrue(ctrLetras.isJaDigitada(letter));
          System.out.println("Letra repetida!");
          ctrErros.registreUmErro();
          break;
        }
        else if (palavra.getQuantidade(letter) > 0) tracinhos.revele(i, letter);
        else {
          ctrErros.registreUmErro();
        }
        ctrLetras.registre(letter);
      }
    } catch (Exception e) {
      throw e;
    }
  }
}

