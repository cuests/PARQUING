package dam.com.Places;

import dam.com.vehicles.MidaVehicle;
import dam.com.vehicles.Vehicles;

//clase padre PlacaAparcament (PlacaAparcament es abstracta)
public class PlacaGran extends PlacaAparcament {
    // protected es per a que només es pugui accedir des de la classe i les seves
    // subclasses
    protected MidaVehicle MidaMaxima;

    @Override
    public boolean compatible(Vehicles vehicle) {
        return true;
    }

    public PlacaGran(int numeroPlaca, Coordenada[] coordenades) {
        // super es per a cridar al constructor de la classe pare
        super(numeroPlaca, coordenades);
        // per aixo es posa protected perque PlacaGran admet vehicles petits, mitjans i
        // grans
        this.MidaMaxima = MidaVehicle.GRAN;
        //this.estatDisponibilitat = true;

    }

    @Override
    public String toString() {
        return "PlacaGran [MidaMaxima=" + MidaMaxima + super.toString() + "]";
    }

}
