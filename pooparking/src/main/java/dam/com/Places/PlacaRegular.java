package dam.com.Places;

import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

//clase padre PlacaAparcament (PlacaAparcament es abstracta)
public class PlacaRegular extends PlacaAparcament {

    // protected es per a que només es pugui accedir des de la classe i les seves
    // subclasses
    protected MidaVehicle MidaMaxima;

    @Override
    public boolean compatible(Vehicles vehicle) {
        // una placa regular és compatible amb vehicles PETIT o MITJA
        if (vehicle.getMida() == MidaVehicle.PETIT || vehicle.getMida() == MidaVehicle.MITJA) {
            return true;
        }
        return false;
    }

    public PlacaRegular(int numeroPlaca, Coordenada[] coordenades) {
        // super es per a cridar al constructor de la classe pare
        super(numeroPlaca, coordenades);
        // per aixo es posa protected perque PlacaRegular nomès admet vehicles petits o
        // mitjans
        this.MidaMaxima = MidaVehicle.MITJA;
        this.estatDisponibilitat = true;

    }

    @Override
    public String toString() {
        return "PlacaRegular [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }

}
