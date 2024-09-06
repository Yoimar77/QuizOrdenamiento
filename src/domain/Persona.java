package domain;

import java.util.Objects;

public class Persona implements Comparable<Persona> {
    private int secuenciaTurno;
    private String cedula;
    private int edad;
    private String genero; // "M" para masculino, "F" para femenino
    private boolean esMujerEmbarazada;
    private boolean esClienteGrande;

    public Persona(int secuenciaTurno, String cedula, int edad, String genero, boolean esMujerEmbarazada, boolean esClienteGrande) {
        this.secuenciaTurno = secuenciaTurno;
        this.cedula = cedula;
        this.edad = edad;
        this.genero = genero;
        this.esMujerEmbarazada = esMujerEmbarazada;
        this.esClienteGrande = esClienteGrande;
    }

    public String getCedula() {
        return cedula;
    }

    public int getSecuenciaTurno() {
        return secuenciaTurno;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isMujerEmbarazada() {
        return esMujerEmbarazada;
    }

    public boolean isClienteGrande() {
        return esClienteGrande;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        // Orden natural por secuencia del turno
        return Integer.compare(this.secuenciaTurno, otraPersona.secuenciaTurno);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "secuenciaTurno=" + secuenciaTurno +
                ", cedula='" + cedula + '\'' +
                ", edad=" + edad +
                ", genero='" + genero + '\'' +
                ", esMujerEmbarazada=" + esMujerEmbarazada +
                ", esClienteGrande=" + esClienteGrande +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(cedula, persona.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
