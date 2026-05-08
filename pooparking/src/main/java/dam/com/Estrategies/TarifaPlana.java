package dam.com.Estrategies;

import dam.com.Tickets.Tiquet;

public class TarifaPlana implements EstrategiaPagament {

    private static final double PREU_FIX = 5.0;

    @Override
    public double calcularPreu(Tiquet ticket) {
        return PREU_FIX;
    }
}
