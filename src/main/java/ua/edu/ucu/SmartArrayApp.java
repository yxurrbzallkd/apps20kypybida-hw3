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
                    public boolean test(Object obj) {
                        return ((Student) obj).getYear() == 2;
                    }
                };
                MyPredicate prGPAg4 = new MyPredicate() {
                    public boolean test(Object obj) {
                        return ((Student) obj).getGPA() >= 4;
                    }
                };
                MyComparator cmp = new MyComparator() {
                    @Override
                    public int compare(Object oA, Object oB) {
                        return ((Student) oA).getSurname().compareTo(((Student) oB).getSurname());
                    }
                };
        
                arr = new FilterDecorator(arr, prYear2);
                arr = new FilterDecorator(arr, prGPAg4);
                arr = new SortDecorator(arr, cmp);
                arr = new DistinctDecorator(arr);
         
                String[] names = new String[arr.size()];
                int i = 0;
                Student student;
                for (Object obj:arr.toArray()){
                    student = (Student) obj; //convert
                    names[i] = student.getSurname()+" "+student.getName();
                    i++;
                }
                return names;
            }

}
