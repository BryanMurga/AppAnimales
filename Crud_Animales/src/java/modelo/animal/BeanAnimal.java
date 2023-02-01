/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.animal;

/**
 *
 * @author Kenia
 */
public class BeanAnimal {

    private int id;
    private String nombre;
    private String nombreCientifico;
    private String habitad;
    private String especie;
    private double peso;
    private String dieta;
    private byte peligroExtincion;

    public BeanAnimal(int id, String nombre, String nombreCientifico, String habitad, String especie, double peso, String dieta, byte peligroExtincion) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.habitad = habitad;
        this.especie = especie;
        this.peso = peso;
        this.dieta = dieta;
        this.peligroExtincion = peligroExtincion;
    }

    public BeanAnimal(String nombre, String nombreCientifico, String habitad, String especie, double peso, String dieta, byte peligroExtincion) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.habitad = habitad;
        this.especie = especie;
        this.peso = peso;
        this.dieta = dieta;
        this.peligroExtincion = peligroExtincion;
    }

    public BeanAnimal() {
    }

    public byte getPeligroExtincion() {
        return peligroExtincion;
    }

    public void setPeligroExtincion(byte peligroExtincion) {
        this.peligroExtincion = peligroExtincion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }

    
    
    
}
