package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Estudiante {
    @Id // especificar que es llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // el id va en incremento
    private Long codigo;
    private String nombre;
    private String telefono;

    public Estudiante() {
    }

    public Estudiante(Long codigo, String nombre, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    @Override
    public String toString() {
        return "Estudiante{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}