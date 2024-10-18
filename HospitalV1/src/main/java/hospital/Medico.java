package hospital;

public class Medico extends Persona{
    private Categoria categoriaProf;
    private double horasSemanales;
    private boolean trabajaEnPrivado;


    public Medico(String dni, String nombre, String apellidos, int edad, Genero genero,
                  Categoria categoriaProf,boolean trabajaEnPrivado, double horasSemanales) {
        super(dni,nombre,apellidos,edad,genero);
        this.categoriaProf = categoriaProf;
        this.trabajaEnPrivado = trabajaEnPrivado;
        this.horasSemanales = horasSemanales;
    }


    public Categoria getCategoriaProf() {
        return categoriaProf;
    }

    public void setCategoriaProf(Categoria categoriaProf) {
        this.categoriaProf = categoriaProf;
    }

    public boolean isTrabajaEnPrivado() {
        return trabajaEnPrivado;
    }

    public void setTrabajaEnPrivado(boolean trabajaEnPrivado) {
        this.trabajaEnPrivado = trabajaEnPrivado;
    }

    public double getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(double horasSemanales) {
        this.horasSemanales = horasSemanales;
    }
}
