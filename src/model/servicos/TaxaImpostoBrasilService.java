
package model.servicos;

public class TaxaImpostoBrasilService {
    
    public double calcularTaxa(double quantia){
        if (quantia <= 100){
            return quantia * 0.2;
        } else {
            return quantia * 0.15;
        }
    }
}
