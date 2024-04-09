public class ListaDupla {
    private NoDuplo primeiro;
    private NoDuplo ultimo;
    // construtor padrão que zera tudo, a lista nasce vazia
    // a lista é minha ou seja tudo é private, são apenas elementos de controle não para o usuário manipular

    //teste de lsita vazia
    // se esta vazia o primeiro é null e o ultimo é nulo
    public boolean estaVazia(){
        return primeiro == null; // não precisamos testar os dois apenas 1 situação é necessária
    }
    public void insereInicio(int i) {
        NoDuplo novo = new NoDuplo(i); // essa é a caixa com no meio a info sendo i, chega um elemento põe na caixa
        if (estaVazia()){
            ultimo = novo;

        }
        else {
            novo.setProximo(primeiro);
            primeiro.setAnterior(novo);
            
        }
        primeiro = novo;
    }
    public void InsereFim (int i){
        NoDuplo novo = new NoDuplo(i);
        if (estaVazia()){
            ultimo = novo;
            primeiro = novo;
        }
        else{
            novo.setAnterior(ultimo);
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    public int removeInicio(){
        // não faz o código
       int aux = primeiro.getInfo();
       primeiro = primeiro.getProximo(); // aqui pode ser que ela tenha ficado vazia
       if (estaVazia()){
            ultimo = null;
       }
       else{
            primeiro.setAnterior(null);
       }
       return aux;
    }
    public int removeFim(){
        int aux = ultimo.getInfo();
        ultimo = ultimo.getAnterior();
        if (ultimo == null){
           primeiro = null;
        }
        else{
            ultimo.setProximo(null);
        }
        return aux;
    }

    public NoDuplo adicionaPos(int e, int pos){
        NoDuplo novo = new NoDuplo(e);
        cont = 1;
        NoDuplo aux = primeiro;
        while ( aux != null && cont != pos){
            aux = aux.getProximo();
            cont ++;
        }
        novo.setProximo(aux);
        novo.setAnterior(aux.getAnterior());
        novo.getProximo().setAnterior(novo);
        novo.getAnterior().setProximo(novo);
    }

    public void removePos(int pos){
        NoDuplo aux = primeiro;
        cont = 1;
        while (aux != null && cont != pos){
            aux = aux.getProximo();
            cont ++;
        }
        aux.getAnterior().setProximo(aux.getProximo());
        aux.getProximo().setAnterior(aux.getAnterior());
    }

    public boolean removePrimeiraOcorrencia (int x){
        if (estaVazia()) return false;
        if (primeiro.getInfo() == x){
            primeiro = primeiro.getProximo();
            if (primeiro == null){
                ultimo = null;
            }
            return true;
        }
        NoDuplo atual = primeiro.getProximo();
        boolean achou = false;
        while (atual != null && !achou){
            if (atual.getInfo() == x) achou = true;
            else atual = atual.getProximo();
        }
        if (!achou) return false;
        if (atual == ultimo){
            ultimo = ultimo.getAnterior();
            ultimo.setProximo(null);
        }
        else{
            atual.getAnterior().setProximo(atual.getProximo());
            atual.getProximo().setAnterior(atual.getAnterior());
        }
        return true;
    } 
    
}
