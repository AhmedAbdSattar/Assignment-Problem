/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem.matrix;

import java.util.LinkedList;

/**
 *
 * @author absal
 */
public class ScannigRowAndColumn {
    private LinkedList<Integer> selected_Row, selected_Column;
    private int squaresSelected;
    private int[] optimalSoultion;
    
    public LinkedList<Integer> rowScanning (int[][]matrix){
        squaresSelected = 0;
        this.selected_Column = new LinkedList<>();
        optimalSoultion = new int [matrix.length];
        for (int i = 0; i < matrix.length; i++){
            boolean selected = false;
            for (int j = 0; j < matrix.length; j++){
                if (!this.selected_Column.contains(j)){//if this column not already selected
                    if ((matrix [i][j] == 0) && (!selected)){//if we find the first zero at the row
                        selected = true;
                        this.selected_Column.addLast(j);//select the column
                        this.optimalSoultion[i] = j;
                        this.squaresSelected++;
                    }else if((matrix [i][j] == 0) && (selected)){//if we find the second zero at the row
                        this.selected_Column.removeLast();//unselect the first zero
                        this.squaresSelected--;
                        break;//break j for loop to skip this row
                    }
                }
            }
        }
        return this.selected_Column;
    }
    
    public LinkedList<Integer> columnScanning (int[][]matrix){
        this.selected_Row = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++){
            boolean selected = false;
            if (!this.selected_Column.contains(i)){//if this column selected from row scanning
                for (int j = 0; j < matrix.length; j++){
                    if (!this.selected_Row.contains(j)){//if this row not already selected
                        if ((matrix [j][i] == 0) && (!selected)){//if we find the first zero at the column
                            selected = true;
                            this.selected_Row.addLast(j);//select the row
                            this.optimalSoultion[j] = i;
                            this.squaresSelected++;
                        }else if((matrix [j][i] == 0) && (selected)){//if we find the second zero at the column
                            this.selected_Row.removeLast();//unselect the first zero
                            this.squaresSelected--;
                            break;//break j for loop to skip this column
                        }
                    }
                }
            }
        }
        return this.selected_Row;
    }

    public int getSquaresSelected() {
        return this.squaresSelected;
    }

    public LinkedList<Integer> getSelected_Row() {
        return selected_Row;
    }

    public LinkedList<Integer> getSelected_Column() {
        return selected_Column;
    }

    public int[] getOptimalSoultion() {
        return optimalSoultion;
    }
    
}