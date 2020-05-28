/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentproblem.matrix;

import javax.swing.JOptionPane;


/**
 *
 * @author Ahmed
 */
public class Reduction {
//reduction row this process will happen in row part 
    public int [][] reductRow( int array [][]){
        int[] minrow= new int[array.length]; //initial array which save the 
        int i ,j;
        for( i=0; i<array.length ; i++){ //start for loop for I
            int min = Integer.MAX_VALUE;  //initial min with MAX int value
            for( j=0 ; j<array.length ;j++){ //start for loop for J
                if(array[i][j] < min){ // if element smaller than min
                    min=array[i][j]; //assign a new min value
                }//END IF 
                minrow[i] = min;//save the min value in row in array
            } //end for loop for J
        } //start for loop for I
        /*subtract the smallest element in rows from other elemnt*/  
        for( i=0; i<array.length; i++){
            for( j=0 ; j<array.length ;j++){
                array[i][j]-=minrow[i];
            }
        }
        return array;
    } 
    //reduction coulmn  this process will happen in coulmn  part 
    public int [][] reductColumn ( int array [][]){
        int[] minrow= new int[array.length]; //initial array which save the 
        int i ,j;
        
        for( i=0; i<array.length ; i++){ //start for loop for I
           int min = Integer.MAX_VALUE;  //initial min with MAX int value
            for( j=0 ; j<array.length ;j++){ //start for loop for J
                if(array[j][i] < min){ // if element smaller than min
                    min=array[j][i]; //assign a new min value
                }//END IF 
                minrow[i] = min;//save the min value in row in array
            } //end for loop for J

        } //start for loop for I
  /*subtract the smallest element in column  from other elemnt*/  
    for( i=0; i<array.length; i++){
         for( j=0 ; j<array.length ;j++){
             array[j][i]-=minrow[i];
         }
       }                
    return array;
    }    
}