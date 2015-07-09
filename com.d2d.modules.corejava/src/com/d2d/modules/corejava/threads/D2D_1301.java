package com.d2d.modules.corejava.threads;

public class D2D_1301 extends Thread
{
    private String msg;

    public D2D_1301( String msg )
    {
        this.msg = msg;
    }

    @Override
    public void run()
    {
        System.out.println( msg );
    }

    public static void main( String[] args )
    {
        D2D_1301 obj1 = new D2D_1301( "Hello" );
        D2D_1301 obj2 = new D2D_1301( "World" );

        // Doing this implies that run() is triggered as a normal function call
        // and not as a Thread
        // NOT CORRECT WAY OF TRIGGERING THREADS
        // obj1.run();
        // obj2.run();
        
        // Start the threads
        obj1.start();
        obj2.start();
    }

}
