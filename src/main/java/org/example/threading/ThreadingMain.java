package org.example.threading;

public class ThreadingMain {
    public void execute() {
        System.out.println("Stated the execution");
//        ThreadingRunner runner = new BasicThreading();
//        ThreadingRunner runner = new ModernPublisher();
//        ThreadingRunner runner = new PingPong();
        ThreadingRunner runner = new ToyBox();

        runner.maniExecutor();
    }
}
