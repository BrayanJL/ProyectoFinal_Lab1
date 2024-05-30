package Entidades;

import java.time.LocalDate;

public class Membresia {
    private int idMembresia;
    private Socio socio;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Membresia() {
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Membresia{" + "idMembresia=" + idMembresia + ", socio=" + socio + ", tipo=" + tipo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
}
