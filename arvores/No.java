public class No {
    private int info;
    private No esquerda;
    private No direita;
    private int quantidade;

    // 2 ponteiros

    public No (int info){
        this.info = info;
        this.quantidade = 1;
    }
    public int getInfo() {
        return info;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public No getEsquerda() {
        return esquerda;
    }
    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
    public No getDireita() {
        return direita;
    }
    public void setDireita(No direita) {
        this.direita = direita;
    }
    public void incrementaQuantidade(){
        quantidade ++;
    }
    public void decrementaQuantidade(){
        quantidade --;
    }
    @Override
    public String toString() {
        return " [info=" + info + ", quantidade=" + quantidade + "]";
    }
   
}