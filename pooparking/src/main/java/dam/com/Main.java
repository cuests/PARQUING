package dam.com;

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
        System.out.println(v1);
    }
}