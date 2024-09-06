package domain;

import java.util.Comparator;

public class ComparadorPorEmbarazo implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Si p1 es mujer embarazada y p2 no lo es, p1 tiene prioridad
        if (p1.isMujerEmbarazada() && !p2.isMujerEmbarazada()) {
            return -1;
        }
        // Si p2 es mujer embarazada y p1 no lo es, p2 tiene prioridad
        if (p2.isMujerEmbarazada() && !p1.isMujerEmbarazada()) {
            return 1;
        }
        // Si ambas están embarazadas o ninguna lo está, son iguales en este criterio
        return 0;
    }
}
