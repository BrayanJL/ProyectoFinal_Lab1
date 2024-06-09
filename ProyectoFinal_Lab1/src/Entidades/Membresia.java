package Entidades;

import java.time.LocalDate;

public class Membresia {
    private int idMembresia;
    private Socio socio;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costo;
    private boolean estado;
    private int cantidadPases;

    public Membresia() {
    }

    public Membresia(int idMembresia, Socio socio, int cantidadPases, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.idMembresia = idMembresia;
        this.socio = socio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
        this.cantidadPases = cantidadPases;
    }

    public Membresia(Socio socio, int cantidadPases, LocalDate fechaInicio, LocalDate fechaFin, double costo, boolean estado) {
        this.socio = socio;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.estado = estado;
        this.cantidadPases = cantidadPases;
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
    
    public int getIdSocio() {
        return socio.getIdSocio();
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

    public boolean isActivo() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getCantidadPases() {
        return cantidadPases;
    }

    public void setCantidadPases(int cantidadPases) {
        this.cantidadPases = cantidadPases;
    }

    @Override
    public String toString() {
        return "Membresia{" + "idMembresia=" + idMembresia + ", socio=" + socio + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + ", estado=" + estado + ", cantidadPases=" + cantidadPases + '}';
    }

    

}
