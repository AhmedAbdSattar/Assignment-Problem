package assignmentproblem;



import assignmentproblem.matrix.Reduction;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class AssignmentProblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test the gui
        Gui start = new Gui();
        start.Run();
        /*test the first function */
       Scanner sc = new Scanner(System.in);
       int i ,j;
    
       int [][] array =new int[3][3];
  for ( i = 0; i < array.length; i++){
    for( j = 0; j < array.length; j++) {
        System.out.println("Row ["+i+"]:  Column "+j+" :");
        array[i][j] = sc.nextInt(); 
       }
   }

    
       Reduction r= new Reduction();
       r.reductRow(array);
       System.out.print("Row reduction: \n");
              for( i=0; i<array.length; i++){
            System.out.print("\n");
            for(j=0 ; j<array.length ;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.print("\n");
        }
              System.out.print("\n");
              System.out.print("\n");
              System.out.print("\n");
              System.out.print("coulmn reduction: \n");
       r.reductColumn(array);
       for( i=0; i<array.length; i++){
            System.out.print("\n");
            for(j=0 ; j<array.length ;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.print("\n");
        }

    }
    
  }

