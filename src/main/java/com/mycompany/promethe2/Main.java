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

        //étape 1
        ArrayList<Telephone>MatriceNormalisee = Algorithme.normalisation(tableau);
        //étape 2
        ArrayList<Telephone>MatriceDifferences= Algorithme.calculDifference(MatriceNormalisee);
        //étape 3
        ArrayList<Telephone>MatricePreference = Algorithme.calculPreference(MatriceDifferences);
        //étape 4
        ArrayList<Telephone>MatriceMultiplePoids = Algorithme.MultipleParPoids(MatricePreference);
        //étape 5
        ArrayList<Double>Somme=Algorithme.sommeLignes(MatriceMultiplePoids);


        System.out.println(Somme);
        //étape 6
        double[][] MatriceSomme= Algorithme.MatriceSommes(Somme);
        //étape 7
        double[][] Matriceflows= Algorithme.Flows(MatriceSomme);
        //étape 8
        double[]  DifferenceFlows=Algorithme.DifferenceFLows(Matriceflows);
        //étape 9
        double[] SortedArray=Algorithme.sortingResults(DifferenceFlows);

        
    }




    
}
