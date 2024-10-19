import jarras.Jarra;

public class PruebaJarra {
    public static void main(String[] args) {
        // Crea una instancia de Jarra A con una capacidad de 7 litros
        Jarra jarraA = new Jarra(7);

        // Crea una instancia de Jarra B con una capacidad de 4 litros
        Jarra jarraB = new Jarra(4);

        // Llena completamente la jarra A
        jarraA.llena();

        // Muestra el estado de la jarra A y B en la consola
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        // Llena la jarra B desde la jarra A, transfiriendo el agua de A a B
        jarraB.llenarDesde(jarraA);

        // Muestra el estado actualizado de ambas jarras después de la transferencia
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        // Vacía completamente la jarra B
        jarraB.vacia();

        // Muestra el estado de las jarras después de vaciar la jarra B
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        // Llena la jarra B nuevamente desde la jarra A
        jarraB.llenarDesde(jarraA);
        
        // Muestra el estado final de las jarras
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);
    }
}
