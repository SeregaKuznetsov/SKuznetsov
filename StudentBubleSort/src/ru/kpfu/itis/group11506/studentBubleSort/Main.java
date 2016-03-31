package ru.kpfu.itis.group11506.studentBubleSort;

import java.util.Random;

public class Main {

    public static void main(String[] args)
    {
        int count = 0;

        Student[] students = new Student[5];
        students[0] = new Student(74,"Leonardo","Dicaprio");
        students[1] = new Student(83,"Matt","Damon");
        students[2] = new Student(24,"Ryan","Reynolds");
        students[3] = new Student(55,"Michael","Fassbender");
        students[4] = new Student(55,"Bryan","Cranston");

        Student [] rndStudents = new Student[students.length];
        System.arraycopy(students,0,rndStudents,0,students.length);
        bubbleSort(students);

        System.out.println("Students after bubble sort:");
        showArray(students);
        mixRandomStudent(rndStudents);
        System.out.println("\nAfter mixed");
        showArray(rndStudents);
        while (!checkOrder(rndStudents, students)) {
            mixRandomStudent(rndStudents);
            count++;
        }
        System.out.println("\nNumber of random mixed count for " + students.length + " elements = " + count);
        showArray(rndStudents);
    }

    private static void bubbleSort(Student [] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if((arr[j].compareTo(arr[j+1])) == 1){
                    Student tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                else if((arr[j].compareTo(arr[j+1])) == 0) {
                    if((arr[j].compareToName(arr[j+1])) == 1) {
                        Student tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
            }
        }
    }

    private static void showArray(Student [] students) {
        for(int i = 0; i < students.length; i++)
        {
            System.out.println(students[i].score + " " +
                    students[i].last_name + " " + students[i].first_name);
        }
    }


    private static void mixRandomStudent(Student [] rndStudents) {
        Random rnd = new Random();
        int firstIndex;
        int secondIndex;
        for (int i = 0; i < 10; i++) {
            firstIndex = rnd.nextInt(rndStudents.length);
            secondIndex = rnd.nextInt(rndStudents.length);
            Student tmp = rndStudents[firstIndex];
            rndStudents[firstIndex] = rndStudents[secondIndex];
            rndStudents[secondIndex] = tmp;
        }
    }

    private static boolean checkOrder(Student [] arr1, Student [] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
