package dam.com.Tickets;

import java.time.LocalDateTime;

import dam.com.PlacaAparcament;
import dam.com.vehicles.Vehicles;

public class Tiquet {
    private int numero;
    private Vehicles vehicle;
    private PlacaAparcament plaça;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSortida;

    static private int comptador = 0;

    public Tiquet(Vehicles vehicle, PlacaAparcament plaça, LocalDateTime horaEntrada, LocalDateTime horaSortida) {
        this.numero = comptador++;
        this.vehicle = vehicle;
        this.plaça = plaça; 
        this.horaEntrada = horaEntrada;
        this.horaSortida = horaSortida;

    }

    public Tiquet(PlacaAparcament plaça2, Vehicles vehicle2) {
        //TODO Auto-generated constructor stub
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
        return java.time.Duration.between(horaEntrada, horaSortida).toMinutes();
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
