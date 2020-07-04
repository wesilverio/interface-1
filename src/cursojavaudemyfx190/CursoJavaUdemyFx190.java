
package cursojavaudemyfx190;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entidades.AluguelVeiculo;
import model.entidades.Veiculo;
import model.servicos.AluguelService;
import model.servicos.TaxaImpostoBrasilService;

public class CursoJavaUdemyFx190 {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        
        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do Carro: ");
        String modeloCarro = sc.nextLine();
        System.out.print("Saída (dd/MM/yyyy HH:ss): ");
        Date inicio = sdf.parse(sc.nextLine());
        System.out.print("Retorno (dd/MM/yyyy HH:ss): ");
        Date retorno = sdf.parse(sc.nextLine());
        
        AluguelVeiculo av = new AluguelVeiculo(inicio, retorno, new Veiculo(modeloCarro));
        
        System.out.print("Digite o preço por hora: ");
        double precoHora = sc.nextDouble();
        System.out.print("Digite o preço por dia: ");
        double precoDia = sc.nextDouble();
        
        AluguelService aluguelService = new AluguelService(precoHora, precoDia, new TaxaImpostoBrasilService());
        
        aluguelService.processarNotaDePagamento(av);
        
        System.out.println("ALUGUEL");
        System.out.println("Pagamento básico: " + String.format("%.2f", av.getFatura().getPagamentoBasico()));
        System.out.println("Taxa: " + String.format("%.2f", av.getFatura().getTaxa()));
        System.out.println("Pagamento Total: " + String.format("%.2f", av.getFatura().getPagamentoTotal()));
        
        sc.close();
    }
    
}
