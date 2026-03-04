package dam.com.Places;

import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

//hereda de PlacaAparcament (PlacaAparcament es abstracta)
public class PlacaCompacta extends PlacaAparcament {

    // protected es per a que només es pugui accedir des de la classe i les seves
    // subclasses
    protected MidaVehicle MidaMaxima;

    @Override
    public boolean compatible(Vehicles vehicle) {
        if (vehicle.getMida() == MidaVehicle.PETIT) {
            return true;
        }
        return false;
    }

    public PlacaCompacta(int numeroPlaca, Coordenada[] coordenades) {

        // super es per a cridar al constructor de la classe pare
        super(numeroPlaca, coordenades);
        // per aixo es posa protected perque PlacaCompacta nomès admet vehicles petits
        this.MidaMaxima = MidaVehicle.PETIT;
    }

    @Override
    public String toString() {
        return "PlacaCompacta [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }

}
