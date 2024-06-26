public class Arvore {
    private No raiz; // ponteiro
    // teste para se a riaz está vazia, é null

    public boolean estaVazia(){
        return raiz == null;
    }
    
    // fazer a lógica da inserção
    // se estiver vazia preciso inserir, a raiz aponta para o novo

    // toda vez o novo representa um nó novo na arvore
    // e sempre vou andar com o atual, meu ATUAL QUE ANDA, cada nível da recursão tem seu próprio atual
        // para cada andada do atual, atual muda, e vai sempre para a direita ou para a esquerda

    public void insere(int i){
        if (estaVazia()){
            raiz = new No(i);
        }
        else {
            insereRec (i, raiz);
        }
    }

    void insereRec (int i, No atual){
        if (i  == atual.getInfo()){ // se o i for igual ao atual em que estou, soma a quantidade em 1
            atual.incrementaQuantidade();
        }
        else if (i < atual.getInfo()){ // se não for igual
            if (atual.getEsquerda() == null) {  // faço isso
                atual.setEsquerda(new No(i));
            }
            else{
                insereRec(i, atual.getEsquerda());  // se não, faço essa busca
            }
        } // se não for igual ou menor então faço o que está abaixo
        else {
            if (atual.getDireita() == null){ // checa se a direita está disponível e coloca la
                atual.setDireita(new No(i));
            }
            else {
                insereRec(i, atual.getDireita()); // se não faz a procura por um lugar para inserir, faz a busca
            }

        }
    }   

    public String ToStringEmOrdem(){
        if (estaVazia()) return "arvore vazia"; // usamos o toString para aproveitar e ver a forma de percorrer toda a arvore
        return ToStringEmOrdemRec(raiz); // usamos a recursão ao chamar a função nela mesma, para dar o ponto de partida é a raiz da arvore
    }

    String ToStringEmOrdemRec(No atual){
        if (atual == null) return ""; // não concatenamos um null a arvore
        String s = "";

        s += ToStringEmOrdemRec(atual.getEsquerda()); // pega tudo a esquerda
        
        
        for (int i=1; i<=atual.getQuantidade(); i++){
            s+= atual.getInfo() + " ";
        } //pegamos a quantidade

        s += ToStringEmOrdemRec(atual.getDireita()); // pega tudo a direita

        return s;
         // pega toda a esquerda e deis toda a direita
        //vai ser toda vez quase sempre assim
    }
    
    public int numeroNos(){
        if (estaVazia()) return 0;
        return numeroNosRec(raiz);
    }

    int numeroNosRec (No atual){
        if (atual==null) return 0;
        return numeroNosRec(atual.getEsquerda()) + 1 + numeroNosRec(atual.getDireita());
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

}



