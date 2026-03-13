# 🅿️ Gestor de Parking

Sistema de gestió d'aparcament desenvolupat en Java. Permet aparcar i desaparcar vehicles en places de diferents mides, generant tiquets amb càlcul automàtic del preu.

---

## 📐 Diagrames de Classes

### 🚗 Vehicles

```mermaid
classDiagram
    class Vehicles {
        <<abstract>>
        #String matricula
        #MidaVehicle mida
        #Marca marca
        +getMatricula() String
        +setMatricula(String)
        +getMida() MidaVehicle
        +getMarca() Marca
        +toString() String
    }

    class Cotxe {
        +Cotxe(String matricula, Marca marca)
    }

    class Camio {
        +Camio(String matricula, Marca marca)
    }

    class Motocicleta {
        +Motocicleta(String matricula, Marca marca)
    }

    class MidaVehicle {
        <<enum>>
        PETIT
        MITJA
        GRAN
    }

    class Marca {
        <<enum>>
        AUDI
        BMW
        FERRARI
        FIAT
        FORD
        HONDA
        MERCEDES
        RENAULT
        SEAT
        TOYOTA
    }

    Vehicles <|-- Cotxe
    Vehicles <|-- Camio
    Vehicles <|-- Motocicleta
    Vehicles --> MidaVehicle
    Vehicles --> Marca
```

---

### 🅿️ Places d'Aparcament

```mermaid
classDiagram
    class PlacaAparcament {
        <<abstract>>
        #int numeroPlaca
        #boolean estatDisponibilitat
        #Vehicles vehicleAparcat
        #Coordenada[] ubicacio
        +aparcarVehicle(Vehicles) void
        +desaparcar() void
        +ocuparPlaca() void
        +alliberarPlaca() void
        +consultarPlaca() String
        +compatible(Vehicles) boolean*
        +isEstatDisponibilitat() boolean
    }

    class PlacaCompacta {
        #MidaVehicle MidaMaxima
        +compatible(Vehicles) boolean
        +PlacaCompacta(int, Coordenada[])
    }

    class PlacaRegular {
        #MidaVehicle MidaMaxima
        +compatible(Vehicles) boolean
        +PlacaRegular(int, Coordenada[])
    }

    class PlacaGran {
        #MidaVehicle MidaMaxima
        +compatible(Vehicles) boolean
        +PlacaGran(int, Coordenada[])
    }

    class Coordenada {
        -double x
        -double y
        +getX() double
        +getY() double
        +setX(double)
        +setY(double)
    }

    PlacaAparcament <|-- PlacaCompacta
    PlacaAparcament <|-- PlacaRegular
    PlacaAparcament <|-- PlacaGran
    PlacaAparcament --> Coordenada
    PlacaAparcament --> Vehicles
```

> **Compatibilitat de places:**
> | Tipus | PETIT | MITJA | GRAN |
> |---|:---:|:---:|:---:|
> | `PlacaCompacta` | ✅ | ❌ | ❌ |
> | `PlacaRegular` | ✅ | ✅ | ❌ |
> | `PlacaGran` | ✅ | ✅ | ✅ |

---

### 🎫 Tiquets i Gestor

```mermaid
classDiagram
    class Tiquet {
        -int numero
        -Vehicles vehicle
        -PlacaAparcament plaça
        -LocalDateTime horaEntrada
        -LocalDateTime horaSortida
        -int comptador$
        +getNumero() int
        +minuts() long
        +ConsultarPlaca(Vehicles) PlacaAparcament
        +ConsultarHoraSortida(Vehicles) LocalDateTime
        +setHoraSortida(LocalDateTime)
    }

    class GestorParking {
        -ArrayList~PlacaAparcament~ places
        -ArrayList~Tiquet~ tiquets
        +PREU_MINUT$ double
        +aparcarVehicle(Vehicles) Tiquet
        +desaparcar(Tiquet) double
        +getTiquet(int) Tiquet
        +afegirPlaça(PlacaAparcament)
        +mostrarEstat()
    }

    class TipusMoviment {
        <<enum>>
        INGRES
        RETIRADA
        TRANSFERENCIA
    }

    GestorParking "1" --> "*" PlacaAparcament : gestiona
    GestorParking "1" --> "*" Tiquet : genera
    Tiquet --> Vehicles : referència
    Tiquet --> PlacaAparcament : referència
```

---

## 🔄 Diagrama de Casos d'Ús

![Diagrama de Casos d'Ús](https://www.plantuml.com/plantuml/png/TP5DQyCm38Rl_XKYznRMJnYbT6JGww3qF3H7IqqLE_F7O8pzzod12qkw-IJfVII_bWyXee-fOIWnk70Epq_ehyRMYkarGdJWJNs9K1bFEXfdLH2rHOyDjAYlMDCfVZ119wEjcHJgw3mKfRDLwi82CC2G_SWd4o8rs8ivLiCCA8uKEgmYo7uA-5GW9mNI68Hu41CQFRpJnMYcVj2vl1j39sBIMcmBs39g1EsQ5gDv6JeMuuuZMV92H_EMA6PcEMOUAU2Vjw_6N8ci4tTNUqePMKyGPqDY-GEG1wFicLZscb_SDsp-QnWvtAelDUmOPhDzlujfPNLJsTnKjaewOJxluWNSmsvdhEPKqNx_IrdUAAkih2TA_jmyVJ79bvDyhGuaVXh-1W00)

---

## 🏗️ Estructura del Projecte

```
src/
└── dam/
    └── com/
        ├── GestorParking.java
        ├── Places/
        │   ├── PlacaAparcament.java   ← abstracta
        │   ├── PlacaCompacta.java
        │   ├── PlacaRegular.java
        │   ├── PlacaGran.java
        │   └── Coordenada.java
        ├── Tickets/
        │   └── Tiquet.java
        └── vehicles/
            ├── Vehicles.java          ← abstracta
            ├── Cotxe.java
            ├── Camio.java
            ├── Motocicleta.java
            ├── Marca.java
            └── MidaVehicle.java
```

---

## ⚙️ Funcionament

1. Es crea un `GestorParking` amb una llista de places (`PlacaCompacta`, `PlacaRegular`, `PlacaGran`).
2. Es crida `aparcarVehicle(vehicle)` → el gestor busca la primera plaça compatible i genera un `Tiquet`.
3. Per desaparcar, es crida `desaparcar(tiquet)` → s'allibera la plaça i es calcula el preu: `minuts × 2,0 €/minut`.