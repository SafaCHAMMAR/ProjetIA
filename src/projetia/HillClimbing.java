/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetia;

import java.util.ArrayList;

/**
 *
 * @author zaineb
 */
public class HillClimbing {
    private Node ed;
    private Node eb;
    private ArrayList NoeudsGeneres;
    
    public HillClimbing(char a,char b, char c){
        NoeudsGeneres=new ArrayList<Node>();
        ed.setPosSinge(a);
        ed.setPosBoite(b);
        ed.setEtatSinge(false);
        ed.setEtatBanane(false);
        eb.setPosSinge(c);
        eb.setPosBoite(c);
        eb.setEtatSinge(false);
        eb.setEtatBanane(false);
    }
}
