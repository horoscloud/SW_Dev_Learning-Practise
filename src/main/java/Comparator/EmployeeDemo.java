package Comparator;

import java.util.Arrays;

public class EmployeeDemo {

    public static void main(String[] args) {

        Employee e1 = new Employee(34, "Flo", 235, "AT");
        Employee e2 = new Employee(13, "Chris", 310, "DE");
        Employee e3 = new Employee(64, "Blob", 140, "AT");
        Employee e4 = new Employee(235, "Adolf", 235, "AT");
        Employee e5 = new Employee(4, "Linkler", 310, "DE");
        Employee e6 = new Employee(67, "Rudolf", 140, "AT");

        Employee arr[] = new Employee[] {e1, e2, e3, e4, e5, e6};

        System.out.println(e1.compareTo(e2));
        System.out.println(e1.compareTo(e3));
        System.out.println(e2.compareTo(e1));
        System.out.println(e2.compareTo(e1));

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        Arrays.sort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));



    }

}
