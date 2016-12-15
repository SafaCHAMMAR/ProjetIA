package projetia;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class A {
    private Node debut;
    private Node but;
    private Vector noeudsGeneres=new Vector<Node>();;
    
    public A(char a,char b, char c){
        noeudsGeneres=new Vector<Node>();
        debut =new Node(a,b);
        debut.setVisited(false);//visited
        noeudsGeneres.add(debut);        
        noeudBut(c);
    }   
    public A(){
        noeudsGeneres=new Vector<Node>();
        debut =new Node('a','b');
        debut.setVisited(false);//not visited
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
    
    public Vector genererFils(Node nd){
        Vector v =new Vector<Node>();
               if (nd.isEtatSinge() == false) {
            if (nd.getPosSinge() == nd.getPosBoite()) {
                if (nd.getPosBoite() == 'c') { //(c,0,c,0)
                    Node noeud = nd.grimper();
                    ajoutNoeud(noeud,v,nd);
                    Node noeud2 = nd.allerA('a');
                    ajoutNoeud(noeud2,v,nd);
                    Node noeud3 = nd.allerA('b');
                    ajoutNoeud(noeud3,v,nd);
                } //posSinge== posBoite
                else if (nd.getPosBoite() == 'b') {//(b,0,b,0)
                    Node noeud = nd.grimper();
                    ajoutNoeud(noeud,v,nd);
                    Node noeud2 = nd.allerA('a');
                    ajoutNoeud(noeud2,v,nd);
                    Node noeud3 = nd.allerA('c');
                    ajoutNoeud(noeud3,v,nd);
                    Node noeud4 = nd.pousser('c');
                    ajoutNoeud(noeud4,v,nd);
                    Node noeud5 = nd.pousser('a');
                    ajoutNoeud(noeud5,v,nd);
                } else {//(a,0,a,0)
                    Node noeud1=nd.pousser('c');
                    Node noeud2=nd.pousser('b');
                    Node noeud3=nd.allerA('c');
                    Node noeud4=nd.allerA('b');
                    ajoutNoeud(noeud1,v,nd);
                    ajoutNoeud(noeud2,v,nd);
                    ajoutNoeud(noeud3,v,nd);
                    ajoutNoeud(noeud4,v,nd);
                    }
            }
            //posSinge!=posBoite && singe sur le sol
        else {
                if(nd.getPosBoite()=='c'){//(x,0,c,0)
                    Node noeud1=nd.allerA('c');
                    ajoutNoeud(noeud1,v,nd);
                    if(nd.getPosSinge()=='a'){//(a,0,c,0)
                        Node noeud2=nd.allerA('b');
                        ajoutNoeud(noeud2,v,nd);}
                    else {//(b,0,c,0)
                        Node noeud3=nd.allerA('a');
                        ajoutNoeud(noeud3,v,nd);
                         }                    
                }
                else if(nd.getPosBoite()=='a'){//(x,0,a,0)
                    if(nd.getPosSinge()=='b'){//(b,0,a,0)
                     Node noeud1=nd.allerA('a');
                        ajoutNoeud(noeud1,v,nd);
                     Node noeud2=nd.allerA('c');
                        ajoutNoeud(noeud2,v,nd);
                    }
                    else {//(c,0,a,0)
                        Node noeud1=nd.allerA('a');
                        ajoutNoeud(noeud1,v,nd);
                        Node noeud2=nd.allerA('b');
                        ajoutNoeud(noeud2,v,nd);
                         }
                    }
                else{//(x,0,b,0)
                   Node noeud1=nd.allerA('b');
                    ajoutNoeud(noeud1,v,nd);
                    if(nd.getPosSinge()=='a'){//(a,0,b,0)
                        Node noeud2=nd.allerA('c');
                        ajoutNoeud(noeud2,v,nd);}
                    else {//(c,0,b,0)
                        Node noeud3=nd.allerA('a');
                        ajoutNoeud(noeud3,v,nd);
                         }
                    }
            }
        }
        else{//singe sur la boite(x,1,x,0)
            if(nd.getPosBoite()=='c'){
                Node noeud1=nd.attraper();
                ajoutNoeud(noeud1,v,nd);
            }
            else {nd.setSterilisé(true);
            System.out.println("!!!!!!!!!!!!!!!!!noeud sterilisé  "+"("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
            }
                    }
               return v;
    }     
        public void ajoutNoeud(Node nd,Vector v,Node pere) {//y inclus calcul de h 
            int h=4;
        if (!existeNoeud(nd,v)&&!pere.compareTo(nd)) {            
                nd.setH(calculerH(nd));
            v.addElement(nd);
        }
    }
            public boolean existeNoeud(Node nd,Vector v) {
        boolean rst = false;
        //Iterator it = v.iterator();
       // System.out.println("----NOEUD A VERIFIER L EXISTENCE");
        //System.out.println("("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
        Enumeration<Node> elmnt1 = v.elements();
        //System.out.println("les elmnts du vector");
        while (elmnt1.hasMoreElements() && !rst) {
            Node noeud = (Node) elmnt1.nextElement();
           // System.out.println("("+noeud.getPosSinge()+","+noeud.isEtatSinge()+","+noeud.getPosBoite()+","+nd.isEtatBanane()+")");
            if ((noeud.isEtatSinge() == nd.isEtatSinge()) && (noeud.getPosSinge() == nd.getPosSinge()) && (noeud.getPosBoite() == nd.getPosBoite()) && (noeud.isEtatBanane() == nd.isEtatBanane())) {
                {rst = true;System.out.println("EXISTE");}
            }
        }
        return rst;
    }
            public int getIndexFilsInf(Node noeudCourante){
                int niveau=noeudCourante.getNiveau();
                int hmin=noeudCourante.getH();
                int indexFilsInf = 0;
                Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                while (elmnt1.hasMoreElements()) {
                Node noeud = (Node) elmnt1.nextElement();
                if(noeud.getNiveau()==niveau+1 &&!noeud.isVisited()&& noeud.getH()<hmin){
                    hmin=noeud.getH();
                    //System.out.println("********"+hmin);

                    indexFilsInf=noeudsGeneres.indexOf(noeud);
                }
                else indexFilsInf=noeudsGeneres.indexOf(noeudCourante);
                }
                return indexFilsInf;
            }            
            public int getIndexFrereInf(Node noeudCourante){//retourne l'indexe de lui mm si il y'en a pas
                int niveau=noeudCourante.getNiveau();
                int hmin=noeudCourante.getH();
                int indexFrerInf = 0;
                Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                while (elmnt1.hasMoreElements()) {
                Node noeud = (Node) elmnt1.nextElement();
                if(noeud.getNiveau()==niveau && !noeud.isVisited()&& noeud.getH()<hmin){
                    hmin=noeud.getH();
                    indexFrerInf=noeudsGeneres.indexOf(elmnt1);
                }
                else indexFrerInf=noeudsGeneres.indexOf(noeudCourante);
                }
                return indexFrerInf;
            }
    
    public void demarrer(){
        int niveau=0;
        Vector v=new Vector<Node>();
        v = genererFils(debut);//visited true, niveau 0, ceux qui sont generé visited false, niveau 1
        noeudsGeneres.addAll(v);
        debut.setVisited(true);
        int indexFilsInf=getIndexFilsInf(debut);//fils ayant le min de h
        //System.out.println("index==> "+indexFilsInf);
        //System.out.println("("+ ((Node)noeudsGeneres.get(indexFilsInf)).getPosSinge()+","+ ((Node)noeudsGeneres.get(indexFilsInf)).isEtatSinge()+","+ ((Node)noeudsGeneres.get(indexFilsInf)).getPosBoite()+","+ ((Node)noeudsGeneres.get(indexFilsInf)).isEtatBanane()+")");

        ((Node)noeudsGeneres.get(indexFilsInf)).setVisited(true);
        int indexFrereInf = 0;
        boolean stop=false;
        int indexPere; 
        while(((Node)noeudsGeneres.get(indexFilsInf)).getH()!=0 &&!stop){
            v=genererFils((Node)noeudsGeneres.get(indexFilsInf));
            noeudsGeneres.addAll(v);
            
            indexPere=indexFilsInf;
            indexFilsInf=getIndexFilsInf((Node)noeudsGeneres.get(indexPere));
            v.removeAllElements();        
            if (indexFilsInf==indexPere){
                indexFrereInf=getIndexFrereInf((Node)noeudsGeneres.get(indexPere));
                if(indexFrereInf==indexPere){
                    stop=true;
                    System.out.println("pas de solutions!");
                }                
                else{
                    ((Node)noeudsGeneres.get(indexPere)).setVisited(true);
                    indexPere=indexFrereInf;
                    indexFilsInf=getIndexFilsInf((Node)noeudsGeneres.get(indexPere));
                }
            }
            else{
                indexPere=indexFilsInf;
                indexFilsInf=getIndexFilsInf((Node)noeudsGeneres.get(indexPere));
            }
        }
      } 
    public void showVisited(){
        System.out.println(noeudsGeneres.size()+"Noeuds sont Générés:");
        Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                while (elmnt1.hasMoreElements()) {
                    Node v=elmnt1.nextElement();
              System.out.println("("+v.getPosSinge()+","+v.isEtatSinge()+","+v.getPosBoite()+","+v.isEtatBanane()+")+ niveau= "+v.getNiveau()+" h="+v.getH());                    
                }
    }
}
