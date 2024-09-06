package domain;

import java.util.Comparator;

public class ComparadorPorGenero {
    public static final Comparator<Persona> COMPARADOR_POR_GENERO = 
        (p1, p2) -> {
            if (p1.getGenero().equals("F") && !p2.getGenero().equals("F")) {
                return -1;
            }
            if (p2.getGenero().equals("F") && !p1.getGenero().equals("F")) {
                return 1;
            }
            return 0;
        };
}
