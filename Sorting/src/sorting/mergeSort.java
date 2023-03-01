package sorting;

import java.util.Arrays;

public class mergeSort {

	int [] array;
	int [] temp;	//mergeSort is not in-place and requires this additional array
	int [] origArray;
	public mergeSort(int [] array) 
	{
		this.array=array.clone();
		temp=new int [array.length];
		this.origArray=array.clone();
	}
	
	public void sort(int [] arr, int [] tmp, int left, int right)
	{
		int mid=(left+right)/2;
		if(left==right)	//Return if passed array contains one element
			return;
		sort(arr, tmp, left, mid);
		sort(arr, temp, mid+1, right);
		for(int i=left; i<=right; i++) //Copy subarray into tmp
		{
			tmp[i]=arr[i];
		}
		
		//Merge operation back to arr
		int index1=left, index2=mid+1; 
		for(int current=left; current<=right; current++)
		{
			if(index1==mid+1)	//If the left subarray is empty, copy remaining elements from right subarray into array
			{
				arr[current]=tmp[index2++]; 
			}
			else if(index2>right)	//If the right subarray is empty, copy remaining elements from left subarray into array
			{
				arr[current]=tmp[index1++];
			}
			else if(tmp[index1]<=tmp[index2]) 	//If first element of left subarray is less than first element of right 
			{									//subarray, copy this element into array
				arr[current]=tmp[index1++];
			}
			else
			{
				arr[current]=tmp[index2++];
			}
		}
		
	}
	
	public void sort()	//Start timer, call sort with default parameters, stop timer, print time
	{
		long start, stop;
		start=System.nanoTime();
		sort(array, temp, 0, array.length-1);
		stop=System.nanoTime();
		System.out.println("MERGE SORT TOOK:\t\t"+(stop-start));
		
	}
	
	public void checkSort() //Uses Arrays.sort() and Arrays.equals() to sort a copy of original array and compare to sort
	{
		System.out.println();
		Arrays.sort(origArray);
		if(Arrays.equals(origArray, array))
			System.out.println("MergeSort worked!");
		else
			System.out.println("MergeSort bombed!");
	}
	
	}
