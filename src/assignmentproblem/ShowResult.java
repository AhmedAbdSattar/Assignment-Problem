/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class ShowResult extends JPanel{

    public ShowResult() {
        this.setBackground(Color.DARK_GRAY);
    }
    
       public void createOptimalGui (int []optimal){
        int size = optimal.length;
        this.setLayout(new GridLayout(2,size));
        for (int  i =0; i < optimal.length; i++) {
            this.add(new JTextField("Person \t"+(i+1)));
        }
        for (int  i =0; i < optimal.length; i++) {
            this.add(new JLabel("project "+"\t"+(optimal[i]+1)));
            this.setBackground(Color.cyan);
        }
        
        this.setVisible(false);
        
    }
       
       
}
