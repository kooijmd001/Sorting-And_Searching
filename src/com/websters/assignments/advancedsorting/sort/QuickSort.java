package com.websters.assignments.advancedsorting.sort;


import com.websters.assignments.advancedsorting.model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class QuickSort {

    private ArrayList<Student> students;
    private Comparator<Student> comparer;

    public void sort(ArrayList<Student> students, Comparator<Student> comparer) {
        // check for empty or null array
        if (students ==null || students.size()==0){
            return;
        }
        this.students = students;
        this.comparer = comparer;
        int number = students.size();
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        Student pivot = students.get(low + (high-low)/2);

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (comparer.compare(students.get(i), pivot) < 0) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (comparer.compare(students.get(j), pivot) > 0) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        Student temp = students.get(i);
        students.set(i, students.get(j));
        students.set(j,  temp);
    }

    public ArrayList<Student> getSortedList(){
        return this.students;
    }
}