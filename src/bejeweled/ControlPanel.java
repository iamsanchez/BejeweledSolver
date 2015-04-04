/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bejeweled;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlPanel extends JPanel implements ActionListener {
    private JButton newGameButton = new JButton("New Game");
    private Game game;
    private JButton exit = new JButton("Exit");
    private JButton cheat = new JButton("Cheat");
    private JButton solve = new JButton("SOLVEE!!!");
    private JButton toEnd = new JButton("TO THE END");
    private Solver s = new Solver();
    public ControlPanel(Game game){
        this.game = game;
        add(newGameButton);
        newGameButton.addActionListener(this);
        add(exit);
        exit.addActionListener(this);
        add(cheat);
        cheat.addActionListener(this);
        add(solve);
        solve.addActionListener(this);
        add(toEnd);
        toEnd.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e){
      if (e.getSource().equals(newGameButton)){
            game.initGame();
      }
      if (e.getSource().equals(cheat))
          game.addScore(500);
     if(e.getSource().equals(solve)){ 
          try {
              s=new Solver(game);
              s.gamesolver();
          } catch (InterruptedException ex) {
              Logger.getLogger(ControlPanel.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
   
     
      if (e.getSource().equals(exit))
          System.exit(0);
   }
}
