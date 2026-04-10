package dam.com.Places;

public class EstatPlacaOcupada implements EstatPlaca {

        public void aparcarVehicle (PlacaAparcament placa) {
        if (placa != null){
            throw new ParkingException("No pots aparcar perque esta ocupada");
        }
    }

    @Override
    public void desaparcar (PlacaAparcament placa){
        if (placa == null){
            throw new IllegalArgumentException("Ja esta vuida la plaça.");
        }
        placa = null;

    }
    @Override
    public boolean estaLliure () {
        return false;
    }; 
}