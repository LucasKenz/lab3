public class Pilha {
    private No topo;
    public boolean estaVazia() {
        return topo==null;
    }

    public void push (int i) {
        No novo = new No(i);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
    }

    public int pop () {
        int aux = topo.getInfo();
        topo = topo.getProximo();
        return aux;
    }
   
    public int size(){
        // if (estaVazia()) return 0; // não precisa a verificação já esta no while
        No novo = topo;
        int cont = 0;
        while (novo != null){
            novo = novo.getProximo();
            cont ++;
        }
        return cont;
    }

    //consultar topo
    public int consultaTopo (){
        if (estaVazia()) return 0;
        int novo = topo.getInfo();
        return novo;
    }

    @Override 
    public String toString() {
        String s = "pilha: ";
        if (estaVazia()) 
            s += "vazia";
        else {
            No temp = topo;
            while (temp != null) {
                s += temp + "\n";
                temp = temp.getProximo();
            }
            s += "\\\\";
        }
        return s + "\n";
    }

    // implementar 
        // 1. tamanho
        // 2. consulta topo
        // e criar um teste pilha
}