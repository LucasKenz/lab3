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
            return buscaRec(atual.getDireita(), x); // nesse caso a busca vai para a esquerda em busca do x
        }
        return false; // não achamos
    }

    public int proximo (int x){
        if (estaVazia()) return -1; // por convensão de projeto o retorno vai ser -1, pois tenho certeza que -1 não estará na arvore
        ArrayList<Integer> lista = new ArrayList<>(); // array list é um vetor muito melhor
        lineariza (lista, raiz); // tornando a árvore em linha, será um cursão, com a lista a partir da raiz
        System.out.println(lista); // nunca devemos colcoar um print em um método / estrutura de dados
        int posicao = lista.indexOf(x);
        if (posicao != -1 && posicao != lista.size()-1){ // temos que checar se o elemento existe, que no caso se não existir é -1, e se não estamos na ultima posição, como? usando size que ja esta pronto no java doc

            return lista.get(posicao +1);
        }
        return -1;

        // ou com ternário

        // return posicao != -1 && posicao != lista.size()-1 ?  lista.get(posicao +1) : -1;

        // ou

        // return posicao == -1 || posicao == lista.size() -1 ? -1 : lista.get(posicao+1);
    }

    void lineariza (ArrayList<Integer> lista, No atual){ // temos que especificar que nossa lista é um array list de lista
        if (atual != null) {
            // pergunta de segurança para saber que estamos num lugar seguro
            lineariza(lista, atual.getEsquerda()); // chamamos o alinhar para a esquerda de baixo pra cima, recursivamente
            lista.add(atual.getInfo()); // dessa maneira pegamos a raiz, que sempre será um nó não fixo, pega o mais a esquerda, volta pega o de cima, e vai para a direita de uma subárvore

            lineariza(lista, atual.getDireita()); // depois de ir tudo para a direita, pega o mais a esquerda e subir, pegamos o mais a direita da subarvor mais a esquerda

            
        }

    }

    public boolean remove(int x){
        // tem vários problemas e exceçoes que precisam ser tratadas
        if ( estaVazia()) return false;
        return removeRec(x, raiz, null, false); // usar o remove recursivo apartir da raiz (posição atual), do topo, desce e sobe
        // null é usado para falar que o pai da raiz é null

    }

    boolean removeRec (int x, No atual, No pai, boolean eFilhoEsquerdo){ // para a remoção precisamos saber qual o atual e o pai dele que vai apontar para um novo, o x é removido, x numa posição atual e pai qualquer
        if (atual != null){
            if (x == atual.getInfo()){
                if (atual.getEsquerda() == null && atual.getDireita() == null ){ // é folha, sem filhos
                    if (atual == raiz){ // refatoração para caso tiver dois filhos 
                        raiz = null;
                    }
                    else if (eFilhoEsquerdo){
                        pai.setEsquerda(null);
                    }
                    else {
                        pai.setDireita(null);
                    }
                }
                else if (atual.getEsquerda() == null){ // só tem o filho direito
                    if (atual == raiz){ // refatoração para caso de ter os dois filhos
                        raiz = atual.getDireita();
                    }
                    else if (eFilhoEsquerdo){ // ta chegando esquerdo
                        
                        pai.setEsquerda(atual.getDireita()); 
                    }
                    else { // ta chegando pela direita
                        pai.setDireita(atual.getDireita()); 
                    }
                    
                }
                else if (atual.getDireita() == null){ // so tem o filho esquerdo
                    if (atual == raiz){
                        raiz = atual.getEsquerda();
                    }
                    else if (eFilhoEsquerdo){
                        pai.setEsquerda(atual.getEsquerda()); // é como se fizesse um pulo, seta a esquerda do pai para a esquerda do atual
                    }
                    else{
                        pai.setDireita(atual.getEsquerda());
                    }
                }
                else{ // tem os dois filhos
                    // a subarvore da direita é adotada pelo nó pai
                    if (atual == raiz){ // refatoração por causa da dois filhos
                        raiz = atual.getDireita();
                        }
                    else if(eFilhoEsquerdo){
                        pai.setEsquerda(atual.getDireita());
                    }
                    else {
                        pai.setDireita(atual.getDireita());
                    }
                    // a subarovore da esquerda é adotada pelo sucessor
                    // sucessor é o menor entre os maiores que o atual
                    No sucessor = atual.getDireita(); // existe pois tenho dois filhos, se chegou nesse if eu sei que tenho dois filhos
                    while (sucessor.getEsquerda() != null){
                        sucessor = sucessor.getEsquerda();
                        // qualquer mudança deve ser feita 3 vezes, uma vez para cada possibilidade
                    }
                    sucessor.setEsquerda(atual.getEsquerda());
                    // funcionará com o método de la for
                        // adicionamos um sucessor, o pai de todos sempre vai adotar os ramos da direita
                        // o sucessor sempre vai adotar as suv arvores da esquerda
                            // o sucessor sempre será o menor entre os maiores, um passo para a direita e tudo para a esquerda
                }
                //remoção independente do caso tenmos que devolver sucesso
                return true;
            }
            else if (x < atual.getInfo()){
                return removeRec(x, atual.getEsquerda(), atual, true); // return resultado da BSUCA da esquerda
                // perceba a diferença de legibilidade do de baixo para esse

                // atualizo e passo direto as variáveis 
            }
            else{
                eFilhoEsquerdo = false;
                pai = atual; // o pai sempre será o atual
                return removeRec(x, atual.getDireita(), pai, eFilhoEsquerdo); // return resultado da BSUCA da direita
                // atualizo as variáveis e depois passo
            }

        }
        return false;

    }
}



