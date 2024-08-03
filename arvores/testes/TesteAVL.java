package arvores.testes;

import ArvoreAVL.ArvoreAVL;

public class TesteAVL {

    public static void main(String[] args) {
        ArvoreAVL arvore = new ArvoreAVL();

        arvore.inserir(21, "21");
        arvore.inserir(20, "20");
        arvore.inserir(24, "24");
        arvore.inserir(22, "22");
        arvore.inserir(25, "25");
        arvore.inserir(27, "27");
        arvore.inserir(21, "21"); //testando a inserçao dupla

        arvore.ordem();
        System.out.println("");

        arvore.remover(24,"24");
        
        arvore.ordem();
    }
}
