public class NoDuplo {
    private int info;
    private NoDuplo anterior;
    private NoDuplo proximo;
    public NoDuplo ( int info){
        setInfo(info);
        setProximo(null);
        setAnterior(null);  
    }
    public int getInfo(){
        return info;
    }
    public NoDuplo getAnterior(){
        return anterior;
    }
    public NoDuplo getProximo(){
        return proximo;
    }
    public void setInfo(int info){
        this.info = info; // o atributo info recebe (=) o parametro info
    }
    public void setAnterior(NoDuplo anterior){
        this.anterior = anterior; // o atributo anterior recebe o parametro anterior
    }   
    public void setProximo(NoDuplo proximo){
        this.proximo = proximo; // o atributo proximo recebe o parametro proximo
    }     
    @Override
    public String toString(){
        return "|" + info + "|";
    }
}
