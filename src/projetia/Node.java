/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

/**
 *
 * @author zaineb
 */
public class Node {
    int posSinge;
    boolean etatSinge;
    int posBoite;
    boolean etatBanane;
    
    Node(int a,int b){
        posSinge=a;
        etatSinge=false;
        posBoite=b;
        etatBanane=false;
    }
    public void allerA(int u){
        if(etatSinge==false&& posSinge!=u){
            posSinge=u;            
        }
        else{
            System.out.println("Action non permise!");//on peut les transformer en exceptions ultirieurement
        }
    }    
    public void pousser(int u){
        if(etatSinge==false&& posSinge!=u && posSinge==posBoite){
            posSinge=u;
            posBoite=u;
        }
        else{
            System.out.println("Action non permise!");//on peut les transformer en exceptions ultirieurement
        }
    } 
    public void grimper(){
     if(etatSinge==false&& posSinge==posBoite) {
         etatSinge=true;
     }  
    }
    public void attraper(){
        if(etatSinge==true&& etatBanane==false&& posSinge==posBoite){
            etatBanane=true;
        }
         else{
            System.out.println("Action non permise!");//on peut les transformer en exceptions ultirieurement
        }
    }
}
