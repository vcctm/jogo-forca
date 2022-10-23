package intraclasses;

import jogo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 Métodos:
 Construtor()
 registreUmErro()
 isAtingidoMaximoDeErros()

 -> Métodos padrões foram ignorados.


 1.1
 Para a classe ControladorDeErros existem dois estados da classe
 quando qtdMax de erros é maior que a qtdErr = máximo não atingido
 quando qtdMax de erros é menor oou igual a qtdErr = máximo atingido

 Transições:
 máximo não atingido - máximo não atingido; // errou mas não no limite
 máximo não atingido - máximo atingido; // errou todas
 máximo atingido - máximo não atingido; // reset de palavra

 1.2
 Sequências que alteram estado:
 Construtor(2) -> registreUmErro() -> registreUmErro()[alteração de estado] -> isAtingidoMáximodeErros();


*/


// 1.3
public class ControladorDeErrosTest {
    @Test
    public void reachMaxErros() {
        try {
            ControladorDeErros controladorDeErros = new ControladorDeErros(2);
            controladorDeErros.registreUmErro(); // qtdErr = 1;
            controladorDeErros.registreUmErro(); // qtdErr = 2 = qtdMax;
            assertEquals(true, controladorDeErros.isAtingidoMaximoDeErros()); // check de estado
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    @Test
    public void dontReachMaxErros() {
        try {
            ControladorDeErros controladorDeErros = new ControladorDeErros(2);
            controladorDeErros.registreUmErro(); // qtdErr = 1;
            assertEquals(false, controladorDeErros.isAtingidoMaximoDeErros()); // check de estado
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
