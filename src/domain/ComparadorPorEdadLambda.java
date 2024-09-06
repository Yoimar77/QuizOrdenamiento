package domain;

import java.util.Comparator;

public class ComparadorPorEdadLambda {
    public static final Comparator<Persona> COMPARADOR_POR_EDAD = 
        (p1, p2) -> {
            boolean p1MayorDe60 = p1.getEdad() > 60;
            boolean p2MayorDe60 = p2.getEdad() > 60;

            if (p1MayorDe60 && !p2MayorDe60) {
                return -1;
            }
            if (p2MayorDe60 && !p1MayorDe60) {
                return 1;
            }
            return 0;
        };
}
