package ua.edu.ucu.smartarr;

import java.util.ArrayList;

// Base array for decorators
public class BaseArray implements SmartArray {

	private ArrayList<Object> arr;

	public BaseArray() {
		this.arr = new ArrayList<Object>();
	}

	public BaseArray(Object[] arr) {
		//initialize from Object[]
		this.arr = new ArrayList<Object>();
		for (Object i:arr) {
			this.arr.add(i);
		}
	}

	public BaseArray(ArrayList<Object> arr) {
		//initialize from Object[]
		this.arr = arr;
	}

	public Object[] toArray() {
		return this.arr.toArray(new Object[this.size()]);
	}

	public int size() {
		return this.arr.size();
	}

	public String operationDescription() {
		return "basic storage of elements";
	}

	public String toString() {
		return this.arr.toString();
	}
}
