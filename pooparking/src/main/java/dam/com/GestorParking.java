package dam.com;
import java.util.ArrayList;

import dam.com.vehicles.Vehicles;
public class GestorParking {
    
    private ArrayList<PlacaAparcament> places;

    public GestorParking (ArrayList <PlacaAparcament>places){
        this.places = places;
    }

    public GestorParking () {
        this.places = new ArrayList<>();
    }

    public void afegirPlaça (PlacaAparcament plaça){
        this.places.add(plaça);
    }

    public void MostrarEstat(){
        for (PlacaAparcament p : places){
            System.out.println(p);
        }
    }

    public boolean aparcarVehicle (Vehicles vehicle) {
        for (PlacaAparcament plaça : places){
            try {
                plaça.aparcarVehicle(vehicle);
                return true;
            } catch (Exception e) {
                e.printStackTrace();        
            }

        }

        return false;
    }
}
