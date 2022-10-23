package jogo;

public class ControladorDeLetrasJaDigitadas implements Cloneable {
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas() {
        this.letrasJaDigitadas = new String();
    }

    public boolean isJaDigitada(char letra) {
        boolean haveDigitada = false;
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            char letter = this.letrasJaDigitadas.charAt(i);
            if (letter == letra) {
                haveDigitada = true;
                break;
            }
        }
        return haveDigitada;
    }

    public void registre(char letra) throws Exception {
        String message = "Letra já digitada";
        try {
            boolean jaDigitada = this.isJaDigitada(letra);
            if (jaDigitada) {
                throw new Exception(message);
            }
            this.letrasJaDigitadas = this.letrasJaDigitadas + letra;
        } catch (Exception e) {
        }
    }

    @Override // override toString method from object inheritance class
    public String toString() {
        String comVirgulas = new String();
        for (int i = 0; i < this.letrasJaDigitadas.length(); i++) {
            comVirgulas += this.letrasJaDigitadas.charAt(i) + ",";
        }
        return comVirgulas;
    }

    @Override // override equals method inheritance class
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas = (ControladorDeLetrasJaDigitadas) obj;
        if (!this.letrasJaDigitadas.equals(controladorDeLetrasJaDigitadas.letrasJaDigitadas))
            return false;
        return true;
    }

    public int hashCode() {
        int ret = 1;
        ret = 13 * ret + new String(this.letrasJaDigitadas).hashCode();
        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public ControladorDeLetrasJaDigitadas(
            ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
            throws Exception // construtor de cópia
    {
        ControladorDeLetrasJaDigitadas copyOfControlador = new ControladorDeLetrasJaDigitadas();
        copyOfControlador.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
        this.letrasJaDigitadas = copyOfControlador.letrasJaDigitadas;
    }

    public Object clone() {
        ControladorDeLetrasJaDigitadas ret = null;
        try {
            ret = new ControladorDeLetrasJaDigitadas(this);
        } catch (Exception e) {
        }
        return ret;
    }
}
