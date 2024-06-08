package Entidades;

import java.time.LocalTime;

public class Clase {
    private int idClase;
    private Entrenador entrenador;
    private LocalTime horario;
    private String nombre;
    private int capacidad;
    private boolean estado;

    public Clase() {
    }

    public Clase(int idClase, Entrenador entrenador, LocalTime horario, String nombre, int capacidad, boolean estado) {
        this.idClase = idClase;
        this.entrenador = entrenador;
        this.horario = horario;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public Clase(Entrenador entrenador, LocalTime horario, String nombre, int capacidad, boolean estado) {
        this.entrenador = entrenador;
        this.horario = horario;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = estado;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }
    
    public int getIdEntrenador() {
        return entrenador.getIdEntrenador();
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Clase{" + "idClase=" + idClase + ", entrenador=" + entrenador + ", horario=" + horario + ", nombre=" + nombre + ", capacidad=" + capacidad + ", estado=" + estado + '}';
    }

}