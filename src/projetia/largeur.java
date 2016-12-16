/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javafx.scene.shape.VertexFormat;

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
        //Iterator it = v.iterator();
       // System.out.println("----NOEUD A VERIFIER L EXISTENCE");
       // System.out.println("("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
        Enumeration<Node> elmnt1 = v.elements();
        //System.out.println("les elmnts du vector");
        while (elmnt1.hasMoreElements() && !rst) {
            Node noeud = (Node) elmnt1.nextElement();
           // System.out.println("("+noeud.getPosSinge()+","+noeud.isEtatSinge()+","+noeud.getPosBoite()+","+nd.isEtatBanane()+")");
            if ((noeud.isEtatSinge() == nd.isEtatSinge()) && (noeud.getPosSinge() == nd.getPosSinge()) && (noeud.getPosBoite() == nd.getPosBoite()) && (noeud.isEtatBanane() == nd.isEtatBanane())) {
                rst = true;}//System.out.println("EXISTE");}
      
            }
        return rst;
    }

    public boolean estEtatBut(Node nd) {
        if ((nd.isEtatSinge() == true) && (nd.getPosSinge() == 'c') && (nd.getPosBoite() == 'c') && (nd.isEtatBanane() == true)) {
            return true;
        } else {
            return false;
        }

    }

    public void genererNode(Node nd) {
        //singe sur le sol
        if (nd.isEtatSinge() == false) {
            if (nd.getPosSinge() == nd.getPosBoite()) {
                if (nd.getPosBoite() == 'c') { //(c,0,c,0)
                    Node noeud = nd.grimper();
                    ajoutNoeud(noeud);
                    Node noeud2 = nd.allerA('a');
                    ajoutNoeud(noeud2);
                    Node noeud3 = nd.allerA('b');
                    ajoutNoeud(noeud3);
                } //posSinge== posBoite
                else if (nd.getPosBoite() == 'b') {//(b,0,b,0)
                    Node noeud = nd.grimper();
                    ajoutNoeud(noeud);
                    Node noeud2 = nd.allerA('a');
                    ajoutNoeud(noeud2);
                    Node noeud3 = nd.allerA('c');
                    ajoutNoeud(noeud3);
                    Node noeud4 = nd.pousser('c');
                    ajoutNoeud(noeud4);
                    Node noeud5 = nd.pousser('a');
                    ajoutNoeud(noeud5);
                } else {//(a,0,a,0)
                    Node noeud1=nd.pousser('c');
                    Node noeud2=nd.pousser('b');
                    Node noeud3=nd.allerA('c');
                    Node noeud4=nd.allerA('b');
                    Node noeud5=nd.grimper();
                    ajoutNoeud(noeud1);
                    ajoutNoeud(noeud2);
                    ajoutNoeud(noeud3);
                    ajoutNoeud(noeud4);
                    ajoutNoeud(noeud5);
                    }
            }
            //posSinge!=posBoite && singe sur le sol
        else {
                if(nd.getPosBoite()=='c'){//(x,0,c,0)
                    Node noeud1=nd.allerA('c');
                    ajoutNoeud(noeud1);
                    if(nd.getPosSinge()=='a'){//(a,0,c,0)
                        Node noeud2=nd.allerA('b');
                        ajoutNoeud(noeud2);}
                    else {//(b,0,c,0)
                        Node noeud3=nd.allerA('a');
                        ajoutNoeud(noeud3);
                         }
                    
                }
                else if(nd.getPosBoite()=='a'){//(x,0,a,0)
                    if(nd.getPosSinge()=='b'){//(b,0,a,0)
                     Node noeud1=nd.allerA('a');
                        ajoutNoeud(noeud1);
                     Node noeud2=nd.allerA('c');
                        ajoutNoeud(noeud2);
                    }
                    else {//(c,0,a,0)
                        Node noeud1=nd.allerA('a');
                        ajoutNoeud(noeud1);
                        Node noeud2=nd.allerA('b');
                        ajoutNoeud(noeud2);
                         }
                    }
                else{//(x,0,b,0)
                   Node noeud1=nd.allerA('b');
                    ajoutNoeud(noeud1);
                    if(nd.getPosSinge()=='a'){//(a,0,b,0)
                        Node noeud2=nd.allerA('c');
                        ajoutNoeud(noeud2);}
                    else {//(c,0,b,0)
                        Node noeud3=nd.allerA('a');
                        ajoutNoeud(noeud3);
                         }
                    }
            }
        }
        else{//singe sur la boite(x,1,x,0)
            if(nd.getPosBoite()=='c'){
                Node noeud1=nd.attraper();
                ajoutNoeud(noeud1);
            }
            else {nd.setSterilisé(true);
            System.out.println("!!!!!!!!!!!!!!!!!noeud sterilisé  "+"("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
            }
            
        }
            
    }

    public void ajoutNoeud(Node nd) {
        if (!existeNoeud(nd)) {
            v.addElement(nd);
            System.out.println("noeud generée"+"("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
        }
    }

    public void demarrer() {
        boolean but = false;//on n a pas encore trouvé l etat but
        but = estEtatBut(sommet);
        int index;
        Node nd=sommet;
       //System.out.println("sommet :("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
        //Iterator it = v.iterator();
        Enumeration<Node> elmnt = v.elements();
       /*while (it.hasNext() && !estEtatBut(nd) && !nd.isSterilisé()) {
            Node nd1 = (Node) it.next();*/
        while(elmnt.hasMoreElements() && !estEtatBut(nd) /*&& !nd.isSterilisé()*/){
            Node nd1 = (Node)elmnt.nextElement();
            if(!estEtatBut(nd1)){
            System.out.print("*****NOEUD A EXPLOITER:");
              System.out.println("("+nd1.getPosSinge()+","+nd1.isEtatSinge()+","+nd1.getPosBoite()+","+nd1.isEtatBanane()+")");
              if(!nd1.isSterilisé()&& !estEtatBut(nd1))
              genererNode(nd1);
            //index = v.indexOf(nd) + 1;
            nd =nd1;//= (Node) v.get(index);
            System.out.println("taille de vector "+v.size());
            }
            else { System.out.println("("+nd1.getPosSinge()+","+nd1.isEtatSinge()+","+nd1.getPosBoite()+","+nd1.isEtatBanane()+")");
                System.out.println("On a atteint l'etat but!!"+"("+nd1.getPosSinge()+","+nd1.isEtatSinge()+","+nd1.getPosBoite()+","+nd1.isEtatBanane()+")");
            }
            
        }
        System.out.println("terminéééé!!!");
    }
}
