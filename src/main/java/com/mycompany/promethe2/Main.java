/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.promethe2;

import java.util.ArrayList;

/**
 *
 * @author DJAWED
 */
public class Main {
    
    
    
    
    public static void main(String[] args) {
     
        ArrayList<Telephone> tableau= new ArrayList<>();
        
        tableau.add(new Telephone(250,16,12,5));
        tableau.add(new Telephone(200,16,8,3));
        tableau.add(new Telephone(300,32,16,4));
        tableau.add(new Telephone(275,32,8,2));
        
        ArrayList<Telephone>tel = Algorithme.normalisation(tableau);
        
 
        
        
    }
    
}
