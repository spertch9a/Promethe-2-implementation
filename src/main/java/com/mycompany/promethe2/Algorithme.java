/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.promethe2;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DJAWED
 */
public class Algorithme {
    
    
    
    
    
    
    // etape 1
    public static ArrayList normalisation(ArrayList<Telephone> matriceInitiale){
        System.out.println("Normalisation :");
        ArrayList<Telephone> MatriceNormalise=new ArrayList<>();
        
      
        // chercher le max et le min de chaque colonne
                    // prix
        Telephone telMaxPrix=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getPrix()));
        Telephone telMinPrix=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getPrix()));
        
        double MaxPrix=telMaxPrix.getPrix();
        double MinPrix=telMinPrix.getPrix();
                    //stockage
                    
        Telephone telMaxEspace=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getEspace()));
        Telephone telMinEspace=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getEspace()));
        double MaxEspace=telMaxEspace.getEspace();
        double MinEspace=telMinEspace.getEspace();
        
                    //camera
        Telephone telMaxCamera=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getCamera()));
        Telephone telMinCamera=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getCamera()));
        double MaxCamera=telMaxCamera.getCamera();
        double MinCamera=telMinCamera.getCamera();
                    
                    
                    //look
        Telephone telMaxLook=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getLook()));
        Telephone telMinLook=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getLook()));
        double MaxLook=telMaxLook.getLook();
        double MinLook=telMinLook.getLook();
        
        
        
        
        
        
        //normalisation
        for(int i=0;i<matriceInitiale.size();i++){
            MatriceNormalise.add(new Telephone(abs((MaxPrix-matriceInitiale.get(i).getPrix())/(MaxPrix-MinPrix)),abs((MinEspace-matriceInitiale.get(i).getEspace())/(MaxEspace-MinEspace)),
                    abs((MinCamera-matriceInitiale.get(i).getCamera())/(MaxCamera-MinCamera)),abs((MinLook-matriceInitiale.get(i).getLook())/(MaxLook-MinLook))));
        }
        
        return MatriceNormalise;
    }
    
    
    // etape 2
    public static  ArrayList calculDifference(ArrayList<Telephone> MatriceNormalisee){
        // caluler les differences
        ArrayList<Telephone> MatriceDiffercnes= new ArrayList();
        
        
        for(int i=0;i<MatriceNormalisee.size();i++){
           for(int j=0;j<MatriceNormalisee.size();j++){
             
               if(j!=i){
                       MatriceDiffercnes.add(new Telephone(MatriceNormalisee.get(i).getPrix()-MatriceNormalisee.get(j).getPrix(),
                       MatriceNormalisee.get(i).getEspace()-MatriceNormalisee.get(j).getEspace(),
                       MatriceNormalisee.get(i).getCamera()-MatriceNormalisee.get(j).getCamera(),
                       MatriceNormalisee.get(i).getLook()-MatriceNormalisee.get(j).getLook()));
                   
                        }
               
               
           }
            
            
        }
        return MatriceDiffercnes;
    }
    
    
    // etape 3 remplacer les valeurs négatives par 0 et garder les autres
     public static  ArrayList calculPreference(ArrayList<Telephone> MatriceDiffercnes){
        ArrayList<Telephone> MatricePreference= new ArrayList();
        
         for(int i=0;i<MatriceDiffercnes.size();i++){
           if(MatriceDiffercnes.get(i).getPrix()<0){
            MatriceDiffercnes.get(i).setPrix(0);
           }
           if(MatriceDiffercnes.get(i).getEspace()<0){
             MatriceDiffercnes.get(i).setEspace(0);
           }
           if(MatriceDiffercnes.get(i).getCamera()<0){
            MatriceDiffercnes.get(i).setCamera(0);   
           }
           if(MatriceDiffercnes.get(i).getLook()<0){
            MatriceDiffercnes.get(i).setLook(0); 
           }
          
         }
         MatricePreference=MatriceDiffercnes;
        return MatricePreference;
           }

    // etape 4 Multiplier le tableau par les poids
    
    public static ArrayList MultipleParPoids(ArrayList<Telephone> MatricePreference){
        ArrayList<Telephone> MatriceMultiplePoids= new ArrayList();
        
        //Poids des critéres
        double poidsprix=0.35;
        double poidsespace=0.25;
        double poidscamera=0.25;
        double poidslook=0.15;
        //Multiplier le tableau par les poids
        for(int i=0;i<MatricePreference.size();i++){
           MatriceMultiplePoids.add(new Telephone(MatricePreference.get(i).getPrix()*poidsprix,MatricePreference.get(i).getEspace()*poidsespace,
                   MatricePreference.get(i).getCamera()*poidscamera,MatricePreference.get(i).getLook()*poidslook));
           }
                
        return MatriceMultiplePoids;
    }
    
    // etape5 faire la somme du tableau
    
    public static ArrayList sommeLignes(ArrayList<Telephone> MatriceMultiplePoids){
        ArrayList<Double> somme = new ArrayList();
        // faire la somme des lignes du tableau
        for(int i=0;i<MatriceMultiplePoids.size();i++){
           somme.add(MatriceMultiplePoids.get(i).getPrix()+MatriceMultiplePoids.get(i).getEspace()+
                   MatriceMultiplePoids.get(i).getCamera()+MatriceMultiplePoids.get(i).getLook());
           }
    
        return somme;
    }
    
    //etape 6  créer un tableau a travers les sommes
    public static double[][] MatriceSommes(ArrayList<Double> somme){
        double[][] matrice = new double[5][5];

        int i=0;

            //boucles pour inserer dans la matrice
            for (int y=0;y<4;y++){
                for(int z=0;z<4;z++){
                    if(y!=z){
                        if(i< somme.size()){
                            matrice[y][z]=somme.get(i);
                            i++;
                        }


                    }else{
                        matrice[y][z]=0;
                    }


                }
            }








        return matrice;
    }


    
    // etape 7 calcul du entering et leaving flow

    public  static double[][] Flows(double[][] matriceSomme){
        //flots sortants
        for (int y=0;y<4;y++) {
            double somme=0;
            for (int z = 0; z < 4; z++) {
                somme+=matriceSomme[y][z];

            }
            matriceSomme[y][4]=somme/3;
        }

        //flots entrants
        for (int y=0;y<4;y++) {
            double somme=0;
            for (int z = 0; z < 4; z++) {
                somme+=matriceSomme[z][y];

            }
            matriceSomme[4][y]=somme/3;
        }

        return matriceSomme;
    }
    
   // etape 8  difference entre leaving and entering flow

    public static double[]  DifferenceFLows(double[][] matriceSomme){
        double[] Difference= new double[4];


            for (int i=0;i<4;i++){
                Difference[i]=matriceSomme[i][4]- matriceSomme[4][i];

                System.out.println("Telephone "+i+" "+Difference[i]);
            }






        return Difference;
    }


    //étape N° 9 trier les resultats

    public static double[] sortingResults(double[] results){

        Arrays.sort(results);
        System.out.println("Le télephone le  plus adéquat est: ");
        for (int i= results.length-1 ;i>=0;i--){
            System.out.println("Télephone"+i+" valeur: "+results[i]);
        }


        return results;


    }


    
    
    
}
