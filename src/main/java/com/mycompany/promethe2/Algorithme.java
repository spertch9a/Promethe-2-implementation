/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.promethe2;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DJAWED
 */
public class Algorithme {
    
    
    
    
    
    
    // etape 1
    public static ArrayList normalisation(ArrayList<Telephone> matriceInitiale){
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
    
    
    // etape 3 
    
    // je n'ai pas compris l'ecriture
    
    
    // etape 4
    
    public ArrayList MultipleParPoids(ArrayList Array){
        
        
        return  Array;
    }
    
    // etape5 + etape 6
    
    public ArrayList sommeLignes(ArrayList Array){
        
        // faire la somme des lignes du tableau
        
        
        
        // créer un tableau a travers les sommes
        
        return Array;
    }
    
    
    // etape 7
    
   // etape 8
    
    
    
}
