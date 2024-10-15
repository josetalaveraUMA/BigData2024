import jarras.Jarra;


public class PruebaJarra {
    public static void main(String[] args) {
        Jarra jarraA = new Jarra(7);
        Jarra jarraB = new Jarra(4);

        jarraA.llena();
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        jarraB.llenarDesde(jarraA);
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        jarraB.vacia();
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);

        jarraB.llenarDesde(jarraA);
        System.out.println("jarraA: \n" + jarraA);
        System.out.println("jarraB: \n" + jarraB);
    }
}
