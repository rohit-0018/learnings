package org.example.threading;

public class ThreadingMain {
    public void execute() {
        System.out.println("Stated the execution");
//        ThreadingRunner runner = new BasicThreading();
        ThreadingRunner runner = new ModernPublisher();
        runner.maniExecutor();
    }
}
