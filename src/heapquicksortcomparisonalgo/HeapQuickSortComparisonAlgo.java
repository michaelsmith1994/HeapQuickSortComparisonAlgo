
package heapquicksortcomparisonalgo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapQuickSortComparisonAlgo {

   public static void main(String args[])
    {boolean quitProgram = false;

	//initiate a do-while loop for multiple uses without restart
        do{
	//initialize an array of 30 int elements
        int[] array=new int[30];
        // initiated to copy array for heap use
        Random random=new Random();//create random                       
        for(int i=0;i<30;i++){//assign array a random intergers from 1-100
            array[i]=random.nextInt(99)+1; 
        }       
        int [] array2 = Arrays.copyOf(array, array.length); //copy random int array to array2 for heap sort, we want the same variables for time comparison testing       
        System.out.println("Your current random interger array is:\n"+Arrays.toString(array));        
        HeapQuickMethods Sorting = new HeapQuickMethods();	
        Scanner scanner=new Scanner(System.in);
        System.out.print("Select what sorting method should be used (enter the number) \n1. Run Quick Heap Sort Comparison Test\n2. End Program\nEnter value here: ");
     //Catch invalid input from user for switch case.   
        while (!scanner.hasNextInt()){
                System.out.println("Enter a valid number!");
                scanner.next();
            }
        int UserInput=scanner.nextInt();
        System.out.println("-------------------------------------------------------------------------------------------------");        
	  //intitiate a user input switch case for sorting algo selection via method call
        switch(UserInput){
            case 1:
                System.out.println(Arrays.toString(array2));//prints the array
                System.out.println("Start HeapSort Algorithm");
		long startTime2 = System.nanoTime();
                Sorting.sort(array2);//call heap algo
		long endTime2 = System.nanoTime(); 
                System.out.println(Arrays.toString(array2));
                System.out.println("End HeapSort Algorithm "+(endTime2-startTime2)+" nanoseconds.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println(Arrays.toString(array));//prints the array
                System.out.println("Start Quicksort Algorithm");
		long startTime1 = System.nanoTime();
                Sorting.quickSort(array, 0, array.length-1);//call quick algo
		long endTime1 = System.nanoTime();
                System.out.println(Arrays.toString(array));
                System.out.println("End Quicksort Algorithm, times is "+(endTime1-startTime1)+" nanoseconds.");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("##################################### END ##############################################");                        
                break;		                
            case 2:
                System.out.println(" ");
                System.out.println("-Closing Program-");//break and close loop per user input request
                quitProgram = true;
            default :
                System.out.println("-Enter a valid input-");//default catch bad input values, request valid input
                
        }}
        while(!quitProgram);//close do while loop.   
}}
