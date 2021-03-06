/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem;


import assignmentproblem.matrix.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    JTextField MAT ;
    JLabel row ;
    JLabel project ;
    JButton GO ;
    JButton clear ;
    Font newFont;
    Font Title ;
    JButton Solve;
    Reduction reduction;
    ScannigRowAndColumn scanning;
    IdentifyMinimumUnselectedCell identifyTheMinimum;
    PanelOfproject matrixContainer;
    ShowResult resultPanel;
            public Gui() { //constractor
            row = new JLabel("Enter Matrix :");
            MAT = new JTextField(5);
            GO = new JButton("Go");
            Solve = new JButton("Solve");
            newFont = new Font("Arial", Font.ITALIC, 15);  
            project=new JLabel("Balance Assignment Model SW");
            Title = new Font("Arial",Font.BOLD,25);
            matrixContainer = new PanelOfproject();
            resultPanel = new ShowResult();
            clear =new JButton("Clear") ;
            clear.setVisible(false);
            Solve.setVisible(false);
            reduction = new Reduction();
            scanning = new ScannigRowAndColumn();
            identifyTheMinimum = new IdentifyMinimumUnselectedCell();
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
        MAT.setBounds(200, 100, 100, 20);
        GO.setBounds(320, 100, 60, 20);
        project.setBounds(60, -200, 500, 500);
        Solve.setBounds(70, 450, 150, 50);
        clear.setBounds(270, 450, 150, 50);
        Solve.setFont(Title);
        clear.setFont(Title);
        clear.setBackground(Color.GREEN);
        Solve.setBackground(Color.CYAN);
        matrixContainer.setBounds(90, 150, 300, 250);
        resultPanel.setBounds(90, 550, 300, 100);
        resultPanel.setVisible(false);
        
        myhandler hand =new myhandler();
        GO.addActionListener(hand);
        clear.addActionListener(hand);
        Solve.addActionListener(hand);
        
        
        this.add(GO);
        this.add(clear);
        this.add(project);
        this.add(row);
        this.add(MAT);
        this.add(Solve);
        this.add(matrixContainer);
        this.add(resultPanel);
        this.setVisible(true);
    }
        class myhandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==GO){
                final int  matrix = Integer.valueOf(MAT.getText());
                if(matrix <=1 ){
                    JOptionPane.showMessageDialog(null, "please enter number Greater than 1");
                }else{
                    matrixContainer.createMatrix(matrix);
                    matrixContainer.setVisible(true);
                    GO.setVisible(false);
                    row.setVisible(false);
                    MAT.setVisible(false);
                    clear.setVisible(true);
                    Solve.setVisible(true);
                    resultPanel.setVisible(false);
                }
            }else if (e.getSource()==clear){
                matrixContainer.clearMatrix();
                matrixContainer.setVisible(true);
                GO.setVisible(true);
                row.setVisible(true);
                MAT.setVisible(true);
                MAT.setText(null);
                clear.setVisible(false);
                Solve.setVisible(false);
                resultPanel.setVisible(false);
            }else if (e.getSource() == Solve){
                int [][] mat_array = matrixContainer.getMatrix();
                reduction.reductRow(mat_array);
                reduction.reductColumn(mat_array);
                scanning.rowScanning(mat_array);
                scanning.columnScanning(mat_array);
                
                int squaresNumber = scanning.getSquaresSelected();
                while(squaresNumber != mat_array.length){
                    mat_array = identifyTheMinimum.identify(mat_array, scanning);
                    scanning.rowScanning(mat_array);
                    scanning.columnScanning(mat_array);
                    squaresNumber = scanning.getSquaresSelected();
                }
                int[] optimal = scanning.getOptimalSoultion();
                resultPanel.createOptimalGui(optimal);
                resultPanel.setVisible(true);
                matrixContainer.setVisible(true);
                GO.setVisible(false);
                row.setVisible(false);
                MAT.setVisible(false);
                MAT.setText(null);
                clear.setVisible(true);
                Solve.setVisible(false);
            }
        }
    } 
}