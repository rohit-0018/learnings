package org.example.threading;

import org.example.threading.locks.ReentrantLockMain;
import org.example.threading.locks.SemaphoresMain;

public class ThreadingMain {
    public void execute() {
        System.out.println("Stated the execution");
//        ThreadingRunner runner = new BasicThreading();
//        ThreadingRunner runner = new ModernPublisher();
//        ThreadingRunner runner = new PingPong();
//        ThreadingRunner runner = new ToyBox();

//        ThreadingRunner runner = new SharedResourceMain();
//        ThreadingRunner runner = new ReentrantLockMain();
        ThreadingRunner runner = new SemaphoresMain();
        runner.mainExecutor();

    }
}
