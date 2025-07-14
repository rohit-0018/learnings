package org.example.singleton;

import org.example.PatternInteractor;

public class SingletonMain implements PatternInteractor {
    @Override
    public void interact() {
        System.out.println("Hello, Singleton class interaction!");
    }
}
