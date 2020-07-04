
package model.servicos;

import model.entidades.AluguelVeiculo;
import model.entidades.Fatura;

public class AluguelService {
    private Double precoPorHora;
    private Double precoPorDia;
    
    private TaxaService taxaService;

    public AluguelService(Double precoPorHora, Double precoPorDia, TaxaService taxaService) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxaService = taxaService;
    }
    
    public void processarNotaDePagamento(AluguelVeiculo aluguelVeiculo){
        //armazenando a data em miliseconds
        long tempo1 = aluguelVeiculo.getDataInicial().getTime();
        long tempo2 = aluguelVeiculo.getDataFinal().getTime();
        
        //calculando a diferença miliseconds -> segundos -> minutos -> horas
        double horas = (double)(tempo2 - tempo1)/ 1000 /60 /60;
        
        double pagamentoBasico;
        if(horas <= 12.0){
            //usa função da classe Math para arredondar as horas
            pagamentoBasico = Math.ceil(horas) * precoPorHora;
        } else {
            pagamentoBasico = Math.ceil(horas /24) * precoPorDia;
        }
        
        double taxa = taxaService.taxa(pagamentoBasico);
        aluguelVeiculo.setFatura(new Fatura(pagamentoBasico, taxa));
    }
}
