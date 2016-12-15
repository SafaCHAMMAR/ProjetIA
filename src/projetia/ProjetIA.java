package projetia;

public class ProjetIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("---------------------Hill Climbing---------------------");
        HillClimbing hl=new HillClimbing();
        hl.demarrer();
        hl.showVisited();
        System.out.println("\n----------------Hill Climbing MINORANT-----------------");
        HillClimbingMinorant lg=new HillClimbingMinorant();
        lg.demarrer();
        lg.showVisited();
        System.out.println("\n-------------------------A*----------------------------");
        A a=new A();
        a.demarrer();
        a.showVisited();
        /*Node nd=new Node('a','b');
        Node nd2=new Node('a','b');
        System.out.println(nd.compareTo(nd2));*/
        
    }
    
}
