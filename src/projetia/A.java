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
        debut.setVisited(true);//visited
        noeudsGeneres.add(debut);
        noeudBut(c);
    }   
    public A(){
        noeudsGeneres=new Vector<Node>();
        debut =new Node('a','b');
        debut.setVisited(false);//not visited
        noeudsGeneres.add(debut);
        //System.out.println(debut.getF());        
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
    public int calculerF(Node n){
        int h = 4;
        int niveau=n.getNiveau();
        int f=0;
        if(n.getPosSinge()==but.getPosSinge())
            h--;
        if (n.getPosBoite()==but.getPosBoite())
            h--;
        if(n.isEtatSinge()==but.isEtatSinge())
            h--;
        if(n.isEtatBanane()==but.isEtatBanane())
            h--;
        f=h+niveau;
        return f;
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
                        ajoutNoeud(noeud2,v,nd);
                    }
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
            //System.out.println("!!!!!!!!!!!!!!!!!noeud sterilisé  "+"("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
            }
                    }
               return v;
    }     
        public void ajoutNoeud(Node nd,Vector v,Node pere) {//y inclus calcul de h 
            int h=4;
        if (!pere.compareTo(nd)) { 
                nd.setH(calculerH(nd));
                nd.setF(calculerF(nd));
                if(existeNoeud(nd)){
                    nd.setSterilisé(true);
                }
            v.addElement(nd);
        }
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
         
            public boolean existeNoeud(Node nd) {
        boolean rst = false;
        //Iterator it = v.iterator();
       // System.out.println("----NOEUD A VERIFIER L EXISTENCE");
        //System.out.println("("+nd.getPosSinge()+","+nd.isEtatSinge()+","+nd.getPosBoite()+","+nd.isEtatBanane()+")");
        Enumeration<Node> elmnt1 = noeudsGeneres.elements();
        //System.out.println("les elmnts du vector");
        while (elmnt1.hasMoreElements() && !rst) {
            Node noeud = (Node) elmnt1.nextElement();
           // System.out.println("("+noeud.getPosSinge()+","+noeud.isEtatSinge()+","+noeud.getPosBoite()+","+nd.isEtatBanane()+")");
            if ((noeud.isEtatSinge() == nd.isEtatSinge()) && (noeud.getPosSinge() == nd.getPosSinge()) && (noeud.getPosBoite() == nd.getPosBoite()) && (noeud.isEtatBanane() == nd.isEtatBanane())) {
                {rst = true;
                //System.out.println("EXISTE");
                }
            }
        }
        return rst;
    }   
             public int getIndexInf(Node noeudCourante){//retourne l'indexe de lui mm si il y'en a pas
                int f=0;
                //System.out.println(noeudCourante.isVisited());
                int indexInf = noeudsGeneres.indexOf(noeudCourante);
                Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                boolean stop=false;
                while (elmnt1.hasMoreElements()&&!stop) {
                Node v = (Node) elmnt1.nextElement();
                if(!v.isSterilisé()&&!v.isVisited()){         
                            f=v.getF();
                            stop=true;
                            indexInf=noeudsGeneres.indexOf(v);
                            //System.out.println("here("+v.getPosSinge()+","+v.isEtatSinge()+","+v.getPosBoite()+","+v.isEtatBanane()+")+ niveau= "+v.getNiveau()+" f="+v.getF()+"visited=>"+v.isVisited());                    
                }
                }
                while (elmnt1.hasMoreElements()) {
                Node v = (Node) elmnt1.nextElement();
                if(!v.isSterilisé()&&!v.isVisited()&&v.getF()<f){         
                            f=v.getF();
                            indexInf=noeudsGeneres.indexOf(v);
                            //System.out.println("here("+v.getPosSinge()+","+v.isEtatSinge()+","+v.getPosBoite()+","+v.isEtatBanane()+")+ niveau= "+v.getNiveau()+" f="+v.getF()+"visited=>"+v.isVisited());                    
                }
                }
                     //System.out.println("indexxxxx"+indexInf);
                return indexInf;
            }
            public void demarrer(){
        int niveau=0;
        Vector v=new Vector<Node>();
        v = genererFils(debut);//visited true, niveau 0, ceux qui sont generé visited false, niveau 1
        noeudsGeneres.addAll(v);
        //System.out.println(v.size());
        debut.setVisited(true);
        int indexFilsInf=getIndexInf(debut);
                while (!((Node)noeudsGeneres.get(indexFilsInf)).compareTo(but)){
                            v.removeAllElements();
                            v=genererFils((Node)noeudsGeneres.get(indexFilsInf));
                            noeudsGeneres.addAll(v);
                            ((Node)noeudsGeneres.get(indexFilsInf)).setVisited(true);
                            indexFilsInf=getIndexInf((Node)noeudsGeneres.get(indexFilsInf));
            }
                   if(stopRecherche()){
                   System.out.println("Pas de solutions");
               }
               else{
                   int indexBut=noeudsGeneres.size()-1;
                   Node NodeBut=(Node)noeudsGeneres.elementAt(indexBut);
                    System.out.println("Solution trouvée: "+"("+NodeBut.getPosSinge()+","+NodeBut.isEtatSinge()+","+NodeBut.getPosBoite()+","+NodeBut.isEtatBanane()+")");
               }
            }
                        public boolean stopRecherche(){
                boolean stop=true;
             Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                while (elmnt1.hasMoreElements()) {
                Node v = (Node) elmnt1.nextElement();
                if(!v.isSterilisé()&&!v.isVisited()){  
                    stop=false;
                }   
            }
                return stop;
            }
    public void afficherNoeudsGeneres(){
        System.out.println(noeudsGeneres.size()+" Noeuds sont Générés:");
        Enumeration<Node> elmnt1 = noeudsGeneres.elements();
                while (elmnt1.hasMoreElements()) {
                    Node v=elmnt1.nextElement();
              System.out.println(noeudsGeneres.indexOf(v)+": ("+v.getPosSinge()+","+v.isEtatSinge()+","+v.getPosBoite()+","+v.isEtatBanane()+") niveau= "+v.getNiveau()+" f="+v.getF()+" visited=>"+v.isVisited()+" sterilisé=>"+v.isSterilisé());                    
                }
    }
}
