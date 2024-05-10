public class ThreadSum extends Thread {
    private final int[] array;
    private final int inicio;
    private final int fim;
    private final int threadID;

    public ThreadSum(int[] array, int inicio, int fim, int threadID) {
        this.array = array;
        this.inicio = inicio;
        this.fim = fim;
        this.threadID = threadID;
    }
    @Override
    public void run() {
        System.out.println("Thread " + threadID + " iniciada.");
        int soma = 0;
        for (int i = inicio; i < fim; i++) {
            soma += array[i];
        }
        System.out.println("Thread " + threadID + " soma: " + soma);
    }
}