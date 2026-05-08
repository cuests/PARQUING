package dam.com;

import java.util.Scanner;

import dam.com.Places.Coordenada;
import dam.com.Places.PlacaCompacta;
import dam.com.Places.PlacaRegular;
import dam.com.Tickets.Tiquet;
import dam.com.vehicles.Cotxe;
import dam.com.vehicles.Marca;
import dam.com.vehicles.Motocicleta;
import dam.com.vehicles.Vehicles;

public class Main {
    public static void main(String[] args) {
        // Inicialització Coordenades (compartides)
        Coordenada[] coordenades = {
                new Coordenada(0, 0),
                new Coordenada(2, 0),
                new Coordenada(2, 1),
                new Coordenada(0, 1)
        };

        // Crear GestorParking i afegir places (5 regulars, 5 compactes)
        GestorParking gestor = new GestorParking();

        for (int i = 1; i <= 5; i++) {
            gestor.afegirPlaça(new PlacaRegular(i, coordenades));
        }
        for (int i = 6; i <= 10; i++) {
            gestor.afegirPlaça(new PlacaCompacta(i, coordenades));
        }

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENÚ PÀRQUING ---");
            System.out.println("1 - Aparcar vehicle");
            System.out.println("2 - Desaparcar vehicle");
            System.out.println("3 - Mostrar estat del pàrquing");
            System.out.println("0 - Sortir (Tancar execució)");
            System.out.print("Selecciona una opció: ");

            String opcio = scanner.nextLine();

            switch (opcio) {
                case "1":
                    System.out.println("Tipus de vehicle (1: Motocicleta, 2: Cotxe): ");
                    String tipus = scanner.nextLine();

                    System.out.print("Introdueix la matrícula (Ex: 1234-ABC): ");
                    String matricula = scanner.nextLine();

                    Vehicles vehicle = null;
                    try {
                        if (tipus.equals("1")) {
                            vehicle = new Motocicleta(matricula, Marca.FORD); // Marca dummy
                        } else if (tipus.equals("2")) {
                            vehicle = new Cotxe(matricula, Marca.FORD); // Marca dummy
                        } else {
                            System.out.println("Tipus de vehicle no vàlid.");
                            break;
                        }

                        Tiquet tiquet = gestor.aparcarVehicle(vehicle);
                        if (tiquet != null) {
                            System.out.println("Vehicle aparcat amb èxit. ID del Tiquet: " + tiquet.getNumero());
                        } else {
                            System.out.println("No hi ha cap plaça disponible o compatible.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error a l'aparcar: " + e.getMessage());
                    }
                    break;

                case "2":
                    System.out.print("Introdueix l'identificador del tiquet: ");
                    try {
                        int idTiquet = Integer.parseInt(scanner.nextLine());
                        Tiquet tiquetExist = gestor.getTiquet(idTiquet);

                        if (tiquetExist != null) {
                            double importAPagar = gestor.desaparcar(tiquetExist);
                            System.out.println("Vehicle desaparicat amb èxit. Import a pagar: " + importAPagar + " €");
                        } else {
                            System.out.println("Error: Tiquet no vàlid.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("L'identificador ha de ser un número.");
                    } catch (Exception e) {
                        System.out.println("Error al desaparcar: " + e.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("\n--- Estat del Pàrquing ---");
                    gestor.mostrarEstat();
                    break;

                case "0":
                    continuar = false;
                    System.out.println("Tancant el programa...");
                    break;

                default:
                    System.out.println("Opció no vàlida. Torna a intentar-ho.");
            }
        }

        scanner.close();
    }
}