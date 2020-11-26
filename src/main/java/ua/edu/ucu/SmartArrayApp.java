package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        SmartArray arr = new BaseArray(students);
        arr = new DistinctDecorator(arr);
        MyPredicate prYear2 = new MyPredicate() {
        public boolean test(Object t) {
            String str = t.toString();
            int s = str.indexOf("year=");
            int e = str.substring(s+5, str.length()).indexOf("}");
            int year = Integer.parseInt(str.substring(s+5, s+e+5));
            return year == 2;
            }
        };
        MyPredicate prGPAg4 = new MyPredicate() {
            public boolean test(Object t) {
                String str = t.toString();
                int s = str.indexOf("GPA=");
                int e = str.substring(s+4, str.length()).indexOf(",");
                Float gpa = Float.parseFloat(str.substring(s+4, s+e+4));
                return gpa >= 4;
            }
        };
        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str;
                int s;
                int e;
                str = o1.toString();
                s = str.indexOf("surname=");
                e = str.substring(s+8, str.length()).indexOf(",");
                String s1 = str.substring(s+8, s+e+8);
                str = o2.toString();
                s = str.indexOf("surname=");
                e = str.substring(s+8, str.length()).indexOf(",");
                String s2 = str.substring(s+8, s+e+8);
                return s1.compareTo(s2);
            }
        };

        arr = new FilterDecorator(arr, prYear2);
        //System.out.println(arr.toString());
        arr = new FilterDecorator(arr, prGPAg4);
        //System.out.println(arr.toString());
        arr = new SortDecorator(arr, cmp);
         //System.out.println(arr.toString());
        arr = new DistinctDecorator(arr);


        String[] names = new String[arr.size()];
        int j = 0;
        for (Object t:arr.toArray()) {
            int s;
            int e;
            String name = "";
            String str = t.toString();
            s = str.indexOf("name=");
            str = str.substring(s+5, str.length());
            e = str.indexOf(",");
            name += str.substring(0, e)+" ";
            s = str.indexOf("surname=");
            str = str.substring(s+8, str.length());
            e = str.indexOf(",");
            name += str.substring(0, e);
            names[j] = name;
            j++;
        }
        return names;
    }
}
