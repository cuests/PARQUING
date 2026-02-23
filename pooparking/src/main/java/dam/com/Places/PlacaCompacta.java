package dam.com.Places;

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

        super(numeroPlaca, coordenades);
        this.MidaMaxima = MidaVehicle.PETIT;
    }

    @Override
    public String toString() {
        return "PlacaCompacta [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }

    @Override
    protected void horaSortida(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'horaSortida'");
    }

}


