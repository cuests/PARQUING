package dam.com.vehicles;

public abstract class Vehicles {
    protected String matricula;
    protected MidaVehicle mida;



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
}
