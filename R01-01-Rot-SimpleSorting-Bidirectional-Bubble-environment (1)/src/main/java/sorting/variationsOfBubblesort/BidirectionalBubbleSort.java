package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This bubble sort variation has two internal iterations. In the first, it
 * pushes big elements to the right, like the normal bubble sort does. Then in
 * the second, iterates the array backwards, that is, from right to left, while
 * pushing small elements to the left. This process is repeated until the array
 * is sorted.
 */
public class BidirectionalBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {
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
				for (int v = rightIndex; v > leftIndex; v--) {
					if(array[v].compareTo(array[v - 1]) < 0){
						swapped = true;
						Util.swap(array, v, v - 1);
					}
				}
		}
	}
}
}

