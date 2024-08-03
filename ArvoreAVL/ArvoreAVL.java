package ArvoreAVL;

public class ArvoreAVL {

    No raiz = null;

    public ArvoreAVL() {}

    public void inserir(int ch, String v) {
        raiz = inserir(raiz, ch, v);
    }

    private No inserir(No arv, int ch, String v) {
        if (arv == null) {
            return new No(ch, v);
        }
        
        if (ch < arv.chave) {
            arv.esq = inserir(arv.esq, ch, v);
        }
        
        else if (ch > arv.chave) {  
            arv.dir = inserir(arv.dir, ch, v);
        }
        else {
            return arv;
        }
        
        arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

        //Calculando fator de balanceamento (fb)
        int fb = ObterFB(arv);
        int fbSubArvEsq = ObterFB(arv.esq);
        int fbSubArvDir = ObterFB(arv.dir);

        //Rotação direita simples//
        if (fb > 1 && fbSubArvEsq >= 0) {
            return rotacaoDireitaSimples(arv);
        }   

        //Rotação esquerda simples
        if (fb < -1 && fbSubArvDir <= 0) {
            return rotacaoEsquerdaSimples(arv);
        }

        //Rotação dupla direita
        if (fb > 1 && fbSubArvEsq < 0) {
            rotacaoDireitaDupla(arv);
        }

        //Rotação dupla esquerda
        if (fb < -1 && fbSubArvDir > 0) {
            rotacaoEsquerdaDupla(arv);
        }

        return arv;
    }


    private int altura(No arv) {
        if (arv == null) {
            return -1;
        }
        return arv.alturaNo;
    }

    private int maior(int a, int b) {
        return (a < b) ? a : b;
    }
  
    private int ObterFB(No arv) {
        if (arv == null) {
            return 0;
        }

        return altura(arv.esq) - altura(arv.dir);
    }

    private No rotacaoDireitaSimples(No x) {
        No y = x.esq;  //Nó a esquerda do X passado como parametro
        No z = y.dir;  //Nó a direita do Y anterior

        y.dir = x;
        x.esq = z;

        x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
        y.alturaNo = maior(altura(y.esq), altura(y.dir)) + 1; 

        return y;
    }

    private No rotacaoEsquerdaSimples(No x) {
        No y = x.dir; //Nó a direita do X passado como parametro
        No z = y.esq; //No a esquerda do nó anterior

        y.esq = x;
        x.dir = z;

        //Atualizar as alturas

        x.alturaNo = maior(altura(x.esq), altura(x.dir)) + 1;
        y.alturaNo = maior(altura(y.esq), altura(y.dir)) + 1;

        //y vai ser a nova raiz, entao retornar y.
        return y;
    }

    private No rotacaoDireitaDupla(No arv) {
        arv.esq = rotacaoEsquerdaSimples(arv.esq);
        return rotacaoDireitaSimples(arv);
    }

    private No rotacaoEsquerdaDupla(No arv) {
        arv.dir = rotacaoDireitaSimples(arv.dir);
        return rotacaoEsquerdaSimples(arv);
    }

    public void remover (int ch, String v) {
        raiz = remover(raiz, ch, v);
    }
    private No remover(No arv, int ch, String v) {
        

        //Percorrendo a arvore
        if (arv == null) {
            return arv;
        }
        
        if (ch < arv.chave) {
            arv.esq = remover(arv.esq, ch, v);
        }

        else if (ch > arv.chave) {
            arv.dir = remover(arv.dir, ch, v);
        }

        else {

            //CASO NÓ NAO TENHA FILHOS 

            if (arv.esq == null && arv.dir == null) {
                arv = null;
            } 

            //NÓ SÓ TEM FILHO A DIREITA
            else if (arv.esq == null) {
                No temp = arv;
                arv = temp.dir;
                temp = null;
            }


            //NO SO TEM FILHO A ESQUERDA
            else if (arv.dir == null) {
                No temp = arv;
                arv = temp.esq;
                temp = null;
            }

            /*Nó com 2 filhos: pegue o sucessor do percurso em ordem
              Menor chave da subárvore direita do nó */
            else {
                No temp = menorChave(arv.dir);

                arv.chave = temp.chave;
                temp.chave = ch;

                arv.dir = remover(arv.dir, ch, v);
            }
        }
        if(arv == null) {
            return arv;
        }
        
        arv.alturaNo = 1 + maior(altura(arv.esq), altura(arv.dir));

        //Calculando fator de balanceamento (fb)
        int fb = ObterFB(arv);
        int fbSubArvEsq = ObterFB(arv.esq);
        int fbSubArvDir = ObterFB(arv.dir);

        //Rotação direita simples//
        if (fb > 1 && fbSubArvEsq >= 0) {
            return rotacaoDireitaSimples(arv);
        }   

        //Rotação esquerda simples
        if (fb < -1 && fbSubArvDir <= 0) {
            return rotacaoEsquerdaSimples(arv);
        }

        //Rotação dupla direita
        if (fb > 1 && fbSubArvEsq < 0) {
            rotacaoDireitaDupla(arv);
        }

        //Rotação dupla esquerda
        if (fb < -1 && fbSubArvDir > 0) {
            rotacaoEsquerdaDupla(arv);
        }

        return arv;

    }

    public No menorChave(No arv) {
        if (arv == null) {
            return null;
        }

        No temp = arv;
        while (temp.esq != null) {
            temp = temp.esq;
        }
        return temp;
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

    public No getRaiz() {
        return this.raiz;
    }

}
