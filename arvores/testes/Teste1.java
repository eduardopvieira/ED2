package arvores.testes;

import arvores.ArvoreBinaria;
import arvores.ArvoreBinariaBusca;
import arvores.No;

public class Teste1 {
    public static void main(String[] args) {
        
        /*
         * Nós do nível 3
         */
        No no7 = new No(7);
        No no10 = new No(10);
        No no16 = new No(16);
        
        /*
         * Nós do nível 2
         */

        No no4 = new No(4);
        No no9 = new No(9, no7, no10);
        No no17 = new No(17, no16, null);
        
        //Nós do nível 1

        No no6 = new No(6, no4, no9);
        No no13 = new No(13, null, no17);

        //Nó raiz

        No no11 = new No(11, no6, no13);
        
        /*/
        
        ArvoreBinaria ab = new ArvoreBinaria(no11);
        System.out.println("");
        System.out.println("======= PRE-ORDEM =======");
        ab.preOrdem();
        System.out.println("");
        System.out.println("======= ORDEM =======");
        ab.ordem();
        System.out.println("");
        System.out.println("======= POS-ORDEM =======");
        ab.posOrdem();

        */

        ArvoreBinariaBusca abb = new ArvoreBinariaBusca(no11);
        System.out.println(abb.altura(no11));

        // No a = abb.buscar(100, no11);
        
        // if (a != null) {
        //     System.out.println("O numero procurado está na arvore");
        // } else {
        //     System.out.println("O numero procurado nao esta na arvore");
        // }

        abb.inserir(8);
        abb.ordem();
        
    }
}
