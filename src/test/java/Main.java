import jogo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {

    @Test
    public void tracinhosGetMessageTestNull() {
        try {
            Tracinhos tracinhos = new Tracinhos(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Erro na cópia!");
        }
    }

    @Test
    public void tracinhosGetMessageTestError() {
        try {
            Tracinhos tracinhos = new Tracinhos(0);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Valor");
        }
    }

    @Test
    public void tracinhosGetMessageTestInvalidPosition() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            tracinhos.revele(0, 'a');
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Valor inválido de posição!");
        }
    }

    @Test
    public void tracinhosGetMessageTestOutOfRange() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            tracinhos.revele(11, 'a');
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Erro");
        }
    }

    @Test
    public void tracinhosIsAindaComTracinhosTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            assertTrue(tracinhos.isAindaComTracinhos());
        } catch (Exception e) {
        }
    }

    @Test
    public void tracinhosIsAindaComTracinhosFalseTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            for (int i = 0; i < 10; i++) {
                tracinhos.revele(i, 'a');
            }
            boolean valor = tracinhos.isAindaComTracinhos();
            assertEquals(valor, false);
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosToStringTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            String valor = tracinhos.toString();

            assertEquals(valor, "_ _ _ _ _ _ _ _ _ _ ");
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = new Tracinhos(10);
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsTestFalse() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = new Tracinhos(10);
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosEqualsCloneTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = (Tracinhos) tracinhos.clone();
            assertTrue(tracinhos.equals(tracinhos2));
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosHashCodeTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            int valor = tracinhos.hashCode();

            assertEquals(valor, 877572323);
        } catch (Exception e) {}
    }

    @Test
    public void tracinhosCloneTest() {
        try {
            Tracinhos tracinhos = new Tracinhos(10);
            Tracinhos tracinhos2 = (Tracinhos) tracinhos.clone();

            assertEquals(tracinhos, tracinhos2);
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTestNull() {
        try {
            ControladorDeErros erros = new ControladorDeErros(null);
            
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Erro construtor!"); // copy constructor called
        }
    }

    @Test
    public void controladorDeErrosTest() {
        try {
            ControladorDeErros erros = new ControladorDeErros(0);

        } catch (Exception e) {
            assertEquals(e.getMessage(), "Quantidade não positiva");
        }
    }

    @Test
    public void controladorDeErrosTestGetMessage() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            erros.registreUmErro();
            erros.registreUmErro();
            
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Máximo de erros atingidos");
        }
    }

    @Test
    public void controladorDeErrosTestIsAtingido() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            erros.registreUmErro();
            assertTrue(erros.isAtingidoMaximoDeErros());           
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTestToString() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            assertEquals(erros.toString(), "1/2");           
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeErrosTestHashCode() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            erros.registreUmErro();
            assertEquals(erros.hashCode(), 184);           
        } catch (Exception e) {}
    }


    @Test
    public void controladorDeErrosTestClone() {
        try {
            ControladorDeErros erros = new ControladorDeErros(2); 
            ControladorDeErros erros2 = (ControladorDeErros) erros.clone();
            assertTrue(erros.equals(erros2));           
        } catch (Exception e) {}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaFalse() {
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();

        assertFalse(controladorDeLetrasJaDigitadas.isJaDigitada('A'));
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitada() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            assertTrue(controladorDeLetrasJaDigitadas.isJaDigitada('A'));
        } catch(Exception e){}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaRegistre() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            controladorDeLetrasJaDigitadas.registre('A');
        } catch(Exception e){
            assertEquals(e.getMessage(), "Letra já digitada");
        }
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaToString() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            controladorDeLetrasJaDigitadas.registre('B');
            controladorDeLetrasJaDigitadas.registre('C');
            controladorDeLetrasJaDigitadas.registre('D');
            assertEquals(controladorDeLetrasJaDigitadas.toString(), "A,B,C,D,");
        } catch(Exception e) {}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaEquals() {
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas2 = new ControladorDeLetrasJaDigitadas();

        assertTrue(controladorDeLetrasJaDigitadas.equals(controladorDeLetrasJaDigitadas2));
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaHashCode() {
        try {
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
            controladorDeLetrasJaDigitadas.registre('A');
            controladorDeLetrasJaDigitadas.registre('B');
            assertEquals(controladorDeLetrasJaDigitadas.hashCode(), 2094);
        } catch(Exception e) {}
    }

    @Test
    public void controladorDeLetrasTestIsJaDigitadaClone() {
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = new ControladorDeLetrasJaDigitadas();
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas2 = (ControladorDeLetrasJaDigitadas) controladorDeLetrasJaDigitadas.clone();
        assertTrue(controladorDeLetrasJaDigitadas.equals(controladorDeLetrasJaDigitadas2));
    }

    @Test
    public void palavraTest() {
        try {
            Palavra palavra = new Palavra("");

        } catch(Exception e) {
            assertEquals(e.getMessage(), "Texto inválido!");
        }
    }

    @Test
    public void palavraTestNull() {
        try {
            Palavra palavra = new Palavra(null);

        } catch(Exception e) {
            assertEquals(e.getMessage(), "Texto inválido!");
        }
    }

    @Test
    public void palavraTestGetQuantidade() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.getQuantidade('E'), 2);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestGetPosicaoDaIezimaOcorrencia() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.getPosicaoDaIezimaOcorrencia(2, 'E'), 5);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestGetTamanho() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.getTamanho(), 5);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestToString() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.toString(), "TESTE");
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestHashCode() {
        try {
            Palavra palavra = new Palavra("TESTE");

            assertEquals(palavra.hashCode(), 79713792);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestEquals() {
        try {
            Palavra palavra = new Palavra("TESTE");
            Palavra palavra2 = new Palavra("TESTE");

            assertTrue(palavra.equals(palavra2));
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestEqualsFalse() {
        try {
            Palavra palavra = new Palavra("TESTE");
            Palavra palavra2 = new Palavra("TESTEs");

            assertFalse(palavra.equals(palavra2));
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestCompareTo() {
        try {
            Palavra palavra = new Palavra("TESTE");
            Palavra palavra2 = new Palavra("TESTE");

            assertEquals(palavra.compareTo(palavra2), 0);
        } catch (Exception e) {}
    }

    @Test
    public void palavraTestCompareToFalse() {
        try {
            Palavra palavra = new Palavra("TESTE");
            Palavra palavra2 = new Palavra("TESTEs");

            assertEquals(palavra.compareTo(palavra2), -1);
        } catch (Exception e) {}
    }
}
