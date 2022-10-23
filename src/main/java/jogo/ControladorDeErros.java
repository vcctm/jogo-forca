package jogo;

public class ControladorDeErros implements Cloneable {
    private int qtdMax, qtdErr = 0;

    public ControladorDeErros(int qtdMax) throws Exception {
        if (qtdMax > 0) {
            this.qtdMax = qtdMax;
        } else {
            throw new Exception("Quantidade não positiva");
        }
    }

    public void registreUmErro() throws Exception {
        if (this.qtdErr == this.qtdMax) {
            throw new Exception("Máximo de erros atingidos");
        } else {
            this.qtdErr = this.qtdErr + 1;
        }
    }

    public boolean isAtingidoMaximoDeErros() {
        return this.qtdErr == this.qtdMax;
    }

    @Override
    public String toString() {
        return this.qtdErr + "/" + this.qtdMax;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        ControladorDeErros controladorDeErros = (ControladorDeErros) obj;
        if (this.qtdMax != controladorDeErros.qtdMax)
            return false;
        if (this.qtdErr != controladorDeErros.qtdErr)
            return false;
        return true;
    }

    public int hashCode() {
        int ret = 1;
        ret = 13 * ret + Integer.valueOf(this.qtdErr).hashCode();
        ret = 13 * ret + Integer.valueOf(this.qtdMax).hashCode();

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    public ControladorDeErros(ControladorDeErros c) throws Exception // construtor de c?pia
    {
        try {
            this.qtdErr = c.qtdErr;
            this.qtdMax = c.qtdMax;
        } catch (Exception e) {
            throw new Exception("Erro construtor!");
        }
    }

    public Object clone() {
        ControladorDeErros ret = null;
        try {
            ret = new ControladorDeErros(this);
        } catch (Exception e) {
        } // Ignorando o Exception, pois sei que não vai dar;
        return ret;
    }
}
