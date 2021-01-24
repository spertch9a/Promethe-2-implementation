/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.promethe2;

/**
 *
 * @author DJAWED
 */
public class Telephone {
    
    private double prix;
    private double espace;
    private double camera;
    private double look;

    
    
    public Telephone() {
    }

    public Telephone(double prix, double espace, double camera, double look) {
        this.prix = prix;
        this.espace = espace;
        this.camera = camera;
        this.look = look;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public double getEspace() {
        return espace;
    }

    public void setEspace(double espace) {
        this.espace = espace;
    }

    public double getCamera() {
        return camera;
    }

    public void setCamera(double camera) {
        this.camera = camera;
    }

    public double getLook() {
        return look;
    }

    public void setLook(double look) {
        this.look = look;
    }

    @Override
    public String toString() {
        return "Telephone{" + "prix=" + prix + ", espace=" + espace + ", camera=" + camera + ", look=" + look + '}';
    }
    
    
    
    
    
    
    
    
    
    
       
}
