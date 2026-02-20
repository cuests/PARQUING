package dam.com;

import dam.com.vehicles.Vehicles;

public class Tiquet {
    private String vehicle;
    private String plaça;
    private String horaEntrada;
    private String horaSortida;

    public Tiquet(String vehicle, String plaça, String horaEntrada, String horaSortida) {
        this.vehicle = vehicle;
        this.plaça = plaça; 
        this.horaEntrada = horaEntrada;
        this.horaSortida = horaSortida;
    }

    public String getVehicle() {
        return vehicle;
    }

    public String getPlaça() {
        return plaça;
    }

    public void setVehicle(String vehicle) {
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
    public void ConsultarHoraEntrada(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            System.out.println(horaEntrada);
        }
    }
     public void ConsultarHoraSortida(Vehicles vehicle) {
        if (vehicle.equals(this.vehicle)) {
            System.out.println(horaSortida);
        }
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
