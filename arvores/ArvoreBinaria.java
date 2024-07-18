package arvores;

public class ArvoreBinaria {
    No root;

    public ArvoreBinaria(No raiz) {
        root = raiz;
    }

    public No getRaiz() {
        return this.root;
    }

    public void preOrdem() {
        this.preOrdem(getRaiz());
    }

    private void preOrdem(No arv) {
        if(arv != null) {
            System.out.print(arv.chave + " ");
            preOrdem(arv.esq);
            preOrdem(arv.dir);

        }
    }

    public void ordem() {
        this.ordem(getRaiz());
    }

    private void ordem(No arv) {
        if(arv != null) {
            ordem(arv.esq);
            System.out.print(arv.chave + " ");
            ordem(arv.dir);
        }
    }

    public void posOrdem() {
        this.posOrdem(getRaiz());
    }

    private void posOrdem(No arv) {
        if(arv != null) {
            posOrdem(arv.esq);
            posOrdem(arv.dir);
            System.out.print(arv.chave + " ");

        }
    }

    

}
