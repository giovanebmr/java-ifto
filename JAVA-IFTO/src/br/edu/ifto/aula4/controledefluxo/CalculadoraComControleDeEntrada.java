/*Calculadora com controle da entrada. Se o usuário digitar qualquer caractere que não seje um número válido
 * o método isNumero vai capturar a exceção (erro) que vai ocorrer no método parseInt() do objeto Integer
 * Se ocorrer realmente um erro de convesão de caracter para número, o método isNumero() retorna um valor false para o método main()
 * Se não ocorrer erro de conversão o método isNumero() retorna um valor true
 * -> true informa que o valor digitado é um número e que pode ser convertido em int
 * -> false informa que o valor digitado NÃO é um número e NÃO pode ser convertido em int
 * De qualquer maneira dentro do método isNumero() a variável linhaDigitada recebe o valor do buffer, pois será utilizada para 
 * fazer novamente um parse (conversão de String para inteiro)
 * Dentro do while há um símbolo de   !   (exclamação)  esse símbolo é usado para negar (inverter) um valor booleano
 * ou seja, se o método isNumero()  retornar false o símbolo ! nega o valor e false se torna true
 * se isNumero() retornar true o válor é negado e true se torna false
 * Ou seja, se o valor digitado pelo usuário não for um número, o método isNumero() retorna false, esse valor é negado e se torna true
 * e o while executa novamente o laço de repetição ate que o valor seje um número e a função isNumero() retorne true, sendo negado se torna false e 
 * o laço de repetição é encerrado
 * Dessa vez as váriáveis foram declaradas fora do método main(), que é um método estático (static), por isso elas foram declaradas também como static
 * para serem acessadas pelo método estático main() , sem necessidade de instanciar a classe principal.
 */
package br.edu.ifto.aula4.controledefluxo;

/**
 *
 * @author Giovane Bruno Monte Reis
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class CalculadoraComControleDeEntrada {

    private static final InputStreamReader reader = new InputStreamReader(System.in);
    private static BufferedReader buffer = new BufferedReader(reader);
    private static int x;
    private static int y;
    private static int soma;
    private static String linhaDigitada;

    public static void main(String args[]) throws IOException {

        System.out.println("Digite o primeiro número: ");

        //executa enquanto a entrada do usuário NÃO for um número 
        while (!isNumero(buffer.readLine())) {
            System.out.println("Digite o primeiro número: ");
        }

        x = Integer.parseInt(linhaDigitada);

        System.out.println("Digite o segundo número: ");

        //executa enquanto a entrada do usuário NÃO for um número
        while (!isNumero(buffer.readLine())) {
            System.out.println("Digite o segundo número: ");
        }

        y = Integer.parseInt(linhaDigitada);

        soma = x + y;

        System.out.println("A soma dos números é: " + soma);

    }

    private static boolean isNumero(String entrada) {
        linhaDigitada = entrada;
        try {
            int x = Integer.parseInt(entrada);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
