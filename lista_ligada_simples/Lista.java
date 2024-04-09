public class Lista {
    private No primeiro;
    // nasce vazia e com construtor padrão que zera todos os atributos
    public boolean estaVazia(){
        // se o primeiro estiver nulo esta vazia se estiver com alguem não esta vazia
        return primeiro==null; // tem um if embutido, escondido
        
    } 
    //vamos usa ro principio do menor privilégio
    public No getProximo(){
        return primeiro;
    }
    public void setPrimeiro (No primeiro){
        this.primeiro = primeiro;
    }
    public void InsereInicio(int i){
        // int i para inserir o int na lista
        // vamos embrulhar e colocar na caixinha
        No novo = new No(i); // peguei o valor i que chegou e coloquei na caixinha
        if (!estaVazia()){
            // se a lista estiver vazia o que chegou vai ser o primeiro
            novo.setProximo(primeiro);;
        }
        primeiro = novo;
            // se não, for false, faz dar a mão para o antigo
            // temos um exemplo de composição de classes, pemite reutilização de código
            //tenho uma classe nó que sabe trabalhar seus atributos, posso deligar a classe nó para fazer o trabalho dela, ela é responsável por se manipular
          
            // lembrando que novo é um No(recebe i)
        
             // tiramos do if

    }
    public void insereFim (int i){
        No novo = new No(i);
        if (estaVazia()){
            // se ela estiver vazia quer dizer que o primeiro a ser inserido é o próximo, então o 1° recebe o No (novo)
            primeiro = novo;
            // e se não for o primeiro?
            // nomearemos um auxiliar para armazenar até chegar em um elemento cujo próximo é null

        }
        else {
            No temp = primeiro;
            while(temp.getProximo() != null){ // percorrendo até o último elemento
                temp = temp.getProximo(); // aqui vemos a representação de pegar um valor até o proximo ser diferente de null
                // enquanto isso temp assumirá o tamanho desse próximo
            }
            temp.setProximo(novo);
            // o problema é que quanto maior a lista mais demorado é para achar um pecinha
        }
    }

    // public void insereP (int i, int pos){
    //     No novo = new No(i);
    //     if (estaVazia()){
    //         primeiro = novo;
    //     }
    //     else if(pos == 1){
    //         novo.setProximo(primeiro)
    //         primeiro = novo;
    //     }
    //     else {
    //         No aux = primeiro;
    //         int cont = 1;
    //         while (aux.getProximo() != null || cont < pos -1){
    //             aux = aux.getProximo();
    //             cont ++;
    //         }
    //         novo.setProximo(aux.getProximo());
    //         aux.setProximo(novo);
    //     }
    // }

    public int removeInicio(){
        // guardar elemento da primeira posição
        int aux = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        // so depois devolverá aquela informação
        return aux;
    }
    // ex1: feito
    public int removeFim(){ // perceba que não podemos parar no último se quisermos remover o último temos que aprar no penultimo
        No ultimoNo = primeiro;
        No penultimoNo = ultimoNo;
        // verificar qual o último no e colocar no valor
        if (ultimoNo.getProximo() == null) {
            primeiro = null;
        }
        while(ultimoNo.getProximo() != null){
            penultimoNo = ultimoNo;
            ultimoNo = ultimoNo.getProximo(); // iteramos até chegar no ultimo
        } 
        penultimoNo.setProximo(null);
        return ultimoNo.getInfo();
    }

       // anotações da machion
    public int removeFim2() {
        int aux;
        if (primeiro.getProximo() == null){ // se o proximo do primeiro ( na caixa é o segundo quadrado) apontar para null então sabemos que so tem 1
            //se o proximo do primeiro for nulo então so tem 1
            aux = primeiro.getInfo();
            primeiro = null; //esvaziou a lista
        }
        else {
            No temp = primeiro;
            while(temp.getProximo().getProximo() != null){ // significa que agopra pega 2 na frente, o penultimo
                temp =  temp.getProximo();
            }
            aux = temp.getProximo().getInfo(); // estamos posicionados e pegamos a informação da caixinha
            temp.setProximo(null);
        }
        return aux;
    }
    
    public Retorno encontraMaior(){
        Retorno r = new Retorno(); // nesse caso a primeira coisa é instanciar um novo objeto do tipo de retorno que desejamos.
        // checar se a lista está vazia
        if(estaVazia()){
            return r;
        }
            // se não esrtiver temos que varrer tudo e achar o elemento la dentro
            // nesse ponto temos certeza que não esta vazia por que passou o teste acima
            // nomeamos o 1° no da lista como maior
        int maior = primeiro.getInfo();
        No aux = primeiro.getProximo(); // Nosso auxiliar pega o valor do proximo
        while( aux != null){
            if(aux.getInfo() > maior){
                maior = aux.getInfo();  // assim nós temos certeza que saimos com o maior
            }
            aux = aux.getProximo(); //caminha na lista
            // na lista temos o primeiro que aponta para o proximo
            // então para andar nos nomeamos um aux que aponta para o primeiro
            // nós fazemos então aux.getProximo() para parar de apontar para o primeiro e apontar para o segundo
                // nesse momento teremos opção de pegar a info ou ir para o próximo.
        }
        r.setAchou(true);
        r.setContador(maior);
        return r; // sempre tem para devolver o pacote que pegamos para usar
    }

    // public boolean removeMaior(){

    // }

    public boolean removePrimeraOcorrencia (int x){
        if (estaVazia()) return false;
        if (primeiro.getInfo() == x){
            primeiro = primeiro.getProximo();
            return true;
        }
        boolean achou = false;
        No anterior = primeiro;
        No atual = primeiro.getProximo();
        while (atual != null && !achou){
            if (atual.getInfo() == x){
                achou = true;
            }
            else {
                anterior = atual;
                atual = atual.getProximo();
            }
        }
        if (!achou) return false;
        anterior.setProximo(atual.getProximo());
        return true;
    }

    // insere em uma posição específica
    public void insereP (int e, int pos){
        No novo = new No(e);
        if (pos == 1){
            novo.setProximo(primeiro);
            primeiro = novo;
        }
        else {
            No aux = primeiro;
            int cont = 1;
            while (aux.getProximo() != null && cont < pos -1){
                aux = aux.getProximo();
                cont ++;
            }
            novo.setProximo(aux.getProximo());
            aux.setProximo(novo);
        }
    }

    @Override
    public String toString(){
        String s = "lista: ";
        if (estaVazia()){
            s += "vazia";
        }
        else{
            // se não estiver vazia vou nomear um ponteiro auxiliar para guardar o endereço do nó
            No temp = primeiro; // instanciamos um temp para receber o valor de primeiro
            while(temp != null){ //19_03 percorre a lista até o final da lista
                s += temp;
                temp = temp.getProximo(); // enquanto o temp for diferente de proximo.., vou buscando o conteúdo na forma de string por isso o toString() no Override que sobrecarga o estaVazio
            }
            s += " \\ "; //concatena a string com \\ isso exibe somente uma \, se quiser exibir duas teria que ser \\\\, a cada 2 imprime 1 \
        }
        return s + "\n"; // pula linha
    }
}
