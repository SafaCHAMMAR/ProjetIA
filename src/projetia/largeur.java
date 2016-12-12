/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

/**
 *
 * @author safa
 */
public class largeur {
    Node sommet;
    public largeur(Node nd){
     sommet=new Node(nd);
    }
    
    public void genererNode(Node nd) {
        //singe sur le sol
        if (nd.etatSinge == false) {
            if (nd.posSinge == nd.posBoite) {//2cas 
            }
            //posSinge!= posBoite
            else {//2 possibilités
                //possibilité1:aler à la boite
                nd.allerA(nd.posBoite);
                //possibilté2:aller a l autre position
                
            }
            
            
        //singe sur la boite
        } else {
            //peut attrapper la banane
            if(nd.posSinge=='c'){
                
            }
            //blocage:noeud n'aura plus des noeuds fils
            else{
                
            }

        }

    }
}
