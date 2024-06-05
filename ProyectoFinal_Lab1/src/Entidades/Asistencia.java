package Entidades;

import java.time.LocalDate;

public class Asistencia {
    private int idAsistencia;
    private Socio idSocio;
    private Clase idClase;
    private LocalDate fechaAsistencia;

    public Asistencia() {
    }

    public Asistencia(int idAsistencia, Socio idSocio, Clase idClase, LocalDate fechaAsistencia) {
        this.idAsistencia = idAsistencia;
        this.idSocio = idSocio;
        this.idClase = idClase;
        this.fechaAsistencia = fechaAsistencia;
    }

    public Asistencia(Socio idSocio, Clase idClase, LocalDate fechaAsistencia) {
        this.idSocio = idSocio;
        this.idClase = idClase;
        this.fechaAsistencia = fechaAsistencia;
    }

    public int getIdAsistencia() {
        return idAsistencia;
    }

    public void setIdAsistencia(int idAsistencia) {
        this.idAsistencia = idAsistencia;
    }

    public Socio getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(Socio idSocio) {
        this.idSocio = idSocio;
    }

    public Clase getIdClase() {
        return idClase;
    }

    public void setIdClase(Clase idClase) {
        this.idClase = idClase;
    }

    public LocalDate getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(LocalDate fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "idAsistencia=" + idAsistencia + ", idSocio=" + idSocio + ", idClase=" + idClase + ", fechaAsistencia=" + fechaAsistencia + '}';
    }
    
}
