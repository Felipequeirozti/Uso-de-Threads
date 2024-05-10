import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[20];
        preencherVetor(array);
        int NUM_THREADS = 4;
        ThreadSum[] threads = new ThreadSum[NUM_THREADS];
        preencherThreads(threads, array);
        iniciarThreads(threads);
    }
    private static void preencherVetor(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
    }
    private static void preencherThreads(ThreadSum[] threads, int[] array) {
        int tamanhoPorThread = array.length / threads.length;
        for (int i = 0; i < threads.length; i++) {
            int inicio = i * tamanhoPorThread;
            int fim = (i == threads.length - 1) ? array.length : (i + 1) * tamanhoPorThread;
            threads[i] = new ThreadSum(array, inicio, fim, i);
        }
    }
    private static void iniciarThreads(ThreadSum[] threads) {
        for (ThreadSum thread : threads) {
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
