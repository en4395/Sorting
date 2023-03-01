package sorting;

import java.util.Arrays;

public class quickSort {

	int [] array;
	int [] ogArray;
	public quickSort(int [] array) 
	{
		this.array=array.clone();
		this.ogArray=array.clone();
	}

	public int partition(int [] arr, int left, int right, int pivot)
	{
		do
		{
			while(arr[++left]<pivot);
			while(right!=0&&arr[--right]>pivot);
			swap(arr, left, right);				
		}while(left<right);
		swap(arr, left, right);
		return left;
	}
	
	public void swap(int [] arr, int i, int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public int findPivot(int left, int right)
	{
		return ((left+right)/2);
	}
	
	public void sort(int [] arr, int left, int right)
	{
		int pivotIndex=findPivot(left, right); //select middle element as pivot
		swap(arr, right, pivotIndex); //send pivot to last position of array
		int k=partition(arr, left-1, right, arr[right]); //
		swap(arr, k, right); //put pivot in place
		//k is now first position in right subarray
		if((k-left)>1)
			sort(arr, left, k-1);
		if((right-k)>1)
			sort(arr, k+1, right);
	}
	
	public void sort()
	{
		long start, stop;
		start=System.nanoTime();
		sort(array, 0, (array.length-1));
		stop=System.nanoTime();
		System.out.println("QUICKSORT TOOK: "+(stop-start));
	}
	
	public void checkSort()
	{
		System.out.println();
		Arrays.sort(ogArray);
		if(Arrays.equals(ogArray, array))
			System.out.println("QuickSort worked!");
		else
			System.out.println("QuickSort bombed!");
	}
}
