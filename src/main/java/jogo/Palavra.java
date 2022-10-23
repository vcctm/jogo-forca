package jogo;
import java.util.Collection;
import java.util.HashMap;

public class Palavra implements Comparable<Palavra> {
    private String texto;

    public Palavra(String texto) throws Exception {
        if (texto == null || texto.length() == 0) {
            throw new Exception("Texto inválido!");
        }
        this.texto = texto;
    }

    public int getQuantidade(char letra) {
        int qtdLetras = 0;
        for (int i = 0; i < this.texto.length(); i++) {
            if (this.texto.charAt(i) == letra) {
                qtdLetras++;
            }
        }
        return qtdLetras;
    }

    public int getPosicaoDaIezimaOcorrencia(int i, char letra) throws Exception {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int count = 1;
        for (int j = 0; j < this.texto.length(); j++) {
            if (this.texto.charAt(j) == letra) {
                hashMap.put(count, j);
                count++;
            }
        }
        Collection<Integer> values = hashMap.values();
        Object[] arr = values.toArray();
        return (int) arr[i];
    }

    public int getTamanho() {
        return this.texto.length();
    }

    public String toString() {
        return this.texto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Palavra palavra = (Palavra) obj;
        if (!this.texto.equals(palavra.texto))
            return false;
        return true;
    }

    public int hashCode() {
        int ret = 1;
        ret = 13 * ret + new String(this.texto).hashCode();

        if (ret < 0)
            ret = -ret;
        return ret;
    }

    @Override
    public int compareTo(Palavra palavra) {
        if(this.texto.equals(palavra.texto)) return 0;
        else if (this.texto.length() > palavra.texto.length()) return 1;
        else if (this.texto.length() < palavra.texto.length()) return -1;
        return 0;
    }
}
