
package heapquicksortcomparisonalgo;

import java.util.Arrays;

public class HeapQuickMethods {
    
static void quickSort(int[] array, int low, int high)
{
    if (low < high) 
    {   //partition
        int ptn = partition(array, low, high);  
        quickSort(array, low, ptn - 1);
        quickSort(array, ptn + 1, high);
    }
}


//partition used in quick sort
static int partition(int[] array, int low, int high)
{     
    int pivot = array[high];      
    int i = (low - 1);  
    for(int j = low; j <= high - 1; j++)
    {
        if (array[j] < pivot) 
        {            
            i++; 
            swap(array, i, j);
            //System.out.println(Arrays.toString(array));
        }
    }
    swap(array, i + 1, high);
    return (i + 1);
}

//array swap method (needed for both sort and partition methods)
static void swap(int[] array, int i, int j)
{
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;  
}

//sorting method for heapsort
public void sort(int array[])
{
    int N = array.length;
    // Build heap (rearrange array)
    for (int i = N / 2 - 1; i >= 0; i--){
        maxHeapify(array, N, i);
    }
    //System.out.println(Arrays.toString(array));    
    // One by one extract an element from heap
    for (int i = N - 1; i > 0; i--) {
          // Move root to last index
	    //int temp = array[0];
	    //array[0] = array[i];
	    //array[i] = temp;
            swap(array, 0, i);
// call max heapify again
	    maxHeapify(array, i, 0);
            //System.out.println(Arrays.toString(array));
    }
            
}


//heapSorting method
public void maxHeapify(int array[], int N, int i)
{
    int largest = i;//first root 
    int leftCh = 2*i +1;//left child
    int rightCh = 2*i + 2;//right child

    // scenerio left child is bigger, exchange value with root
    if (leftCh < N && array[leftCh] > array[largest])
        largest = leftCh;
    
    //scenerio right child is bigger, exchane value with the root
    if (rightCh < N && array[rightCh] > array[largest])
        largest = rightCh;

    //finally scenerio were largest is not the root
    if (largest != i){
        int temp = array[i];
        array[i] = array[largest];
        array[largest] = temp;
        maxHeapify(array, N, largest);
    }
}

}
