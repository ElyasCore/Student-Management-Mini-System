import java.util.Scanner;
public class Main {
    public static int choice(Scanner in) {
        while (true) {
            System.out.print("Error, choose a number between 1-5: ");
            int x = in.nextInt();
            if (x == 1 || x == 2 || x == 3 || x == 4 || x == 5) {
                return x;
            }
        }
    }
    public static int grades(Scanner in) {
        int x;
        while (true) {
            System.out.print("Error, enter a number between 0-100: ");
            x = in.nextInt();
            if (x <= 100 && x >= 0) {
                break;
            }
        }
        return x;
    }
    static String name;
    static int age;
    static String major;
    static int num1;
    static int num2;
    static int num3;
    public static void addStudent(Scanner in) {
        in.nextLine();
        System.out.print("Student name: ");
        name = in.nextLine();
        System.out.print("Student age: ");
        age = in.nextInt();
        in.nextLine();
        if (age < 18 || age > 23) {
            while (true) {
                System.out.print("Invalid student age, try again:  ");
                age = in.nextInt();
                if (age >= 18 && age <= 23) {
                    break;
                }
            }
        }
        System.out.print("Student major: ");
        major = in.nextLine();
        System.out.println("Add 3 Student Grades");
        System.out.print("Grade #1: ");
        num1 = in.nextInt();
        if (num1 > 100 || num1 < 0) {
            num1 = grades(in);
        }
        System.out.print("Grade #2: ");
        num2 = in.nextInt();
        if (num2 > 100 || num2 < 0) {
            num2 = grades(in);
        }
        System.out.print("Grade #3: ");
        num3 = in.nextInt();
        if (num3 > 100 || num3 < 0) {
            num3 = grades(in);
        }
    }
    public static void showStudent() {
        System.out.println("Student name: " + name);
        System.out.println("Student age: " + age);
        System.out.println("Student major: " + major);
        System.out.println("Grade #1: " + num1);
        System.out.println("Grade #2: " + num2);
        System.out.println("Grade #3: " + num3);
    }
    public static double calculateAverage() {
        return (num1 + num2 + num3)/3.0;
    }
    public static void checkGrade() {
        if (calculateAverage() >= 90) {
            System.out.println("A");
        }else if (calculateAverage() >= 80) {
            System.out.println("B");
        }else if (calculateAverage() >= 70) {
            System.out.println("C");
        }else if (calculateAverage() >= 60) {
            System.out.println("D");
        }else {
            System.out.println("F");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean studentAdded = false;
        int a;
        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Show Student");
            System.out.println("3. Calculate Average");
            System.out.println("4. Check Grade");
            System.out.println("5. Exit");
            a = in.nextInt();
            if (a != 1 && a != 2 && a != 3 && a != 4 && a != 5) {
                a = choice(in);
            }
            switch (a) {
                case 1:
                    addStudent(in);
                    studentAdded = true;
                    break;
                case 2:
                    if (studentAdded) {
                        showStudent();
                    } else {
                        System.out.println("Please add a student first.");
                    }
                    break;
                case 3:
                    if (studentAdded) {
                        System.out.println("Grades average: " + calculateAverage());
                    } else {
                        System.out.println("Please add a student first.");
                    }
                    break;
                case 4:
                    if (studentAdded) {
                        System.out.print("Grade is: ");
                        checkGrade();
                    } else {
                        System.out.println("Please add a student first.");
                    }
            }
            if (a == 5) {
                break;
            }
        }
    }
}
