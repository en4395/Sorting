package sorting;

import java.util.Arrays;

public class selectionSort {

	int [] array;
	int [] origArray;
	int last;
	public selectionSort(int [] array) 
	{
		this.array=array.clone();
		last=array.length-1;
		this.origArray=array.clone();
	}
	
	public void swap(int i, int j)
	{
		int temp=array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public void sort()
	{
		long start, stop;
		int max;
		start=System.nanoTime();
		for(int i=last; i>=0; i--)	//Iterate through array, backwards
		{
			max=i;
			for(int j=0; j<=i; j++)	//Iterate forward, looking for max element
			{
				if(array[j]>array[max])
				{
					max=j;
				}
			}
			swap(i, max);
		}
		stop=System.nanoTime();
		System.out.println("SELECTION SORT TOOK:\t\t"+(stop-start));
		
	}

	public void checkSort()	//Uses Arrays.sort() and Arrays.equals() to sort a copy of original array and compare to sort
	{
		System.out.println();
		Arrays.sort(origArray);
		if(Arrays.equals(origArray, array))
			System.out.println("SelectionSort worked!");
		else
			System.out.println("SelectionSort bombed!");
	}
}
