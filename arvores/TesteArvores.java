import java.util.Random;

public class TesteArvores {
    public static void main (String[] args){
        Arvore abb = new Arvore();
        Random r = new Random();
        int total = r.nextInt(10) + 5; // passo 200 garantindo pelo menos 50, se não pode ter 0 nos
        System.out.println("total: " + total);
        for (int i=1; i<=total; i++){
            int n = r.nextInt(total) + 1;
            System.out.print(n + " ");
            abb.insere(n);
        }
        System.out.println("\na arvore:\n" + abb.toStringEmOrdem());
        System.out.println("numero de nos: " + abb.numeroNos()); // faço a chamada do método public
        // a navegação ocorre na ordem: vai tudo a direita de, acha null, volta para cima, com a soma de nós (1), soma a raiz, vai para a direita da subarvore e sobe com o valor de nos
        System.out.println("altura da arvore: " + abb.altura());
        System.out.println("numero de folhas: " + abb.numeroFolhas());
        int x = r.nextInt(total) + 1;
        if (abb.busca(x)){
            System.out.println(x + " foi encontrado na árvore");

        }
        else {
            System.out.println(x + " não foi encontrado");
        }

        int p = abb.proximo(x);
        if (p == -1){
            System.out.println(" ou a arvore esta vazia, ou o elemento não existe ou é o ultimo da lista");
        }
        else {
            System.out.println("o proximo e: " + p);
        }
    }
}
