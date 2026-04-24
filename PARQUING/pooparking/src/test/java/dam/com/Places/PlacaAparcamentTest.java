package dam.com.Places;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dam.com.vehicles.Camio;
import dam.com.vehicles.Cotxe;
import dam.com.vehicles.Marca;
import dam.com.vehicles.Motocicleta;

public class PlacaAparcamentTest {

    private Coordenada[] coordenades;
    private PlacaRegular placaRegular;
    private PlacaCompacta placaCompacta;
    private PlacaGran placaGran;

    private Motocicleta moto;
    private Cotxe cotxe;
    private Camio camio;

    @BeforeEach
    public void setUp() {
        coordenades = new Coordenada[] {
                new Coordenada(0, 0), new Coordenada(2, 0),
                new Coordenada(2, 1), new Coordenada(0, 1)
        };

        placaCompacta = new PlacaCompacta(1, coordenades);
        placaRegular = new PlacaRegular(2, coordenades);
        placaGran = new PlacaGran(3, coordenades);

        moto = new Motocicleta("1111-AAA", Marca.BMW);
        cotxe = new Cotxe("2222-BBB", Marca.AUDI);
        camio = new Camio("3333-CCC", Marca.FORD);
    }

    // ── Tests estaLliure ──────────────────────────────────────────────────────

    @Test
    public void test_estaLliureNovaPlaca() {
        assertTrue(placaRegular.estaLliure(), "Una plaça nova hauria d'estar lliure.");
    }

    @Test
    public void test_estaOcupadaDesprésAparcar() throws Exception {
        placaRegular.aparcarVehicle(cotxe);
        assertFalse(placaRegular.estaLliure(), "La plaça hauria d'estar ocupada després d'aparcar.");
    }

    @Test
    public void test_estaLliureDesprésDesaparcar() throws Exception {
        placaRegular.aparcarVehicle(cotxe);
        placaRegular.desaparcar();
        assertTrue(placaRegular.estaLliure(), "La plaça hauria d'estar lliure després de desaparcar.");
    }

    // ── Tests aparcarVehicle ──────────────────────────────────────────────────

    @Test
    public void test1_AparcarVehicleValidCompatible() throws Exception {
        placaRegular.aparcarVehicle(cotxe);
        assertEquals(cotxe, placaRegular.getVehicleAparcat(), "El vehicle hauria d'estar aparcat correctament.");
        assertFalse(placaRegular.estaLliure(), "La plaça hauria d'estar ocupada.");
    }

    @Test
    public void test2_AparcarVehicleNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placaRegular.aparcarVehicle(null);
        });
        assertEquals("Vehicle incorrecte!", exception.getMessage());
    }

    @Test
    public void test3_AparcarVehicleNoCompatible() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placaCompacta.aparcarVehicle(cotxe);
        });
        assertEquals("La plaça no és compatible", exception.getMessage());
    }

    @Test
    public void test4_AparcarPlacaOcupada() throws Exception {
        placaRegular.aparcarVehicle(cotxe);
        assertFalse(placaRegular.estaLliure(), "La plaça hauria d'estar ocupada.");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placaRegular.aparcarVehicle(moto);
        });
        assertEquals("La plaça ja està ocupada", exception.getMessage());
    }

    @Test
    public void test5_AparcarDespresDeDesaparcar() throws Exception {
        placaRegular.aparcarVehicle(cotxe);
        placaRegular.desaparcar();
        assertTrue(placaRegular.estaLliure(), "La plaça hauria d'estar lliure després de desaparcar.");
        assertDoesNotThrow(() -> {
            placaRegular.aparcarVehicle(moto);
        });
        assertEquals(moto, placaRegular.getVehicleAparcat());
    }

    @Test
    public void test6_AparcarMateixVehicleDosCops() throws Exception {
        placaRegular.aparcarVehicle(cotxe);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placaRegular.aparcarVehicle(cotxe);
        });
        assertEquals("La plaça ja està ocupada", exception.getMessage());
    }

    @Test
    public void test7_AparcarVehiclePetitEnPlacaRegular() throws Exception {
        placaRegular.aparcarVehicle(moto);
        assertEquals(moto, placaRegular.getVehicleAparcat(),
                "El vehicle petit aparca correctament encara que la plaça sigui més gran.");
    }

    @Test
    public void test8_AparcarVehiclePetitEnPlacaCompacta() throws Exception {
        placaCompacta.aparcarVehicle(moto);
        assertEquals(moto, placaCompacta.getVehicleAparcat());
    }

    @Test
    public void test9_AparcarVehicleGranEnPlacaGran() throws Exception {
        placaGran.aparcarVehicle(camio);
        assertEquals(camio, placaGran.getVehicleAparcat());
    }

    @Test
    public void test10_AparcarVehicleGranEnPlacaRegular() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            placaRegular.aparcarVehicle(camio);
        });
        assertEquals("La plaça no és compatible", exception.getMessage());
    }
}