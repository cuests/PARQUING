package dam.com.Places;
public class EstatPlacaLliure implements EstatPlaca {

    
    public void aparcarVehicle (PlacaAparcament placa) {
        if (placa == null){
            throw new ParkingException("No pots aparcar");
        }
    }

    @Override
    public void desaparcar (PlacaAparcament placa){
        if (placa == null){
            throw new IllegalArgumentException("Ja esta vuida la plaça.");
        }
        placa = null;

    }

    
}
