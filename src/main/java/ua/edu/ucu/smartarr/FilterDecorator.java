package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
	public FilterDecorator(SmartArray smartArray, MyPredicate filter) {
		super(applyFilter(smartArray, filter));
	}

	static BaseArray applyFilter(SmartArray smartArray, MyPredicate filter) {
		ArrayList<Object> filtered = new ArrayList<Object>();
		for (Object i:smartArray.toArray()) {
			if (filter.test(i)) {
				filtered.add(i);
			}
		}
		return new BaseArray(filtered);
	}

	public String operationDescription() {
        return "leaves objects that satisfy filtering function conditions";
	}

}
