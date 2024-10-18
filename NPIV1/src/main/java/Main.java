import npi.NPI;

public class Main {
    public static void main(String[] args) {
        NPI npi = new NPI();
        System.out.println(npi);

        npi.entra(3);
        npi.entra(6);
        npi.entra(4);
        System.out.println(npi);

        npi.resta();
        System.out.println(npi);

        npi.multiplica();
        System.out.println(npi);

        npi.entra(5);
        System.out.println(npi);

        npi.suma();
        System.out.println(npi);
    }


}
