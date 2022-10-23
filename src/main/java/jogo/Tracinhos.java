package jogo;

public class Tracinhos implements Cloneable {
    private char[] texto;

    public Tracinhos(int qtd) throws Exception {
        if (qtd <= 0) {
            throw new Exception("Valor");
        }
        this.texto = new char[qtd];
        for (int i = 0; i < qtd; i++) {
            this.texto[i] = '_';
        }
    }

    public void revele(int posicao, char letra) throws Exception {
        try {
            if (posicao < 0 || posicao >= this.texto.length) {
                throw new Exception("Valor inválido de posição!");
            }
            this.texto[posicao] = letra;
        } catch (Exception e) {
            throw new Exception("Erro");
        }
    }

    public boolean isAindaComTracinhos() {
        boolean aindaComTracinhos = false;
        for (int i = 0; i < this.texto.length; i++) {
            if (this.texto[i] == '_') {
                aindaComTracinhos = true;
                break; // quebra o loop no primeiro caso = menos perca de memória.
            }
        }
        return aindaComTracinhos;
    }

    @Override
    public String toString() {
        String comEspacos = "";
        for (int i = 0; i < this.texto.length; i++) {
            comEspacos += this.texto[i] + " ";
        }
        // should be Arrays.toString() ?
        return comEspacos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Tracinhos tracinhos = (Tracinhos) obj;
        if(this.texto.length != tracinhos.texto.length) return false;
        for (int i = 0; i < this.texto.length; i++) {
            if(this.texto[i] != tracinhos.texto[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int ret = 1;
        for (int i = 0; i < this.texto.length; i++) {
            ret = 13 * ret + Character.valueOf(this.texto[i]).hashCode();
        }

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    // construtor de cópia
    public Tracinhos(Tracinhos t) throws Exception {
        try {
            int qtd = t.texto.length;
            this.texto = new char[qtd];
            // basicly copyes the array with the size I want, in case t.texto.length
            System.arraycopy(t.texto, 0, this.texto, 0, qtd);
            /*
             * for (int i = 0; i < qtd; i++) {
             * this.texto[i] = t.texto[i];
             * }
             */
        } catch (Exception e) {
            throw new Exception("Erro na cópia!");
        }
    }

    @Override
    public Object clone() {
        Tracinhos ret = null;
        try {
            ret = new Tracinhos(this);
        } catch (Exception e) { // Ignorando o Exception, pois sei que não vai dar;{
        }
        return ret;
    }
}
