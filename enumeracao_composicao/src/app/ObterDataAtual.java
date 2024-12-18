package app;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObterDataAtual {
    public static void main(String[] args) {
        // Obtém a data e hora atuais
        Date dataAtual = new Date();

        // Cria um formatador para o formato desejado
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Formata a data e imprime o resultado
        String dataFormatada = formatador.format(dataAtual);
        System.out.println("Data formatada: " + dataFormatada);
        System.out.println("Data original: " + dataAtual);
    }
}
