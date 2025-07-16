package org.example.threading;

import org.example.threading.util.Resource;

public class SharedResourceMain implements ThreadingRunner{
    @Override
    public void maniExecutor() {
        Resource resource = new Resource();

        Thread t1 = new Thread(()-> {
                for(int i=0;i<100; i++) {
                    resource.push(i);
                }
        });

        Thread t2 = new Thread(()-> {
               for(int j =100; j<300; j++) {
                   resource.push(j);
           }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception ex) {
//            Exception ahdling
        }
        resource.print();
    }
}
