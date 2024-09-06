package domain;

import java.util.Comparator;

public class ComparadorJerarquico implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        Comparator<Persona> comparadorCompuesto = 
            ComparadorPorEdadLambda.COMPARADOR_POR_EDAD
            .thenComparing(ComparadorPorGenero.COMPARADOR_POR_GENERO)
            .thenComparing(new ComparadorPorEmbarazo())
            .thenComparing(new ComparadorPorClienteGrande())
            .thenComparing(Persona::compareTo); // El orden natural como último criterio

        return comparadorCompuesto.compare(p1, p2);
    }
}
