package hospital;

import java.util.List;
import java.util.Optional;

public class Departamento {
    private String nombre;
    private List<Medico> medicos;

    public Departamento(String nombre, List <Medico>medicos)
    {
        this.nombre = nombre;
        this.medicos = medicos;
    }

    public Optional<Medico> getMedico(String dni)
    {
        // Una opción sería:
        /*
        Medico med = null;

        int i = 0;
        while(i < medicos.size() && med != null)
        {
            if(medicos.get(i).getDni().equals(dni))
            {
                med = medicos.get(i);
            }
            i++;
        }

        return med;
        */

        // Pero usando programación funcional se puede hacer de la siguiente manera:
        return medicos.stream().filter(m -> m.getDni().equals(dni)).findFirst();
    }

    public boolean trabajaEnDepartamento(Medico medico)
    {
        /*
        boolean encontrado = false;
        int i = 0;

        while(i < medicos.size() && !encontrado)
        {
            encontrado = medicos.get(i).getDni().equals(medico.getDni());
            i++;
        }
        return encontrado;

        */
        return medicos.stream()
                .anyMatch(m-> m.getDni().equals(medico.getDni()));
    }

    public int numMedicos(Categoria categoria)
    {
        /*
        int total = 0;
        for(int i = 0; i < medicos.size(); i++)
        {
            if(medicos.get(i).getCategoriaProf() == categoria)
                total++;
        }
        return total;

         */
        return (int)medicos.stream().filter(m -> m.getCategoriaProf() == categoria).count();
    }


    public int getNumMedicos()
    {
        return medicos.size();
    }



}
