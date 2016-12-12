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

    char posSinge;
    boolean etatSinge;
    char posBoite;
    boolean etatBanane;
    char posBanane;
    boolean etatNoeud;//exploité ou ps
    int niveau;//pour assurer le developpement de tout les noeuds avant le passage a un autre niveau

    Node(char a, char b, char c) {
        posSinge = a;
        etatSinge = false;
        posBoite = b;
        etatBanane = false;
        posBanane = c;
        etatNoeud=false;
        niveau=0;
        
    }

    public void allerA(char d) {
        if ((etatSinge == false) && (posSinge != d)) {//singe au sol 
            posSinge = d;
        } else {
            System.out.println("Action non permise!");//on peut les transformer en exceptions ulterieurement
        }
    }

    public void pousser(char d) {
        if ((etatSinge == false) && (posSinge != d) && (posSinge == posBoite)) {
            posSinge = d;
            posBoite = d;
        } else {
            System.out.println("Action non permise!");//on peut les transformer en exceptions ultirieurement
        }
    }

    public void grimper() {
        if ((etatSinge == false) && (posSinge == posBoite)) {
            etatSinge = true;
        }
    }

    public void attraper() {
        if ((etatSinge == true) && (etatBanane == false) && (posSinge == posBoite)) {
            etatBanane = true;
        } else {
            System.out.println("Action non permise!");//on peut les transformer en exceptions ultirieurement
        }
    }

    public void genererNode() {
        //singe sur le sol
        if (etatSinge == false) {
            if (posSinge == posBoite) {//2cas 
            }
            //posSinge!= posBoite
            else {//2 possibilités
                //possibilité1:aler à la boite
                allerA(posBoite);
                //possibilté2:aller a l autre position
                
            }
            
            
        //singe sur la boite
        } else {
            //peut attrapper la banane
            if(posSinge==posBanane){
                
            }
            //blocage:noeud n'aura plus des noeuds fils
            else{
                
            }

        }

    }
}
