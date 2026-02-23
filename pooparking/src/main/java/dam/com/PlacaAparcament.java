package dam.com;

import dam.com.places.Coordenada;
import dam.com.vehicles.Vehicles;

public abstract class PlacaAparcament {
    protected int numeroPlaca;
    protected boolean estatDisponibilitat;
    protected Vehicles vehicleAparcat;
    protected Coordenada[] ubicacio;

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

        if (numeroPlaca < 0) throw new IllegalArgumentException("Les places comencen per el 1");

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

    public void desaparcar () {
        this.vehicleAparcat = null;
        this.estatDisponibilitat = true;
    }
    

    public abstract boolean compatible (Vehicles vehicle);

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
        if (!this.estatDisponibilitat) {
            throw new IllegalStateException("La plaça està ocupada");
        }

        if (!compatible(vehicle)) {
            throw new IllegalArgumentException("Vehicle incompatible amb la plaça");
            }
        setVehicleAparcat(vehicle);
        ocuparPlaca();
    }

}
