package dam.com.vehicles;

//una clase abstracta es una clase que no se puede instanciar
//abstract se usa para implantar metodos que van a usar las otras clases.

public class Vehicles {
    // protected es para que solo se pueda acceder desde la clase y sus subclases
    protected String matricula;
    protected MidaVehicle mida;
    protected Marca marca;

    @Override
    public String toString() {
        return "Vehicles [matricula=" + matricula + ", mida=" + mida + ", marca=" + marca + "]";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {

        if (!matricula.substring(0, 4).matches("\\d{4}")) {
            throw new IllegalArgumentException("Los primeros 4 caracteres de la matricula tienen que ser numeros");
        }

        if (!matricula.substring(4, 5).equals("-")) {
            throw new IllegalArgumentException("La matricula debe contener un guion despues de los 4 digitos");
        }

        if (!matricula.substring(5, 8).toUpperCase().matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Los ultimos 3 caracteres deben de ser letras de la A a la Z");
        }

        this.matricula = matricula;

    }

    public MidaVehicle getMida() {
        return mida;
    }

    public void setMida(MidaVehicle mida) {
        this.mida = mida;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
