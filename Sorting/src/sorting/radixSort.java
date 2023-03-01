package sorting;

import java.util.Arrays;

public class radixSort {

	int [] array;
	int [] ogArray;
	public radixSort(int [] array) 
	{
		this.array=array.clone();
		this.ogArray=array.clone();
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
		int [] buckets=new int [257];
		
		start=System.nanoTime();
		for(int digit=0; digit<4; digit++)
		{
			for(int i=0; i<array.length; i++)
			{
				buckets[(int)(1+(array[i]>>(digit*8))&255)]++; 
				//array element, the byte of the current digit
			}
			
			for(int i=1; i<257; i++)
			{
				buckets[i]=buckets[i]+buckets[i-1];
			}
			
			for(int i=0; i<array.length; i++)
			{
				buffer[buckets[(int)(array[i]>>(digit*8)&255)]]=array[i];
				buckets[(int)(array[i]>>(digit*8)&255)]++;
			}
			
			int []temp=buffer;
			buffer=array;
			array=temp;
			zeroBuckets(buckets);
		}
		stop=System.nanoTime();
		
		System.out.println("RADIX SORT TOOK: "+(stop-start));
		
	}
	
	public void checkSort()
	{
		System.out.println();
		Arrays.sort(ogArray);
		if(Arrays.equals(ogArray, array))
			System.out.println("RadixSort worked!");
		else
			System.out.println("RadixSort bombed!");
	}

}
