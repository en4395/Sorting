package sorting;

import java.util.Arrays;

public class mergeSort {

	int [] array;
	int [] temp;
	int [] ogArray;
	public mergeSort(int [] array) 
	{
		this.array=array.clone();
		temp=new int [array.length];
		this.ogArray=array.clone();
	}
	
	public void sort(int [] arr, int [] tmp, int left, int right)
	{
		int mid=(left+right)/2;
		if(left==right)
			return;
		sort(arr, tmp, left, mid);
		sort(arr, temp, mid+1, right);
		for(int i=left; i<=right; i++) //copy subarray into tmp
		{
			tmp[i]=arr[i];
		}
		
		//merge operation back to arr
		int index1=left, index2=mid+1; 
		for(int current=left; current<=right; current++)
		{
			if(index1==mid+1)
			{
				arr[current]=tmp[index2++];
			}
			else if(index2>right)
			{
				arr[current]=tmp[index1++];
			}
			else if(tmp[index1]<=tmp[index2]) 
			{
				arr[current]=tmp[index1++];
			}
			else
			{
				arr[current]=tmp[index2++];
			}
		}
		
	}
	
	public void sort()
	{
		long start, stop;
		start=System.nanoTime();
		sort(array, temp, 0, array.length-1);
		stop=System.nanoTime();
		System.out.println("MERGE SORT TOOK: "+(stop-start));
		
	}
	
	public void checkSort()
	{
		System.out.println();
		Arrays.sort(ogArray);
		if(Arrays.equals(ogArray, array))
			System.out.println("MergeSort worked!");
		else
			System.out.println("MergeSort bombed!");
	}
	
	}
