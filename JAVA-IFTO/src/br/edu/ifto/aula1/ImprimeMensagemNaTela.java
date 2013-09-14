/*
 * A classe System da API JAVA possui um obeto chamado "out" 
 * Essse objeto é uma instância da classe PrintStream
 * "out" também é um objeto estatico, por isso não precisamos instanciar a clase System para que os métodos disponíveis
 * em "out" sejam utilizados, bastando somente acessar o método println() para que possamos imprimir um caracter qualquer na saida padrão do sistema,
 * que no nosso exemplo, foi a terminal de comandos do linux.
 */
package br.edu.ifto.aula1;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
public class ImprimeMensagemNaTela {
    
    public static void main(String args []){
        
        System.out.println("Teste");
        
        
    }
    
}
