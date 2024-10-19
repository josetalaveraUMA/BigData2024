import jarras.Mesa;

public class PruebaMesa {
    public static void main(String[] args) {

        // Crea una mesa con dos jarras, una de 7 litros y otra de 5 litros
        Mesa mesa = new Mesa(7, 5);

        System.out.println("Paso 1: Llenar la jarra de 7 litros");
        mesa.llena(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 2: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 3: Vaciar la jarra de 4 litros");
        mesa.vacia(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        System.out.println("Paso 4: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 5: Llenar la jarra de 7 litros");
        mesa.llena(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 6: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 7: Vaciar la jarra de 4 litros");
        mesa.vacia(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        System.out.println("Paso 8: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 9: Llenar la jarra de 7 litros");
        mesa.llena(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 10: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);

        System.out.println("Paso 11: Vaciar la jarra de 4 litros");
        mesa.vacia(Mesa.Posicion.Derecha);
        System.out.println(mesa);

        System.out.println("Paso 12: Llenar la jarra de 4 litros desde la jarra de 7 litros");
        mesa.llenaDesde(Mesa.Posicion.Izquierda);
        System.out.println(mesa);
    }
}
