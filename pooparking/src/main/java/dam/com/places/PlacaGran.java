package dam.com.places;

import dam.com.PlacaAparcament;
import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

public class PlacaGran extends PlacaAparcament {

    protected MidaVehicle MidaMaxima;

    public PlacaGran(int numeroPlaca, Coordenada[] coordenades) {

        setNumeroPlaca(numeroPlaca);
        setUbicacio(coordenades);
        this.MidaMaxima = MidaVehicle.GRAN;
        this.estatDisponibilitat = true;

    }
    @Override
    public boolean compatible (Vehicles vehicle){
        return true;
}

}
