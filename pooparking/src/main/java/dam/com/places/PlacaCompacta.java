package dam.com.places;

import dam.com.PlacaAparcament;
import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

public class PlacaCompacta extends PlacaAparcament{

    protected MidaVehicle MidaMaxima;

    @Override
    public boolean compatible (Vehicles vehicle){
        if (vehicle.getMida() == MidaVehicle.PETIT){
            return true;
        }
        return false;  
}

    public PlacaCompacta(int numeroPlaca, Coordenada[] coordenades) {

        setNumeroPlaca(numeroPlaca);
        setUbicacio(coordenades);
        this.MidaMaxima = MidaVehicle.PETIT;
        this.estatDisponibilitat = true;
        
    }

}
