package com.leonhom.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 *
 * 如果这个数字可以被 3 整除，输出 "fizz"。
 * 如果这个数字可以被 5 整除，输出"buzz"。
 * 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。
 * 例如，当n = 15，输出：1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 *
 * 假设有这么一个类：
 *
 * class FizzBuzz {
 * public FizzBuzz(int n) { ... }              // constructor
 * public void fizz(printFizz) { ... }          // only output "fizz"
 * public void buzz(printBuzz) { ... }          // only output "buzz"
 * public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
 * public void number(printNumber) { ... }      // only output the numbers
 * }
 * 请你实现一个有四个线程的多线程版FizzBuzz，同一个FizzBuzz实例会被如下四个线程使用：
 *
 * 线程A将调用fizz()来判断是否能被 3 整除，如果可以，则输出fizz。
 * 线程B将调用buzz()来判断是否能被 5 整除，如果可以，则输出buzz。
 * 线程C将调用fizzbuzz()来判断是否同时能被 3 和 5 整除，如果可以，则输出fizzbuzz。
 * 线程D将调用number()来实现输出既不能被 3 整除也不能被 5 整除的数字。
 *
 * @author: leon
 * @date: 2022/06/08
 */
public class LeetCode1195Medium {

    private int n;

    private volatile int num = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();


    public LeetCode1195Medium(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (num <= n) {
            lock.lock();
            try {
                // 能被3整除，不能被5整除
                if (num % 3 == 0 && num % 5 != 0) {
                    printFizz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (num <= n) {
            lock.lock();
            try {
                if (num % 3 != 0 && num % 5 == 0) {
                    printBuzz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (num <= n) {
            lock.lock();
            try {
                if (num % 3 == 0 && num % 5 == 0) {
                    printFizzBuzz.run();
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (num <= n) {
            lock.lock();
            try {
                if (num % 3 != 0 && num % 5 != 0) {
                    printNumber.accept(num);
                    num++;
                    condition.signalAll();
                } else {
                    condition.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
