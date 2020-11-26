package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    protected SmartArray smartArray;

    protected SmartArrayDecorator(SmartArray smartArray) {
        this.smartArray = smartArray;
    }

    public String toString() {
        return this.smartArray.toString();
    }

    public int size() {
        return this.smartArray.size();
    }

    public Object[] toArray() {
		return this.smartArray.toArray();
    }
}
