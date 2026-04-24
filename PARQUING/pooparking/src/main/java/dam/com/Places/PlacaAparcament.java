package dam.com.Places;

import java.util.Arrays;

import dam.com.vehicles.Vehicles;

public abstract class PlacaAparcament {
    protected int numeroPlaca;
    protected EstatPlaca estatDisponibilitat;
    protected Vehicles vehicleAparcat;
    protected Coordenada[] ubicacio;

    public PlacaAparcament(int numeroPlaca, Coordenada[] coordenades, boolean estaLliure) {
        setNumeroPlaca(numeroPlaca);
        setUbicacio(coordenades);
        this.estatDisponibilitat = new EstatPlacaLliure();
    }

    @Override
    public String toString() {
        return "PlacaAparcament [numeroPlaca=" + numeroPlaca + ", estatDisponibilitat=" + estatDisponibilitat
                + ", vehicleAparcat=" + vehicleAparcat + ", ubicacio=" + Arrays.toString(ubicacio) + "]";
    }

    public int getNumeroPlaca() {
        return numeroPlaca;
    }

    public EstatPlaca getEstatDisponibilitat() {
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
        this.estatDisponibilitat = new EstatPlacaOcupada();
    }

    public void alliberarPlaca() {
        this.estatDisponibilitat = new EstatPlacaLliure();
    }

    public void desaparcar() {
        if (this.vehicleAparcat == null) {
            throw new IllegalArgumentException("Ja esta vuida la plaça.");
        }
        this.vehicleAparcat = null;
        alliberarPlaca();
    }

    public abstract boolean compatible(Vehicles vehicle);

    public String consultarPlaca() {
        if (estaLliure()) {
            return "La placa esta lliure";
        } else {
            return "La placa esta ocupada";
        }
    }

    public boolean estaLliure() {
        return this.estatDisponibilitat.estaLliure();
    }

    public void aparcarVehicle(Vehicles vehicle) throws Exception {
        if (vehicle == null) {
            throw new IllegalArgumentException("Vehicle incorrecte!");
        }
        if (!this.estaLliure()) {
            throw new IllegalArgumentException("La plaça ja està ocupada");
        }
        if (!compatible(vehicle)) {
            throw new IllegalArgumentException("La plaça no és compatible");
        }
        setVehicleAparcat(vehicle);
        ocuparPlaca();
    }
}