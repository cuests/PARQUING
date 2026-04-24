package dam.com.vehicles;

//hereda de Vehicles (vehicles es abstracta)
public class Cotxe extends Vehicles {

    public Cotxe(String matricula, Marca marca) {

        this.matricula = matricula;
        this.mida = MidaVehicle.MITJA;
        this.marca = marca;

    }

}
