package ua.edu.ucu;


public class Student {

    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object s2) {
        if (this.getClass() != s2.getClass()) {
            return false;
        }
        Student sB = (Student) s2;
        return (this.getName() == sB.getName())
        && (this.getSurname() == sB.getSurname())
        && (this.getYear() == sB.getYear())
        && (this.getGPA() == sB.getGPA());
    }
}
