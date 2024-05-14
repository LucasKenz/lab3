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
        if (atual == null) return " string vazia. ";
        return toStringEmOrdemRec(atual.getEsquerda()) // pega tudo a esquerda da raiz
            + atual.getInfo() + " " // retorna o escolhido primeiro
            + toStringEmOrdemRec(atual.getDireita()); // pega a direita da raiz
        
        
    }
}



