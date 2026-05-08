package dam.com.Tickets;

import java.time.Duration;
import java.time.LocalDateTime;

import dam.com.Places.PlacaAparcament;
import dam.com.vehicles.Vehicles;

public class Tiquet {
    private int numero;
    private Vehicles vehicle;
    private PlacaAparcament plaça;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSortida;

    static private int comptador = 1;

    public Tiquet(Vehicles vehicle, PlacaAparcament plaça) {
        this.numero = comptador++;
        this.vehicle = vehicle;
        this.plaça = plaça;
        this.horaEntrada = LocalDateTime.now();
    }
    public int getNumero() {
        return numero;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public PlacaAparcament getPlaça() {
        return plaça;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public void setPlaça(PlacaAparcament plaça) {
        this.plaça = plaça;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSortida(LocalDateTime horaSortida) {            
        this.horaSortida = horaSortida;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSortida() {
        return horaSortida;
    }

    public PlacaAparcament ConsultarPlaca(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            return plaça;
        }
        return null;
    }

    public LocalDateTime ConsultarHoraSortida(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            return horaSortida;
        }
        return null;
    }

    public long minuts() {
        Duration duracio = Duration.between(horaEntrada, horaSortida);
        return duracio.toMinutes();
    }

     @Override
     public String toString() {
         return "Tiquet{" +
                 "vehicle='" + vehicle + '\'' +
                 ", plaça='" + plaça + '\'' +
                 ", horaEntrada='" + horaEntrada + '\'' +
                 ", horaSortida='" + horaSortida + '\'' +
                 '}';
     }
}
