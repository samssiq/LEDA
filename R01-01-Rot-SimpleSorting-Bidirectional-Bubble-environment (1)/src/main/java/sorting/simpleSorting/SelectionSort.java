package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

import java.util.Arrays;
/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for(int j = leftIndex; j < rightIndex; j++){
			int smallest_one = j;	
			for (int i = j + 1; i <= rightIndex; i++ ){
				if(array[i].compareTo(array[smallest_one]) < 0){
						smallest_one = i;
				}	
		} if(array[j].compareTo(array[smallest_one]) > 0){
			Util.swap(array, j, smallest_one);
		}
		}
	}
}
