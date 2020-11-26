package ua.edu.ucu.smartarr;
import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
	public MapDecorator(SmartArray smartArray, MyFunction filter) {
		super(applyFilter(smartArray, filter));
	}

	static BaseArray applyFilter(SmartArray smartArray, MyFunction filter) {
		Object[] mapped = smartArray.toArray();
		for (int i = 0; i < smartArray.size(); i++) {
			mapped[i] = filter.apply(mapped[i]);
		}
		return new BaseArray(mapped);
	}

	public String operationDescription() {
        return "leaves objects that satisfy filtering function conditions";
	}

}
