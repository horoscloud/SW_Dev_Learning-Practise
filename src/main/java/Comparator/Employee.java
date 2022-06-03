package Comparator;

import java.util.Objects;

public class Employee implements Comparable<Employee>{

    private int empNumber;
    private String name;
    private double salary;
    private String department;

    public Employee(int empNumber, String name, double salary, String department) {
        this.empNumber = empNumber;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }


    //GETTER
    public int getEmpNumber() {return empNumber;}
    public String getName() {return name;}
    public double getSalary() {return salary;}
    public String getDepartment() {return department;}


    //SETTER
    public void setName(String name) {this.name = name;}
    public void setSalary(double salary) {this.salary = salary;}
    public void setDepartment(String department) {this.department = department;}

    //EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empNumber == employee.empNumber;
    }

    //HASHCODE
    @Override
    public int hashCode() {
        return Objects.hash(empNumber);
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "empNumber=" + empNumber +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee o) {

        //-1 = Kleiner
        // 0 = Gleich
        // 1 = Größer

        if(empNumber < o.getEmpNumber()){
            return -1;
        }
        if(empNumber == o.getEmpNumber()){
            return 0;
        }
        if(empNumber > o.getEmpNumber()){
            return 1;
        }

       return 0;
    }
}
