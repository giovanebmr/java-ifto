/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Tayla;

/**
 *
 * @author aluno
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class calculadora_com_controle_entrada {

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
