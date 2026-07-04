package fourthHometask;

public class ThreadSequence {
    private static final Object lock = new Object();
    private static boolean isThreadOneTurn = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!isThreadOneTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("1 ");
                    isThreadOneTurn = false;
                    lock.notify();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (isThreadOneTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("2 ");
                    isThreadOneTurn = true;
                    lock.notify();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
