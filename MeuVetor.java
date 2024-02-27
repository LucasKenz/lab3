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

    public boolean adiciona (int e){

        // if (estaCheio()){
        //     return false;
        // }
        ultimaPos++;

        v[ultimaPos] = e;
        return true; 
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
        // quero olhar dentro do vetor, não usaremos um comando para exibir o vetor
        // por que? MVC, modelo, visão, controle
            // modelo pra exibir, visão para mandar para o BD por exemplo, e o controle que controla para onde vai
            // essa classe é de vetor, não temos nenhum print aqui
        // i < v.length é ruim, pois apenas estamos jogando todo o vetor, queremos que não mostre quando está vazio ou que mostre se há algum vetor
        //mudamos para i<ultimaPos
        // minha ultimaPos é -1, mas 0 < -1? não, logo não mostrará nada
        // quando o marcador de ultimaPos é -1, indica que o vetor está vazio
        // criaremos um teste para ver se está vazio, ou seja se a ultimaPos == -1; -1 indica que está vazio, porque definimos essa convenção
    }

}
