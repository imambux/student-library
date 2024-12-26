package com.imambux;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {

  private int id;
  // locks the current book via Lock
  private Lock lock;

  public Book(int id) {
    this.id = id;
    this.lock = new ReentrantLock();
  }

  public void read(Student student) throws InterruptedException {
    // Try to acquire the lock "of book" within 10 seconds
    if (lock.tryLock(10, TimeUnit.SECONDS)) {
      System.out.printf("%s starts reading %s%n", student, this);

      // Student reads the book for 2 seconds
      Thread.sleep(2000);

      // give the book back by giving the lock back (unlock)
      lock.unlock();

      System.out.printf("%s has just finished reading %s%n", student, this);
    }
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        '}';
  }
}
