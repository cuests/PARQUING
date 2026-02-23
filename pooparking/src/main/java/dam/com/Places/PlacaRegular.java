package dam.com.Places;

import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

public class PlacaRegular extends PlacaAparcament {

    protected MidaVehicle MidaMaxima;
    @Override
    public boolean compatible (Vehicles vehicle){
        // una placa regular és compatible amb vehicles PETIT o MITJA
        if (vehicle.getMida() == MidaVehicle.PETIT || vehicle.getMida() == MidaVehicle.MITJA){
            return true;
        }
        return false;
}
    public PlacaRegular(int numeroPlaca, Coordenada[] coordenades) {
        super(numeroPlaca, coordenades);
        this.MidaMaxima = MidaVehicle.MITJA;
        this.estatDisponibilitat = true;

    }
        @Override
    public String toString() {
        return "PlacaRegular [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }
        @Override
        protected void horaSortida(int i) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'horaSortida'");
        }


}
