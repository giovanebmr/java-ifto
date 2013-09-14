/*
 * Declarando variáveis (tipos primitívos)
 * Java é uma linguagem com tipificação forte, isso significa que para declarar uma variável o programador precisa especificar qual
 * é o tipo de dados que essa variável pode assumir:
 * Java possui:
 *          quatro tipo de dados inteiros:    int , short , long e byte  (para números inteiros)
 * dois tipos de dados em ponto flutuante:    float e double    (para números com precisão após a vírgula)
 *                                 o tipo:    char      ( para caracteres. Exemplo a letra 'r' )
 *                               e o tipo:    boolean   ( para valores lógicos booleanos: true ou false )
 */
package br.edu.ifto.aula1;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class DeclarandoVariaveis {

    public static void main(String args[]) {
        int numero = 10;

        int numero2 = 30;

        int soma = numero + numero2;
        
        System.out.println("Soma = " + soma);
    }
    
    
}
