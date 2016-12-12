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

    private char posSinge;
    private boolean etatSinge;
    private char posBoite;
    private boolean etatBanane;
    private boolean etatNoeud;//exploité ou ps
    private int niveau;//pour assurer le developpement de tout les noeuds avant le passage a un autre niveau
    private int h;//fonction heuristique
    Node(char a, char b) {
        posSinge = a;
        etatSinge = false;
        posBoite = b;
        etatBanane = false;
        etatNoeud=false;
        niveau=0;  
        h=4;
    }
    Node(Node nd){
        posSinge=nd.posSinge;
        posBoite=nd.posBoite;
        etatBanane=nd.etatBanane;
        etatSinge=nd.etatSinge;
       
        etatNoeud=nd.etatNoeud;
        niveau=nd.niveau;       
    }
    public char getPosSinge() {
        return posSinge;
    }

    public void setPosSinge(char posSinge) {
        this.posSinge = posSinge;
    }

    public boolean isEtatSinge() {
        return etatSinge;
    }

    public void setEtatSinge(boolean etatSinge) {
        this.etatSinge = etatSinge;
    }

    public char getPosBoite() {
        return posBoite;
    }

    public void setPosBoite(char posBoite) {
        this.posBoite = posBoite;
    }

    public boolean isEtatBanane() {
        return etatBanane;
    }

    public void setEtatBanane(boolean etatBanane) {
        this.etatBanane = etatBanane;
    }

    public boolean isEtatNoeud() {
        return etatNoeud;
    }

    public void setEtatNoeud(boolean etatNoeud) {
        this.etatNoeud = etatNoeud;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Node allerA(char d) {
        Node n=null;
        if ((etatSinge == false) && (posSinge != d)) {//singe au sol
            n=new Node(this);            
            n.setPosSinge(d);
        } else {
            System.out.println("Action non permise!");//on peut les transformer en exceptions ulterieurement
        }
        return n;
    }

    public Node pousser(char d) {
        //if ((etatSinge == false) && (posSinge != d) && (posSinge == posBoite)) {
            Node n=new Node(this);
            n.setPosSinge(d);
            n.setPosBoite(d);
            n.setNiveau(getNiveau()+1);
        return n;
    }
    public Node grimper() {        
        //if ((etatSinge == false) && (posSinge == posBoite)) {
            Node n=new Node(this);
            n.setEtatSinge(true);
            n.setNiveau(getNiveau()+1);
        return n;
    }

    public Node attraper() {
        //if ((etatSinge == true) && (etatBanane == false) && (posSinge == posBoite)) {
            Node n=new Node(this);
            n.setEtatBanane(true);
            n.setNiveau(getNiveau()+1);
            return n;
    }
}
