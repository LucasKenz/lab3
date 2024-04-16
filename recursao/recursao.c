#include <stdio.h>
#include <limits.h>

float fatorial (int n){
    float f=1; // embaixo começa em 2 por para n <= 1 o fatorial será o próprio 1
    for (int i = 2; i <= n; i++){
        f = f* i;
    }
    return f;
}

int fat_rec (int n){
    
    // começar pelo critério de parada
    if (n<=1) return 1;
    return n * fat_rec(n-1);
}

int fibonacci (int n){
    
    // para n <= 1, retorna 1
    // para fib(n-1) + fib(n-2), para n > 1    
}


// função principal / main
int main (){
    // printf("inteiro máximo: %d\n", INT_MAX); // se enxergarmos letras EM caixa alto  SABEMOS QUE SÃO CONSTANTES E NÃO SERÃO MEXIDOS
    // for (int i = 0; i < 15; i++){
    //     printf("fatorial de %d = %.0f\n", i, fatorial(i)); // .0f é nenhuma casa decimal depois da virgulas de um float nesse caso.
    // }   
    
    for (int i=0; i<13; i++){
        printf("fatorial de %d = %d\n", i, fat_rec(i));
    }
    return 0;
}