package ua.edu.ucu.smartarr;
import java.util.ArrayList;


// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {
    public DistinctDecorator(SmartArray smartArray) {
		//keep only distinct elements in array
		super(keepUnique(smartArray));
	}

	static BaseArray keepUnique(SmartArray smartArray) {
		ArrayList<Object> unique = new ArrayList<Object>();
		boolean found;
		for (Object i:smartArray.toArray()) {
			found = false;
			for (Object j:unique) {
				if (i.equals(j)) {
					found = true;
					break;
				}
			}
			if (!found) {
				unique.add(i);
			}
		}
		return new BaseArray(unique);
	}

	public String operationDescription() {
        return "leaves unique objects only";
    }
}
