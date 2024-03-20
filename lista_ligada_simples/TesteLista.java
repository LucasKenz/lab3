public class TesteLista {
    public static void main(String[] args) {
        Lista lista = new Lista();


        System.out.println(lista);
        for (int i = 1; i<2; i++){
            lista.InsereInicio(i*10); //pega a lista insere no inicio com valores de 0-9
            System.out.println(lista);
        }
        for (int i = 1; i<6; i++){
            lista.insereFim(i*10+5);
            System.out.println(lista);
        }
        if(lista.estaVazia()){
            System.out.println("lista vazia, não há o que remover");
        }
        else{
            System.out.println(lista.removeFim2() + " saiu do fim");
            System.out.println(lista); // checa se a lista se manteve integra até o final
        }

    //divertimentos:
    // 1. implementar o removeFim para Lista
    // 2. implementar o removeFim para ListaCom Ultimo
    // 3. implementar um teste para ListaComUltimo
        // System.out.println(lista.removeFim());
        // System.out.println(lista);


    
    }
}
