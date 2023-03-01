//Radix Sort
//This implementation of radix sort performs a least significant byte sort on a set of integers

package sorting;

import java.util.Arrays;

public class radixSort {

	int [] array;
	int [] origArray;
	public radixSort(int [] array) 
	{
		this.array=array.clone();
		this.origArray=array.clone();
	}

	public void zeroBuckets(int [] buckets)
	{
		for(int i=0; i<buckets.length; i++)
		{
			buckets[i]=0;
		}
	}
	
	public void sort()
	{
		long start, stop;
		int [] buffer=new int [array.length];
		int [] buckets=new int [257]; //Max value of a byte is 11111111, or 255 in decimal
		
		start=System.nanoTime();
		for(int digit=0; digit<4; digit++) //An iteration for each byte of the integers
		{
			//Start at bucket 1 (hence the (int)(1+...))
			//The index in buckets is 
			for(int i=0; i<array.length; i++)
			{
				buckets[(int)(1+(array[i]>>(digit*8))&255)]++; 
				//(array[i]>>(digit*8))&255) performs an 8 bit shift to assess one byte at a time, then 
				//a bit-wise AND operation with 11111111 to preserve the last 8 bits
				//this is added with 1 and typecast to integer
			}
			
			for(int i=1; i<257; i++)
			{
				buckets[i]=buckets[i]+buckets[i-1];
			} //Sum the buckets to get starting indices in sorted array
			
			for(int i=0; i<array.length; i++)
			{
				buffer[buckets[(int)(array[i]>>(digit*8)&255)]]=array[i];
				buckets[(int)(array[i]>>(digit*8)&255)]++;
			}
			
			int[] temp=buffer;
			buffer=array;
			array=temp;
			zeroBuckets(buckets);	//Restore all buckets to zero 
		}
		stop=System.nanoTime();
		
		System.out.println("RADIX SORT TOOK:\t\t"+(stop-start));
		
	}
	
	public void checkSort()	//Uses Arrays.sort() and Arrays.equals() to sort a copy of original array and compare to sort
	{
		System.out.println();
		Arrays.sort(origArray);
		if(Arrays.equals(origArray, array))
			System.out.println("RadixSort worked!");
		else
			System.out.println("RadixSort bombed!");
	}

}
