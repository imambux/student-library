package com.imambux;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

  public static void main(String[] args) {
    Book[] books = new Book[Constants.NUM_OF_BOOKS];
    Student[] students = new Student[Constants.NUM_OF_STUDENTS];

    ExecutorService executorService = Executors.newFixedThreadPool(students.length);

    try {
      for (int i = 0; i < books.length; i++) {
        books[i] = new Book(i + 1);
      }

      for (int i = 0; i < students.length; i++) {
        students[i] = new Student(i + 1, books);
        executorService.execute(students[i]);
      }
    } finally {
      executorService.shutdown();
    }
  }

}
