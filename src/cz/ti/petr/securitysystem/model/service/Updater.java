package cz.ti.petr.securitysystem.model.service;

import cz.ti.petr.securitysystem.model.security.MySecurityManager;

/**
 * Třída představující aktualizační kontrolku
 */
public class Updater extends Thread {

    private static boolean running = true;
    private MySecurityManager sm;

    public Updater(MySecurityManager sm) {
        this.sm = sm;
    }

    public static void stopAll() {
        running = false;
    }

    public void terminate() {
        running = false;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (running) {
            sm.update();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
