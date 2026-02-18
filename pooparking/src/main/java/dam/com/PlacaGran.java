package dam.com;

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
