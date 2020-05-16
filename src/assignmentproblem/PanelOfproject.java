/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class PanelOfproject extends JPanel{
     JTextField field;

    public PanelOfproject() {
        this.setBackground(Color.GRAY);
        field = new JTextField();
    }
    
    void createMatrix (int numberOFMatrix){
    this.setLayout(new GridLayout(numberOFMatrix,numberOFMatrix));
    
          for (int  i =0; i < numberOFMatrix; i++) {
          for ( int j =0 ; j < numberOFMatrix ; j++) {
                this.add(new JTextField());
         }
    }
    this.setVisible(false);
  }

}
