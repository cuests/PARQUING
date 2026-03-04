package dam.com.vehicles;

//hereda de Vehicles (vehicles es abstracta)
public class Camio extends Vehicles {

    public Camio(String matricula, Marca marca) {

        this.matricula = matricula;
        this.mida = MidaVehicle.GRAN;
        this.marca = marca;
    }
}
