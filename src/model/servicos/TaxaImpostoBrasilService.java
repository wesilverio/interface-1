
package model.servicos;

public class TaxaImpostoBrasilService implements TaxaService{

    @Override
    public double taxa(double quantia) {
        if (quantia <= 100){
            return quantia * 0.2;
        } else {
            return quantia * 0.15;
        }
    }
}
