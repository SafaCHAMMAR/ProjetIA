package projetia;
import java.util.ArrayList;

public class HillClimbing {
    private Node debut;
    private Node but;
    private ArrayList noeudsGeneres;
    
    public HillClimbing(char a,char b, char c){
        noeudsGeneres=new ArrayList<Node>();
        debut =new Node(a,b);
        debut.setVisited(true);//visited
        noeudsGeneres.add(debut);        
        noeudBut(c);
    }   
    public HillClimbing(){
        noeudsGeneres=new ArrayList<Node>();
        debut =new Node('a','b');
        debut.setVisited(true);//visited
        noeudsGeneres.add(debut);        
        but=noeudBut('c');
    }
    public Node noeudBut(char c){
        Node n=new Node(c,c);        
        n.setEtatSinge(true);
        n.setEtatBanane(true);
        n.setH(0);
        n.setNiveau(100);
        return n;
    }
    public int calculerH(Node n){
        int h = 4;
        if(n.getPosSinge()==but.getPosSinge())
            h--;
        if (n.getPosBoite()==but.getPosBoite())
            h--;
        if(n.isEtatSinge()==but.isEtatSinge())
            h--;
        if(n.isEtatBanane()==but.isEtatBanane())
            h--;
        return h;
    }
    
    public ArrayList genererFils(Node n){
       return new ArrayList();// pour eviter l'erreur :p :p 
    }
    public void demarrer(){
        int niveau=0;
        while(but.isVisited()==true){
            
        }
    }
}
