public class MeuVetor {
    private int [] v;
    private int ultimaPos;
    public MeuVetor (int capacidade){
        v = new int[capacidade];
        ultimaPos = -1; 
    }

    //metedos de acesso
    public int getUltimaPos() {
        return ultimaPos;
    }

    public int[] getV(){
        return v;
    }

    public void setUltimaPos(int pos){
        if(pos >= 0 && pos < v.length){
            ultimaPos = pos;
        }
        else {
            ultimaPos = v.length-1; 
        }
    }

    public boolean estaCheio(){ 
       return ultimaPos == v.length -1;
    }

    public boolean estaVazio(){ 
        return ultimaPos == -1;
        // estar vazio quer dizer a ultima posição é -1
    }

    //redimensionar vetor não pertence a nínguem e so a classe, colocar private encapsular
    private void redimensiona(int novaCapacidade) {
        int[] temp = new int[novaCapacidade];
        //redimensionamos com o novacapacidade
            //perceba que a única coisa diferente entre os códigos de adiciona e remove é o tamanho
            // fazer a cópia
            for (int i = 0; i <=ultimaPos; i++){
                temp[i] = v[i];
            }
            v = temp;
    }
    
    public void adiciona (int e){
        if (estaCheio()) {
            redimensiona(v.length*2);
        }
        v[++ultimaPos] = e;
    }

    public int remove(){
        if (estaVazio()) return 0;
        int aux = v[ultimaPos--];
        if (v.length>=10 && ultimaPos <= v.length/4){
            redimensiona(v.length/2);
        } 
        return aux;
    }

    @Override
    public String toString(){
        String s = "";
        if (estaVazio()){
            s = s + "esta vezio";
        }
        else {
            for (int i=0; i<=ultimaPos; i++){
                s = s + v[i] + " ";
            }
        }
        return s + "\n";
    }

}
