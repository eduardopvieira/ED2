package arvores;

public class ArvoreBinariaBusca extends ArvoreBinaria {
    public ArvoreBinariaBusca(No raiz) {
        super(raiz);
        //TODO Auto-generated constructor stub
    }

    No raiz;

    public int altura(No arv) {
        int a, b;

        if (arv == null) {
            return -1;
        }

        a = altura(arv.esq);
        b = altura(arv.dir);

        if (a > b) {
            return a + 1;
        } else {
            return b + 1;
        }
    }

    public No buscar (int valor, No arv) {

        if (arv == null) {
            return null;
        }

        if (valor < arv.chave) {
            return this.buscar(valor, arv.esq);
        } else if (valor > arv.chave) {
            return this.buscar(valor, arv.dir);
        } else {
            return arv;
        }
        
    }


    public void inserir (int valor) {
        this.root = this.inserir(root, valor);
    }

    private No inserir(No arv, int valor) {
        if (arv == null) {
            return new No (valor);
        }

        if (valor < arv.chave) {
            arv.esq = this.inserir(arv.esq, valor);
            System.out.println("INSERIU NA ESQUERDA");
        } else if (valor > arv.chave) {
            arv.dir = this.inserir(arv.dir, valor);
            System.out.println("INSERIU NA DIREITA");
        } 
        return arv;
    }

    
}
