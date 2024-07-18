package arvores;

public class No {

    int chave;
    No esq, dir;

    public No(int k) {
        chave = k;
        esq = null;
        dir = null;
    }

    public No(int k, No e, No d) {
        chave = k;
        esq = e;
        dir = d;
    }

    public int getChave() {
        return this.chave;
    }
}