package Paulo;

public class CriandoWhileeVetor{
	public static void main(String args[]) {
		int[] vetorInteiros;
            vetorInteiros = new int[10];
		int numero = 0;
		while(numero < 100) {
			vetorInteiros[numero] = numero;
			System.out.println("posição = "+ vetorInteiros[numero]);
			numero++;
		}
	}
}
