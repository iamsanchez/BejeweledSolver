/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bejeweled;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class Solver {

    private Game g;
    private ArrayList<TilePairs> horizontales = new ArrayList();

    public Solver() {

    }

    static int scoreH(TilePairs jugables, Board b) {
        Tile original, nuevo;
        nuevo = jugables.a;
        original = jugables.b;
        int contador = 1;

        for (int i = original.col + 1; i < 8; i++) {
            //System.out.println("soy" + original.row+","+i);
            if (b.getTileAt(original.row, i).id == nuevo.id) {
                contador++;
            } else {
                break;
            }
        }
        for (int i = original.col - 1; i >= 0; i--) {
            if (b.getTileAt(original.row, i).id == nuevo.id) {
                //System.out.println("tambien" + original.row+","+i);
                contador++;
            } else {
                break;
            }
        }
        if (original.col + 1 == nuevo.col || original.col - 1 == nuevo.col) {
            contador--;
        }

        return contador;
    }

    static int scoreV(TilePairs jugables, Board b) {
        int contador;
        Tile nuevo, original;
        nuevo = jugables.a;
        original = jugables.b;
        contador = 1;
        for (int i = original.row + 1; i < 8; i++) {
           //System.out.println("soy" + original.row+","+i);

            if (b.getTileAt(i, original.col).id == nuevo.id) {
                contador++;
            } else {
                break;
            }
        }
        for (int i = original.row - 1; i >= 0; i--) {

            if (b.getTileAt(i, original.col).id == nuevo.id) {
                //System.out.println("tambien" + original.row+","+i);
                contador++;
            } else {
                break;
            }
        }

        if (original.row + 1 == nuevo.row || original.row - 1 == nuevo.row) {
            contador--;
        }

        return contador;
    }

    static ArrayList<TilePairs> jugablesH(ArrayList<TilePairs> jugables, Board b) {
        int row, col;
        ArrayList<TilePairs> movimientos = new ArrayList();
        for (TilePairs jugable : jugables) {
            row = jugable.a.row; //logica para el de la izquierda
            col = jugable.a.col - 1;
            if ((col >= 0)) {
                if (row != 0) { // si estoy arriba
                    if (b.getTileAt(row - 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row - 1, col), b.getTileAt(row, col)));
                    }
                }
                if (col != 0) { //si estoy a lo mas izquierda
                    if (b.getTileAt(row, col - 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col - 1), b.getTileAt(row, col)));
                    }
                }
                if (row != 7) { //si estoy abajo
                    if (b.getTileAt(row + 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row + 1, col), b.getTileAt(row, col)));
                    }
                }
            }

            row = jugable.b.row; //logica derecha
            col = jugable.b.col + 1;
            if ((col <= 7)) {
                if (row != 0) { // si estoy arriba
                    if (b.getTileAt(row - 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row - 1, col), b.getTileAt(row, col)));
                    }
                }
                if (col != 7) { //si estoy a lo mas derecho
                    if (b.getTileAt(row, col + 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col + 1), b.getTileAt(row, col)));
                    }
                }
                if (row != 7) { //si estoy abajo
                    if (b.getTileAt(row + 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row + 1, col), b.getTileAt(row, col)));
                    }
                }

            }

        }
        return movimientos;
    }

    static ArrayList<TilePairs> jugablesV(ArrayList<TilePairs> jugables, Board b) {
        ArrayList<TilePairs> movimientos = new ArrayList();
        int row, col;
        for (TilePairs jugable : jugables) {
            row = jugable.a.row - 1; //logica para el de arriba
            col = jugable.a.col;
            if (row >= 0) {
                if (row != 0) { // si estoy arriba
                    if (b.getTileAt(row - 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row - 1, col), b.getTileAt(row, col)));
                    }
                }
                if (col != 7) { //si estoy a lo mas derecho
                    if (b.getTileAt(row, col + 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col + 1), b.getTileAt(row, col)));
                    }
                }
                if (col != 0) { //si estoy a lo mas izquierda
                    if (b.getTileAt(row, col - 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col - 1), b.getTileAt(row, col)));
                    }
                }
            }
            row = jugable.b.row + 1;
            col = jugable.b.col;
            if (row <= 7) {
                if (col != 7) { //si estoy a lo mas derecho
                    if (b.getTileAt(row, col + 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col + 1), b.getTileAt(row, col)));
                    }
                }
                if (col != 0) { //si estoy a lo mas izquierda
                    if (b.getTileAt(row, col - 1).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row, col - 1), b.getTileAt(row, col)));
                    }
                }

                if (row != 7) { //si estoy abajo
                    if (b.getTileAt(row + 1, col).id == jugable.a.id) {
                        movimientos.add(new TilePairs(b.getTileAt(row + 1, col), b.getTileAt(row, col)));
                    }
                }
            }

        }
        return movimientos;
    }

    static ArrayList<TilePairs> jugablesHR(ArrayList<TilePairs> jugables, Board b) {
        ArrayList<TilePairs> movimientos = new ArrayList();
        int row, col;
        for (TilePairs jugable : jugables) {
            row = jugable.a.row;
            col = jugable.a.col + 1;
            if (row != 0) { // si estoy arriba
                if (b.getTileAt(row - 1, col).id == jugable.a.id) {
                    movimientos.add(new TilePairs(b.getTileAt(row - 1, col), b.getTileAt(row, col)));
                }
            }
            if (row != 7) { //si estoy abajo
                if (b.getTileAt(row + 1, col).id == jugable.a.id) {
                    movimientos.add(new TilePairs(b.getTileAt(row + 1, col), b.getTileAt(row, col)));
                }
            }

        }

        return movimientos;
    }

    static ArrayList<TilePairs> jugablesVR(ArrayList<TilePairs> jugables, Board b) {
        ArrayList<TilePairs> movimientos = new ArrayList();
        int row, col;
        for (TilePairs jugable : jugables) {
            row = jugable.a.row + 1;
            col = jugable.a.col;
            if (col != 0) { //si estoy a lo mas izquierda
                if (b.getTileAt(row, col - 1).id == jugable.a.id) {
                    movimientos.add(new TilePairs(b.getTileAt(row, col - 1), b.getTileAt(row, col)));
                }
            }
            if (col != 7) { //si estoy a lo mas derecho
                if (b.getTileAt(row, col + 1).id == jugable.a.id) {
                    movimientos.add(new TilePairs(b.getTileAt(row, col + 1), b.getTileAt(row, col)));
                }
            }
        }

        return movimientos;
    }

    public Solver(Game g) {
        this.g = g;
    }

    public void gamesolver() throws InterruptedException {
        
        
        Board master = g.getBoard();
        Tile anterior, actual;
        //LOGICA HORIZONTAL
        for (int c = 0; c < 8; c++) {
            anterior = master.getTileAt(c, 0);
            for (int r = 1; r < 8; r++) {
                actual = master.getTileAt(c, r);
                if (actual.id == anterior.id) {
                    // System.out.println("Son hermanos " + anterior.col + "," + anterior.row + "\n" + actual.col + "," + actual.row);
                    horizontales.add(new TilePairs(anterior, actual));
                }

                //  System.out.println("I AM " + actual.id);
                anterior = actual;
            }
        }
        ArrayList<TilePairs> veamos = jugablesH(horizontales, master);
        for (TilePairs t : veamos) {
            System.out.println("Los movimientos jugables horizontales son " + t.getA().col + "," + t.getA().row + "\n" + t.getB().col + "," + t.getB().row);
            System.out.println("con peso " + scoreH(t, master));
        }
        //Logica Vertical
        ArrayList<TilePairs> verticales = new ArrayList();
        int cont = 0;
        for (int r = 0; r < 8; r++) {
            anterior = master.getTileAt(0, r);
            for (int c = 1; c < 8; c++) {
                actual = master.getTileAt(c, r);
                if (actual.id == anterior.id) {
                    // System.out.println("Son hermanos " + anterior.col + "," + anterior.row + "\n" + actual.col + "," + actual.row);
                    verticales.add(new TilePairs(anterior, actual));

                }
                anterior = actual;
            }
        }

        ArrayList<TilePairs> otro = jugablesV(verticales, master);

        for (TilePairs t : otro) {
            System.out.println("Los movimientos jugables verticales son " + t.getA().col + "," + t.getA().row + "\n" + t.getB().col + "," + t.getB().row);
            System.out.println("con peso " + scoreV(t, master));
        }

        //Logica Horizontal extraña
        ArrayList<TilePairs> horizontalesRaros = new ArrayList();
        for (int c = 0; c < 8; c++) {
            anterior = master.getTileAt(c, 0);
            for (int r = 2; r < 8; r++) {
                actual = master.getTileAt(c, r);
                if (actual.id == anterior.id) {
                    //    System.out.println("Son hermanos " + anterior.col + "," + anterior.row + "\n" + actual.col + "," + actual.row);
                    horizontalesRaros.add(new TilePairs(anterior, actual));
                }

                //  System.out.println("I AM " + actual.id);
                anterior = master.getTileAt(c, r - 1);
            }
        }
        ArrayList<TilePairs> next = jugablesHR(horizontalesRaros, master);
        for (TilePairs t : next) {
            System.out.println("Los movimientos jugables HR son " + t.getA().col + "," + t.getA().row + "\n" + t.getB().col + "," + t.getB().row);
            System.out.println("Con peso" + scoreH(t, master));
        }

        //Logica Vertical extraña
        ArrayList<TilePairs> verticalesRaros = new ArrayList();
        for (int r = 0; r < 8; r++) {
            anterior = master.getTileAt(0, r);
            for (int c = 2; c < 8; c++) {
                actual = master.getTileAt(c, r);
                if (actual.id == anterior.id) {
//                    System.out.println("Son hermanos " + anterior.col + "," + anterior.row + "\n" + actual.col + "," + actual.row);
                    verticalesRaros.add(new TilePairs(anterior, actual));
                }
                anterior = master.getTileAt(c - 1, r);
            }
        }
        ArrayList<TilePairs> nextPlus = jugablesVR(verticalesRaros, master);
        for (TilePairs t : nextPlus) {
            System.out.println("Los movimientos VR son " + t.getA().col + "," + t.getA().row + "\n" + t.getB().col + "," + t.getB().row);
            System.out.println("con peso " + scoreV(t, master));
        }

        int h = 0, v = 0, hr = 0, vr = 0;

        h = 0;
        int Max = 0;
        int score;
        List l = new List();
        int scoreH = 0, scoreV = 0, scoreHR = 0, scoreVR = 0;
        veamos.addAll(next);

        for (int t = 0; t < veamos.size(); t++) {
            score = scoreH(veamos.get(t), master);
            if (score >= Max) {
                h = t;
                Max=score;
            }
        }
        scoreH = Max;
        Max = 0;
        otro.addAll(nextPlus);
        for (int t = 0; t < otro.size(); t++) {
            score = scoreV(otro.get(t), master);
            if(score==Max){
               if(otro.get(t).getB().row < otro.get(v).getB().row){ //Agarra el mas bajo
                v = t;
                Max=score;
               }
            }
            if (score > Max) {
                v = t;
                Max=score;
            }
        }
        scoreV = Max;
        System.out.println("MaxH Score "+ scoreH);
        System.out.println("MaxV Score "+ scoreV);
        System.out.println("Ek movimiento mas mejor es : ");
        
        
        if(scoreV==0 && scoreH==0){
            JOptionPane.showMessageDialog(null, "NO hay movimientos :D");
            
        }else{
        if (scoreV > scoreH) {
            g.clickPerformed(otro.get(v).getA().col, otro.get(v).getA().row);
            g.clickPerformed(otro.get(v).getB().col, otro.get(v).getB().row);
            System.out.println(otro.get(v).getA().toString());
            System.out.println(otro.get(v).getB().toString());
            
        } else {
            g.clickPerformed(veamos.get(h).getA().col, veamos.get(h).getA().row);
            g.clickPerformed(veamos.get(h).getB().col, veamos.get(h).getB().row);
            System.out.println(veamos.get(h).getA().toString());
            System.out.println(veamos.get(h).getB().toString());
          
        }
        }
       /*
        if (scoreH > scoreV && scoreH > scoreHR && scoreH > scoreVR) {
            g.clickPerformed(veamos.get(h).getA().col, veamos.get(h).getA().row);
            g.clickPerformed(veamos.get(h).getB().col, veamos.get(h).getB().row);
            System.out.println(veamos.get(h).getA().toString());
            System.out.println(veamos.get(h).getB().toString());
        }
        if (scoreV > scoreH && scoreV > scoreHR && scoreV > scoreVR) {
            g.clickPerformed(otro.get(v).getA().col, otro.get(v).getA().row);
            g.clickPerformed(otro.get(v).getB().col, otro.get(v).getB().row);
            System.out.println(otro.get(v).getA().toString());
            System.out.println(otro.get(v).getB().toString());
        }
        if (scoreHR > scoreV && scoreHR > scoreH && scoreHR > scoreVR) {
            g.clickPerformed(next.get(hr).getA().col, next.get(hr).getA().row);
            g.clickPerformed(next.get(hr).getB().col, next.get(hr).getB().row);
            System.out.println(next.get(hr).getA().toString());
            System.out.println(next.get(hr).getB().toString());
        }
        if (scoreVR > scoreV && scoreVR > scoreHR && scoreVR > scoreH) {
            g.clickPerformed(nextPlus.get(vr).getA().col, nextPlus.get(vr).getA().row);
            g.clickPerformed(nextPlus.get(vr).getB().col, nextPlus.get(vr).getB().row);
            System.out.println(nextPlus.get(vr).getA().toString());
            System.out.println(nextPlus.get(vr).getB().toString());
        }
*/}
    

}
