public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                System.out.println("We are in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });

        thread.setName("New Worker Thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in a new thread
                throw new RuntimeException("Intentional Exception");
            }
        });

        thread2.setName("Misbehaving thread");

        thread2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("A critical error happened in thread " + t.getName() + " the error is " + e.getMessage());
            }
        });
        thread2.start();
    }
}