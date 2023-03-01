package sorting;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		Random myGenerator=new Random();
		int [] myArr= new int[200];
		for(int i=0; i<myArr.length; i++)
		{
			myArr[i]=myGenerator.nextInt(30);
		}
		
		insertionSort sortNow=new insertionSort(myArr);
		sortNow.sort();
		//sortNow.checkSort();
		
		selectionSort sortNow2=new selectionSort(myArr);
		sortNow2.sort();
		//sortNow2.checkSort();

		mergeSort sortNow3=new mergeSort(myArr);
		sortNow3.sort();
		//sortNow3.checkSort();
		
		quickSort sortNow4=new quickSort(myArr);
		sortNow4.sort();
		//sortNow4.checkSort();
		
		radixSort sortNow5=new radixSort(myArr);
		sortNow5.sort();
		//sortNow5.checkSort();
	}

}
