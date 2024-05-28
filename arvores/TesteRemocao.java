public class TesteRemocao{
    public static void main(String [] args){
        Arvore abb = new Arvore();
        abb.insere(40);
        abb.insere(20);
        abb.insere(60);
        abb.insere(10);
        abb.insere(30);
        abb.insere(5);
        abb.insere(15);
        abb.insere(25);
        abb.insere(35);
        abb.insere(50);
        abb.insere(70);
        abb.insere(45);
        abb.insere(55);
        abb.insere(65);
        abb.insere(64);
        abb.insere(63);
        abb.insere(75);
        abb.insere(72); // tenho certeza que é folha pois foi o ultimo a ser inserido
        System.out.println(abb.toStringEmOrdem());
        if (abb.remove(35)){ // é folha
            System.out.println("35 removido com sucesso");
        }
        else{
            System.out.println("35 não encontrado");
        }
        System.out.println(abb.toStringEmOrdem());
        if (abb.remove(65)){ // tem u mfilho so
            System.out.println("65 removido com sucesso");
        }
        else{
            System.out.println("65 não encontrado");
        }
        System.out.println(abb.toStringEmOrdem());
        if (abb.remove(95)){ // não existe
            System.out.println("95 removido com sucesso");
        }
        else{
            System.out.println("95 não encontrado");
        }
        System.out.println(abb.toStringEmOrdem());
        if (abb.remove(60)){ // não existe
            System.out.println("60 removido com sucesso");
        }
        else{
            System.out.println("60 não encontrado");
        }
        System.out.println(abb.toStringEmOrdem());
        if (abb.remove(40)){ // não existe
            System.out.println("40 removido com sucesso");
        }
        else{
            System.out.println("40 não encontrado");
        }
        System.out.println(abb.toStringEmOrdem());
    }
}