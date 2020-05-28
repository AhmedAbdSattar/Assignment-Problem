/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem.matrix;

import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 *
 * @author absal
 */
public class IdentifyMinimumUnselectedCell {
    public int [][] identify (int [][]matrix, ScannigRowAndColumn scanned){
        Object[] selected_Row = scanned.getSelected_Row().toArray();
        Object[] selected_column = scanned.getSelected_Column().toArray();
        //get the minimum unselected value at the matrix
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++){
            if(Arrays.asList(selected_Row).contains(i)){
                continue;
            }
            for (int j = 0; j < matrix.length; j++){
                if(Arrays.asList(selected_column).contains(j)){
                    continue;
                }
                if (matrix[i][j] < minimum)
                    minimum = matrix[i][j];
            }
        }
        //add the minimum value to intersection cells
        for (Object columns : selected_Row){
            for (Object rows : selected_column){
                matrix[(int)rows][(int)columns] += minimum;
            }
        }
        //substract the minimum value from any unselected cell
        for (int i = 0; i < matrix.length; i++){
            if(!Arrays.asList(selected_Row).contains(i)){
                for (int j = 0; j < matrix.length; j++){
                    if(!Arrays.asList(selected_column).contains(j)){
                        matrix[i][j] -= minimum;
                    }
                }
            }
        }
        return matrix;
    }
}