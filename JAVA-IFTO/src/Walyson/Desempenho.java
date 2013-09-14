package Walyson;



public class Desempenho {

    double nota;
    String mensagem;

    public String getDesempenho(double nota) {

        if (nota > 0 && nota < 4) {
            mensagem = "Péssimo";
        }
        if (nota > 4 && nota < 6) {
            mensagem = "Ruim";
        }

        if (nota > 6 && nota < 8) {
            mensagem = "Bom";
        }

        if (nota > 8 && nota < 10) {
            mensagem = "Ótimo";
        }
        return mensagem;
    }
}
