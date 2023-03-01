package sorting;

import java.util.Arrays;

public class insertionSort {

	int [] array;
	int [] origArray;
	public insertionSort(int [] array) 
	{
		this.array=array.clone();
		this.origArray=array.clone();
	}
	
	public void sort()
	{
		long start, stop;
		int lowindex;
		start=System.nanoTime();
		for(int sorted=1; sorted<array.length; sorted++)
		{
			lowindex=sorted;	//Stores the index of the lowest value
			for(int j=sorted; j>=0; j--)
			{
				if(array[j]>array[sorted])	//Iterate
				{
					lowindex=j;
				}
			}
			//if(lowindex!=sorted)	//Could only perform swap and place shift if at a different index to the element being added
			//{						//Actually more efficient not to perform this check 
			shift_place(lowindex, sorted);
			//}
		}
		
		stop=System.nanoTime();
		System.out.println("INSERTION SORT TOOK:\t\t"+(stop-start));
	}
	
	public void shift_place(int target, int element) //Shifts sorted part of the array to make place to insert element
	{												 //target is the target index for the element to be inserted
		int temp=array[element];					 //element is the initial index of the element to be inserted
		for(int i=element-1; i>=target; i--)
		{
			array[i+1]=array[i];
		} //Shift every element right
		array[target]=temp;
	}
	
	public void checkSort()	//Uses Arrays.sort() and Arrays.equals() to sort a copy of original array and compare to sort 
	{
		Arrays.sort(origArray);
		if(Arrays.equals(origArray, array))
			System.out.println("\nInsertionSort worked!");
		else
			System.out.println("\nInsertionSort bombed!");
	}

}
