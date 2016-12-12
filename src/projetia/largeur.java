/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author safa
 */
public class largeur {

    Node sommet;
    Vector v;

    public largeur(Node nd) {
        sommet = new Node(nd);
        v = new Vector();
        v.addElement(nd);
    }

    public boolean existeNoeud(Node nd) {
        boolean rst = false;
        Iterator it = v.iterator();
        while (it.hasNext() && !rst) {
            Node noeud = (Node) it.next();
            if ((noeud.isEtatSinge() == nd.isEtatSinge()) && (noeud.getPosSinge() == nd.getPosSinge()) && (noeud.getPosBoite() == nd.getPosBoite()) && (noeud.isEtatBanane()== nd.isEtatBanane())) {
               rst=true; 
            }
        }
        return rst;
    }
    public boolean estEtatBut(Node nd){
        if ((nd.isEtatSinge()==true) && (nd.getPosSinge()=='c') && (nd.getPosBoite()=='c') && (nd.isEtatBanane()==true))
            return true;
        else 
            return false;
        
    }

    public void genererNode(Node nd,boolean testBut) {
        //singe sur le sol
        if (nd.isEtatSinge() == false) {
            if (nd.getPosSinge() == nd.getPosBoite()) {//2cas 
            } //posSinge!= posBoite
            else {//2 possibilités
                //possibilité1:aler à la boite
                //if(nd.posBoite!='c'){
               // nd.allerA(nd.posBoite);
                //possibilté2:aller a l autre position
                

           // }
            }
            //singe sur la boite
        } else {
            //peut attrapper la banane
            if (nd.getPosSinge() == 'c') {

            } //blocage:noeud n'aura plus des noeuds fils
            else {

            }

        }

    }
    public void demarrer(){
        boolean but=false;//on n a pas encore trouvé l etat but
        but=estEtatBut(sommet);
        int index;
        Iterator it = v.iterator();
        while (it.hasNext() && !but) {
            Node nd = (Node) it.next();
            genererNode(nd,but);
            index=v.indexOf(nd)+1;
            nd=(Node) v.get(index);
         }
}}
