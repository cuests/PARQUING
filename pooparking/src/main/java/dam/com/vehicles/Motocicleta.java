package dam.com.vehicles;

//hereda de Vehicles (vehicles es abstracta)
public class Motocicleta extends Vehicles {

    public Motocicleta(String matricula, Marca marca) {

        this.matricula = matricula;
        // definimos el tamaño con .PETIT porque es una motocicleta
        this.mida = MidaVehicle.PETIT;
        this.marca = marca;

    }

}
