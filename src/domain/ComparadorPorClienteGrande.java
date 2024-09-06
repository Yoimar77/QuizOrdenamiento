package domain;

import java.util.Comparator;

public class ComparadorPorClienteGrande implements Comparator<Persona> {
    @Override
    public int compare(Persona p1, Persona p2) {
        // Si p1 es cliente grande y p2 no lo es, p1 tiene prioridad
        if (p1.isClienteGrande() && !p2.isClienteGrande()) {
            return -1;
        }
        // Si p2 es cliente grande y p1 no lo es, p2 tiene prioridad
        if (p2.isClienteGrande() && !p1.isClienteGrande()) {
            return 1;
        }
        // Si ambos son clientes grandes o ninguno lo es, son iguales en este criterio
        return 0;
    }
}
