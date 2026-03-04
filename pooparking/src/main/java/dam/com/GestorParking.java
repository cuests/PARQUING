package dam.com;

import java.time.LocalDateTime;
import java.util.ArrayList;

import dam.com.Places.PlacaAparcament;
import dam.com.Tickets.Tiquet;
import dam.com.vehicles.Vehicles;

public class GestorParking {

    private ArrayList<PlacaAparcament> places;
    private ArrayList<Tiquet> tiquets = new ArrayList<>();

    public static final double PREU_MINUT = 2.0;

    public GestorParking(ArrayList<PlacaAparcament> places) {
        this.places = places;
    }

    public GestorParking() {
        this.places = new ArrayList<>();
    }

    public void afegirPlaça(PlacaAparcament plaça) {
        this.places.add(plaça);
    }

    public void mostrarEstat() {
        for (PlacaAparcament p : places) {
            System.out.println(p);
        }
    }

    public Tiquet aparcarVehicle(Vehicles vehicle) {
        for (PlacaAparcament plaça : places) {
            try {
                plaça.aparcarVehicle(vehicle);
                Tiquet t = new Tiquet(vehicle, plaça);
                tiquets.add(t);
                return t;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("No s'ha pogut aparcar el vehicle");
        return null;
    }

    public double desaparcar(Tiquet tiquet) {
        if (!tiquets.remove(tiquet)) {
            throw new IllegalArgumentException("Tiquet no trobat");
        }
        tiquet.getPlaça().desaparcar();
        tiquet.setHoraSortida(LocalDateTime.now().plusMinutes(15));

        double preu = tiquet.minuts() * PREU_MINUT;
        return preu;
    }

    public Tiquet getTiquet(int id) {
        for (Tiquet t : tiquets) {
            if (t.getNumero() == id) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GestorParking [places=" + places + ", tiquets=" + tiquets + "]";
    }
}
