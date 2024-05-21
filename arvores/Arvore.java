import java.util.ArrayList;

public class Arvore {
    private No raiz; // ponteiro
    // teste para se a riaz está vazia, é null

    public boolean estaVazia(){
        return raiz == null;
    }
    public void insere (int i){
        No novo = new No(i); // levo um inteiro de referência
        if (estaVazia()) { // verifica se o lugar está vazio
            raiz = novo;
        }
        else {
            insereRec (novo, raiz); // ve onde tenho que colocar o cara se não estiver vazia
        }
    }

    void insereRec (No novo, No atual){
        if (novo.getInfo() <= atual.getInfo()) { // ir para esquerda
            // verificar se a esquerda está liberada / vazia
            if (atual.getEsquerda() == null){
                atual.setEsquerda(novo);
            }
            else{
                insereRec(novo, atual.getEsquerda());
            }
        }
        else { // ir para direita
            if (atual.getDireita() == null){
                atual.setDireita(novo);
            }
            else{
                insereRec(novo, atual.getDireita());
            }
        }
    }
    public String toStringEmOrdem (){
        if (estaVazia()) return "arvore vazia";
        return toStringEmOrdemRec(raiz); // retornar o tostring recursivo apartir da raiz
    }
    String toStringEmOrdemRec (No atual){
        if (atual == null) return "";
        return toStringEmOrdemRec(atual.getEsquerda()) // pega tudo a esquerda da raiz
            + atual.getInfo() + " " // retorna o escolhido primeiro
            + toStringEmOrdemRec(atual.getDireita()); // pega a direita da raiz
    }
    public int numeroNos (){
        if (estaVazia()) return 0;
        return numeroNosRec(raiz); // ponto de partida é a raiz
    }
    // construindo a recursão, é int pois é de interesse da própria classe
    int numeroNosRec(No atual){ // de onde eu estou
        if (atual==null) return 0; // se a referencia atual que eu acabei de passar for null retorna 0

        // se não pegar tudo a esquerda + raiz + tudo a direita

        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita()); // + 1 sozinho é por causa da raiz
    }   

    public int altura(){
        if (estaVazia()) return 0;
        return alturaRec(raiz);
    }
    int alturaRec(No atual){
        // se eu usar essa função sei que ele não é nulo, começo pelos filhos dele
        if (atual.getEsquerda() == null && atual.getDireita() == null) return 0; // querdizer uma subarvore sem filhos
        // situações: pode ter falhado 1, outro, ou os dois
        int alturaEsquerda = 0;
        if (atual.getEsquerda() != null){
            alturaEsquerda = alturaRec(atual.getEsquerda()); // temos a altura através da recursão pegando todo o lado esquerdo
        }
        int alturaDreita = atual.getDireita() != null ? alturaRec(atual.getDireita()) : 0; // com ternário fica assim
        // se lê assim: minha altura Direita = pergunta: minha atual direita é diferente de nulo? se sim pegamos toda a direita, se não é 0

        //agora vamos comparar as alturas para ver quem é maior e soamr 1
        return alturaEsquerda > alturaDreita ? alturaEsquerda + 1 : alturaDreita + 1;
        // o return é baseado na pergunta: minha altura da esquerda é maior que o da direita? se sim devolve a altura da esquerda +1 se não a direita + 1.

    }

    public int numeroFolhas(){
        if (estaVazia()) return 0;
        return numeroFolhasRec(raiz);
    }

    // int numeroFolhasRec(No atual){
    //     if (atual.getDireita() == null && atual.getEsquerda() == null)
    //         return 1;
    //     int folhasDireita=0, folhasEsquerda=0;
    //     if (atual.getDireita() != null){
    //         folhasDireita = numeroFolhasRec(atual.getDireita()); // chamar recrsivamente para a direita 
    //     }
    //     if (atual.getEsquerda() != null){
    //         folhasEsquerda = numeroFolhasRec(atual.getEsquerda());
    //     }
    //     return folhasDireita + folhasEsquerda;
    // }

    int numeroFolhasRec(No atual){
        if (atual != null){
            if (atual.getDireita() == null && atual.getEsquerda() == null)
                return 1;
            return numeroFolhasRec(atual.getDireita()) + numeroFolhasRec(atual.getEsquerda()); 
        }
        return 0;
    }

    public boolean busca (int x){
        if (estaVazia()) return false;
        return buscaRec(raiz, x); // apartir da raiz busca o elemento x
    }
    boolean buscaRec (No atual, int x) {
        if (atual != null) {
            if (x == atual.getInfo()) return true; // nesse caso já encontramos o nó que queremos
            if (x < atual.getInfo()){
                return buscaRec (atual.getEsquerda(), x);
            }
            return buscaRec(atual.getEsquerda(), x); // nesse caso a busca vai para a esquerda em busca do x
        }
        return false; // não achamos
    }

    public int proximo (int x){
        if (estaVazia()) return -1; // por convensão de projeto o retorno vai ser -1, pois tenho certeza que -1 não estará na arvore
        ArrayList<Integer> lista = new ArrayList<>();
    }
}



