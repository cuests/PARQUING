package dam.com.Places;

import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

public class PlacaGran extends PlacaAparcament {

    protected MidaVehicle MidaMaxima;
    @Override
    public boolean compatible (Vehicles vehicle){
        return true;
    }

    public PlacaGran(int numeroPlaca, Coordenada[] coordenades) {
        super(numeroPlaca, coordenades);
        this.MidaMaxima = MidaVehicle.GRAN;
        this.estatDisponibilitat = true;

    }
        @Override
    public String toString() {
        return "PlacaGran [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }


}
