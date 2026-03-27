package dam.com.Places;

import java.util.Arrays;

import dam.com.vehicles.Vehicles;

public abstract class PlacaAparcament {
    protected int numeroPlaca;
    protected boolean estatDisponibilitat;
    protected Vehicles vehicleAparcat;
    protected Coordenada[] ubicacio;

    public PlacaAparcament(int numeroPlaca, Coordenada[] coordenades) {
        setNumeroPlaca(numeroPlaca);
        setUbicacio(coordenades);
        this.estatDisponibilitat = true;
    }

    @Override
    public String toString() {
        return "PlacaAparcament [numeroPlaca=" + numeroPlaca + ", estatDisponibilitat=" + estatDisponibilitat
                + ", vehicleAparcat=" + vehicleAparcat + ", ubicacio=" + Arrays.toString(ubicacio) + "]";
    }

    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public boolean isEstatDisponibilitat() {
        return estatDisponibilitat;
    }

    public Vehicles getVehicleAparcat() {
        return vehicleAparcat;
    }

    public Coordenada[] getUbicacio() {
        return ubicacio;
    }

    public void setNumeroPlaca(int numeroPlaca) {

        if (numeroPlaca < 0)
            throw new IllegalArgumentException("Les places comencen per el 1");

        this.numeroPlaca = numeroPlaca;

    }

    public void setVehicleAparcat(Vehicles vehicleAparcat) {
        this.vehicleAparcat = vehicleAparcat;
    }

    public void setUbicacio(Coordenada[] coordenades) {
        this.ubicacio = coordenades;
    }

    public void ocuparPlaca() {
        this.estatDisponibilitat = false;
    }

    public void alliberarPlaca() {
        this.estatDisponibilitat = true;
    }

    public void desaparcar() {
        if (this.vehicleAparcat == null){
            throw new IllegalArgumentException("Ja esta vuida la plaça.");
        }
        this.vehicleAparcat = null;
        this.estatDisponibilitat = true;
    }

    // metodo abstracto que se implementara en las subclases para comprobar si el
    // vehicle es compatible con la placa
    public abstract boolean compatible(Vehicles vehicle);

    public String consultarPlaca() {
        if (this.estatDisponibilitat) {
            return "La placa esta lliure";
        } else {
            return "La placa esta ocupada";
        }
    }

    /**
     * Intenta aparcar un vehicle en aquesta placa.
     * Lança una excepció si la plaça està ocupada o el vehicle no és compatible.
     */
    public void aparcarVehicle(Vehicles vehicle) throws Exception {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle incorrecte!");
        }

        if (!this.estatDisponibilitat) {
            throw new IllegalArgumentException("La plaça ja està ocupada");
        }

        if (!compatible(vehicle)) {
            throw new IllegalArgumentException("La plaça no és compatible");
        }
        setVehicleAparcat(vehicle);
        ocuparPlaca();
    }
}
