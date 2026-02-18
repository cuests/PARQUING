package dam.com;

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
        if (vehicle.getMida() == MidaVehicle.PETIT && vehicle.getMida() == MidaVehicle.MITJA){
            return true;
        }
        return false;
}


}
