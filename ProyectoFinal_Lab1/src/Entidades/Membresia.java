package Entidades;

import java.time.LocalDate;

public class Membresia {
    private int idMembresia;
    private Socio socio;
    private String tipo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costo;
    private boolean estado;

    public Membresia() {
    }

    public Membresia(int idMembresia, Socio socio, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.idMembresia = idMembresia;
        this.socio = socio;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
    }

    public Membresia(Socio socio, String tipo, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.socio = socio;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Membresia{" + "idMembresia=" + idMembresia + ", socio=" + socio + ", tipo=" + tipo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", estado=" + estado + '}';
    }

}
