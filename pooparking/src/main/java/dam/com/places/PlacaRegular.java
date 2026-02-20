package dam.com.places;

import dam.com.PlacaAparcament;
import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

public class PlacaRegular extends PlacaAparcament {

    protected MidaVehicle MidaMaxima;

    public PlacaRegular(int numeroPlaca, Coordenada[] coordenades) {

        setNumeroPlaca(numeroPlaca);
        setUbicacio(coordenades);
        this.MidaMaxima = MidaVehicle.MITJA;
        this.estatDisponibilitat = true;

    }
    @Override
    public boolean compatible (Vehicles vehicle){
        // una placa regular és compatible amb vehicles PETIT o MITJA
        if (vehicle.getMida() == MidaVehicle.PETIT || vehicle.getMida() == MidaVehicle.MITJA){
            return true;
        }
        return false;
}


}
