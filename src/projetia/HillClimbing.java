package projetia;
import java.util.ArrayList;

public class HillClimbing {
    private Node debut;
    private Node but;
    private ArrayList noeudsGeneres;
    
    public HillClimbing(char a,char b, char c){
        noeudsGeneres=new ArrayList<Node>();
        debut =new Node(a,b);
        debut.setEtatNoeud(true);//visited
        noeudsGeneres.add(debut);        
        genererNoeudBut(c);
    }   
    public HillClimbing(){
        noeudsGeneres=new ArrayList<Node>();
        debut =new Node('a','b');
        debut.setEtatNoeud(true);//visited
        noeudsGeneres.add(debut);        
        genererNoeudBut('c');
    }
    public void genererNoeudBut(char c){
        but.setPosSinge(c);
        but.setPosBoite(c);
        but.setEtatSinge(true);
        but.setEtatBanane(true);
        but.setH(0);
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
}
