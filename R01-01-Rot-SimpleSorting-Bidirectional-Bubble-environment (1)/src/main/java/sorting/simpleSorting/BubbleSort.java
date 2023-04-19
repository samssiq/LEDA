package sorting.simpleSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;
/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex){
		if(!((array.length <= 1) || (leftIndex > rightIndex) || (rightIndex >= array.length) || (leftIndex < 0))){
		boolean swapped = true;
			while (swapped){
				swapped = false;
				for (int j = leftIndex; j < rightIndex; j++){
					if(array[j].compareTo(array[j + 1]) > 0){
						swapped = true;
						Util.swap(array, j, j + 1);
					}
				}
		}
	}
}
}
