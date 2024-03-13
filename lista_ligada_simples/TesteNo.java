public class TesteNo {
    public static void main(String[] args) {
        No no1 = new No(10);
        No no2 = new No(20);
        System.out.println("no1: " + no1);
        System.out.println("no2: " + no2);// + no1 é para invocar o toString dele

        no1.setProximo(no2); //ao passar o no2 de referencia tem no1 -> [10][-> aponta para no2, para o 20]
        System.out.println("e agora? " + no1.getProximo());// veja que vou na caixa e pego o valor de n1, proximo, [][] a segunda caixa

        no2.setProximo(no2); // quando setamos para no2, vai apontar para ela mesma, no [20][prox -> aponta para ela mesma = 20]
        System.out.println("e agora???? " + no2.getProximo());
        // se entendermos as linhas 8, 9, 11, 12 é a pura lista **

    }
    
}
