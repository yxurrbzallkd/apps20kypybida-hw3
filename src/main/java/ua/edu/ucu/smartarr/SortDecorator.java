package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyComparator;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
	public SortDecorator(SmartArray smartArray, MyComparator filter) {
		super(bubbleSort(smartArray, filter));
	}

	static BaseArray bubbleSort(SmartArray smartArray, MyComparator filter) {
		Object[] sorted = smartArray.toArray();
		int swipes = 1;
		Object temp;
		while (swipes != 0) {
			swipes = 0;
			for (int i = 0; i < smartArray.size()-1; i++) {
				if (filter.compare(sorted[i], sorted[i+1]) > 0) {
					temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
					swipes += 1;
				}
			}
		}
		return new BaseArray(sorted);
	}

	public String operationDescription() {
        return "sorts in ascending order as defined by given comparator";
	}

}
