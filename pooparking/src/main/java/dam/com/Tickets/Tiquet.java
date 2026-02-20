package dam.com.Tickets;

import java.time.LocalDateTime;

import dam.com.vehicles.Vehicles;

public class Tiquet {
    private int numero;
    private Vehicles vehicle;
    private String plaça;
    private String horaEntrada;
    private String horaSortida;

    static private int comptador = 0;

    public Tiquet(Vehicles vehicle, String plaça, String horaEntrada, String horaSortida) {
        this.numero = comptador++;
        this.vehicle = vehicle;
        this.plaça = plaça; 
        this.horaEntrada = LocalDateTime.now().toString();
        this.horaSortida = horaSortida;

    }

    public int getNumero() {
        return numero;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public String getPlaça() {
        return plaça;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public void setPlaça(String plaça) {
        this.plaça = plaça;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSortida(String horaSortida) {            
        this.horaSortida = horaSortida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSortida() {
        return horaSortida; 
    }

    public String ConsultarPlaca(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            return plaça;
        }
        return null;
    }

    public String ConsultarHoraSortida(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            return horaSortida;
        }
        return null;
    }

    public long minuts() {
        return java.time.Duration.between(LocalDateTime.parse(horaEntrada), LocalDateTime.parse(horaSortida)).toMinutes();
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
