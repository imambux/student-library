package com.imambux;

import java.util.Random;

public class Student implements Runnable {

  private int id;
  private Book[] books;
  private Random random;

  public Student(int id, Book[] books) {
    this.id = id;
    this.books = books;
    this.random = new Random();
  }

  @Override
  public void run() {
    while (true) {
      // select a random book
      int bookId = random.nextInt(books.length);

      try {
        // read the selected book if available
        books[bookId].read(this);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        '}';
  }

}
