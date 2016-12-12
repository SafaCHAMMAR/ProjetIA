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
public class ProjetIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Node nd=new Node('a','b');
        largeur lg=new largeur(nd);
        lg.demarrer();
        
    }
    
}
