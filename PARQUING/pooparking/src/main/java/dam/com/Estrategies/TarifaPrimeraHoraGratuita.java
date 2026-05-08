package dam.com.Estrategies;

import dam.com.Tickets.Tiquet;

public class TarifaPrimeraHoraGratuita implements EstrategiaPagament {

    private static final double PREU_PER_MINUT = 2.0;
    private static final long MINUTS_GRATUÏTS = 60;

    @Override
    public double calcularPreu(Tiquet ticket) {
        long minuts = ticket.minuts();
        if (minuts <= MINUTS_GRATUÏTS) {
            return 0.0;
        }
        return (minuts - MINUTS_GRATUÏTS) * PREU_PER_MINUT;
    }
}
