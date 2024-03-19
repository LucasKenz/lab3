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
            while(temp.getProximo() != null){
                temp = temp.getProximo(); // aqui vemos a representação de pegar um valor até o proximo ser diferente de null
                // enquanto isso temp assumirá o tamanho desse próximo
            }
            temp.setProximo(novo);
            // o problema é que quanto maior a lista mais demorado é para achar um pecinha
        }
    }

    public int removeInicio(){
        // guardar elemento da primeira posição
        int aux = primeiro.getInfo();
        primeiro = primeiro.getProximo();
        // so depois devolverá aquela informação
        return aux;
    }
    // ex1: feito
    public int removeFim(){
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
