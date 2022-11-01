/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4.Modelo;

/**
 *
 * @author Serrperry
 */
public class Filtro {
    private int posicion;
    private String filtrar;

    public Filtro(int posicion, String filtrar) {
        this.posicion = posicion;
        this.filtrar = filtrar;
    }

    public Filtro() {
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getFiltrar() {
        return filtrar;
    }

    public void setFiltrar(String filtrar) {
        this.filtrar = filtrar;
    }
    
}
