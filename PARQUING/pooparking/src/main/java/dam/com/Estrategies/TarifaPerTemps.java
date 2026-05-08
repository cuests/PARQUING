package dam.com.Estrategies;

import dam.com.Tickets.Tiquet;

public class TarifaPerTemps implements EstrategiaPagament {

    private static final double PREU_PER_MINUT = 2.0;

    @Override
    public double calcularPreu(Tiquet ticket) {
        long minuts = ticket.minuts();
        return minuts * PREU_PER_MINUT;
    }
}
