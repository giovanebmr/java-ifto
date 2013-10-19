package Paulo;

public class CriandoWhileeVetorMatriz{
	public static void main (String args[]) {
		int[][] vetorInteiros = new int[100][50];
		int numero = 0;
                for(int i = 0; i<100; i++){
                    for(int j=0; j<50; j++){
                    vetorInteiros[i][j]=numero;
                    }
                }
	}
}

