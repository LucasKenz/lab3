public class Fila <E> { // agora nossa fila é genérica
    private No<E> primeiro; // ninguém tem acesso aos elementos da fila, somente a fila
    private No<E> ultimo;

    public boolean estaVazia(){
        return primeiro == null; // se o primeiro for nulo, tudo bem
    }

    public void enfileira (E i) {
        No<E> novo = new No<>(i);
        if (estaVazia()) {
            primeiro = novo;
        }
        else {
            ultimo.setProximo(novo);
        }
        ultimo = novo;
    }
    // enfileira tem cenários, quais?
    // 1. Fila vazia, quer dizer primeiro e ultimo apontam para nulo
        // com inserção de fim, o ultimo sempre será o novo, ai tenho que refazer a ligação do anterior com o novo e o ultimo apontar para o novo
        // se for de inicio o primeiro sempre será o novo
    // 2. Fila com 1 ou mais elementos

    // desinfileira
    // sempre sai o primeiro
    // o primeiro aponta para o proximo ao primeiro, devolvemos o primeiro e o primeiro aponta para o próximo
    public E desinfileira (){
        if (estaVazia()) {
            return null;
        }
        E temp = primeiro.getInfo(); // meu temp agora é do tipo E e devemos arrumar o que faz return, num E e não mais num int
        primeiro = primeiro.getProximo();
        //verificar se a fila não esvaziou, pois ai temos que reajustar o ultimo
        if (primeiro == null) {
            ultimo = null;
            
        }
        return temp;
    }

    @Override
    public String toString() {
        if(estaVazia()) {
            return "Fila vazia";
        }
        // se não percorrer a fila e mostrar, como nossa fila agora é de carros, temos que ir do primeiro ao penuultimo mostrando carro-a-carro, com excessão do ultimo
        String s = "";
        No<E> aux = primeiro;
        while (aux != ultimo) {
            s = s + aux + " - ";
            aux = aux.getProximo();
        }
        // quando sai do laço sei que ele é o ultimo
        s += aux;
        return s;
    }
}

// opção de implementação no mesmo arquivo
class No<E> { // <E> em java quer dizer qualquer

    // private int info;
    // private No proximo;

    private E info;
    private No<E> proximo;
    
    public No (E info) {
        setInfo(info);
        proximo = null; //por clareza
    }
    public E getInfo() { // temos que mudar o retorno de int para E
        return info;
    }
    public No<E> getProximo() {
        return proximo;
    }
    public void setInfo(E info) { // temos que trocar o parametro, não recebe mais um int recebe um elemento da classe E
        this.info = info;
    }
    public void setProximo (No<E> proximo) {
        this.proximo = proximo;
    }
    @Override
    public String toString() {
        return info + "";
    }
}

// um arquvio pode ter tantas classes quanto eu quiser, porém somente 1 pública