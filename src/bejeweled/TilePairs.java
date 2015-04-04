/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bejeweled;

/**
 *
 * @author samuel
 */
public class TilePairs {
    Tile a;
    Tile b;

    public TilePairs(Tile a, Tile b){
        this.a=a;
        this.b=b;
    }
    
    public Tile getA() {
        return a;
    }

    public void setA(Tile a) {
        this.a = a;
    }

    public Tile getB() {
        return b;
    }

    public void setB(Tile b) {
        this.b = b;
    }
    
    
    
    
}
