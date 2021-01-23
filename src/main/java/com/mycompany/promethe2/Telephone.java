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
    
    private int prix;
    private int espace;
    private int camera;
    private int look;

    public Telephone() {
    }
    
    

    public Telephone(int prix, int espace, int camera, int look) {
        this.prix = prix;
        this.espace = espace;
        this.camera = camera;
        this.look = look;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getEspace() {
        return espace;
    }

    public void setEspace(int espace) {
        this.espace = espace;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getLook() {
        return look;
    }

    public void setLook(int look) {
        this.look = look;
    }
    
    
    
    
}
