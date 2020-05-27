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
     JTextField [][]matrix_txt;
     int matrix_size;

    public PanelOfproject() {
        matrix_size = 0;
        this.setBackground(Color.GRAY);
        field = new JTextField();
    }
    
    void createMatrix (int numberOFMatrix){
        this.matrix_size = numberOFMatrix;
        matrix_txt = new JTextField [matrix_size][matrix_size];
        this.setLayout(new GridLayout(matrix_size,matrix_size));
        for (int  i =0; i < matrix_size; i++) {
            for ( int j =0 ; j < matrix_size ; j++) {
                matrix_txt[i][j] = new JTextField();
                this.add(matrix_txt[i][j]);
            }
        }
        this.setVisible(false);
    }
    
    void clearMatrix (){
        for (int  i =0; i < matrix_size; i++) {
           for ( int j =0 ; j < matrix_size ; j++) {
               this.remove(this.matrix_txt[i][j]);
           }
        }
        this.matrix_txt = null;
        this.matrix_size = 0;
        this.setVisible(false);
    }
    
    int[][] getMatrix (){
        int [][]matrix_array = new int[matrix_size][matrix_size];
        for (int  i =0; i < matrix_size; i++) {
           for ( int j =0 ; j < matrix_size ; j++) {
               try{
                   matrix_array[i][j] = Integer.valueOf(matrix_txt[i][j].getText());
               }catch (NumberFormatException e){
                   continue;
               }
           }
        }
        return matrix_array;  
    }
}
