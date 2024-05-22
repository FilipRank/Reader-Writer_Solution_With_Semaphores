/**
 * Adds a product to a given product buffer every n milliseconds.
 * Throws RuntimeException if maximum buffer size reached.
 **/
class Producer extends Thread {
    private final ProductBuffer<Object> productBuffer;
    private final int milliseconds;

    public Producer(ProductBuffer<Object> productBuffer, int milliseconds) {
        this.productBuffer = productBuffer;
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        startProducing(milliseconds);
    }

    public void startProducing(int n) {
        while (productBuffer.size() < productBuffer.MAX_SIZE) {
            productBuffer.add(new Object());
            try {
                sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(productBuffer);
        }
        throw new RuntimeException("Max sized reached.");
    }
}
