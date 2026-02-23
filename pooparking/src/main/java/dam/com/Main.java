package dam.com;

import dam.com.Places.Coordenada;
import dam.com.Places.PlacaAparcament;
import dam.com.Places.PlacaCompacta;
import dam.com.Places.PlacaGran;
import dam.com.Places.PlacaRegular;
import dam.com.Tickets.Tiquet;
import dam.com.vehicles.Cotxe;
import dam.com.vehicles.Motocicleta;
import dam.com.vehicles.Vehicles;

public class Main {
    public static void main(String[] args) {
        Vehicles v1 = new Cotxe("1234-ABC");
        Vehicles v2 = new Motocicleta("9999-XYZ");
        System.out.println(v1.getMida());
        System.out.println(v2.getMatricula());

        Coordenada[] coordenades = {
            new Coordenada(0,0),
            new Coordenada(2, 0),
            new Coordenada(2, 1),
            new Coordenada(0, 1)
        };

        PlacaAparcament placa = new PlacaRegular(1, coordenades);
        System.out.println(placa.consultarPlaca());
        PlacaAparcament p1 = new PlacaCompacta(3, coordenades);
        
        GestorParking gestor = new GestorParking();
        gestor.afegirPlaça(p1);
        gestor.afegirPlaça(new PlacaCompacta(4, coordenades));
        gestor.afegirPlaça(new PlacaGran(5, coordenades));

        Tiquet tiquet = new Tiquet(new Motocicleta("9999-XYZ"), p1);
        System.out.println(tiquet);

    }
}