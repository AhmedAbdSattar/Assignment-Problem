/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem;


import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class Gui extends JFrame {
    JTextField Row ;
    JLabel row ;
    JLabel project ;
    JButton GO ;
    JPanel matrixContainer ;
    Font newFont;
    Font Title ;
    JTextField tf; 
    int matrix=5; //here we sholud put matrix that user will enter it 
    JButton Solve;
    
    
    public Gui() { //constractor
    row = new JLabel("Enter Matrix :");
    Row = new JTextField(5);
    GO = new JButton("Go");
    Solve = new JButton("Solve");
    matrixContainer = new JPanel() ;
    newFont = new Font("Arial", Font.ITALIC, 15);  
    project=new JLabel("Balance Assignment Model SW");
    Title = new Font("Arial",Font.BOLD,25);
    tf= new JTextField(20); 
   }
    
public void Run() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 900);
        this.setLocation(350,0);
        this.setTitle("Balance assignmet model");
        this.getContentPane().setBackground(Color.darkGray);
        this.setLayout(null);
        row.setForeground(Color.WHITE);     project.setForeground(Color.CYAN);
        row.setFont(newFont); GO.setFont(newFont); project.setFont(Title);
        row.setBounds(100, 100, 100, 20);
        Row.setBounds(200, 100, 100, 20);
        GO.setBounds(320, 100, 60, 20);
        project.setBounds(60, -200, 500, 500);
        Solve.setBounds(170, 450, 150, 50);
        Solve.setFont(Title);
        Solve.setBackground(Color.CYAN);
        matrixContainer.setBounds(90, 150, 300, 250);
        matrixContainer.setBackground(Color.GRAY);
        matrixContainer.setLayout(new GridLayout(matrix,matrix,5,5));
        
         for (int  i =0; i < matrix; i++) {
           for ( int j =0 ; j < matrix ; j++) {
          matrixContainer.add(new JTextField(""+i));
         }
    }

        
    
    
    
    
    
    
    
    
    
    
    this.add(project);
    this.add(row);
    this.add(Row);
    this.add(GO);
    this.add(matrixContainer);
    this.add(Solve);
    this.setVisible(true);
    }
}
