package edu.utez.mx.Logger.model;

//import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animales")
public class modelAnimales {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;
    private String nombre;
    private String nombreCientifico ;
    private String habitad;
    private String especie;
    private Double peso;
    private String dieta;
    private Integer peligroExtincion;

    public modelAnimales() {
    }

    public modelAnimales(Integer id, String nombre, String nombreCientifico, String habitad, String especie, Double peso, String dieta, Integer peligroExtincion) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.habitad = habitad;
        this.especie = especie;
        this.peso = peso;
        this.dieta = dieta;
        this.peligroExtincion = peligroExtincion;
    }

    public modelAnimales(String nombre, String nombreCientifico, String habitad, String especie, Double peso, String dieta, Integer peligroExtincion) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.habitad = habitad;
        this.especie = especie;
        this.peso = peso;
        this.dieta = dieta;
        this.peligroExtincion = peligroExtincion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getHabitad() {
        return habitad;
    }

    public void setHabitad(String habitad) {
        this.habitad = habitad;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    public Integer getPeligroExtincion() {
        return peligroExtincion;
    }

    public void setPeligroExtincion(Integer peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }


    @Override
    public String toString() {
        return "modelAnimales{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreCientifico='" + nombreCientifico + '\'' +
                ", habitad='" + habitad + '\'' +
                ", especie='" + especie + '\'' +
                ", peso=" + peso +
                ", dieta='" + dieta + '\'' +
                ", peligroExtincion=" + peligroExtincion +
                '}';
    }
}




