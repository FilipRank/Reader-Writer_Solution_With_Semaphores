/**
 * Removes a product from a given product buffer every n milliseconds.
 * Throws RuntimeException if buffer empty during consumption.
 **/
class Consumer extends Thread {
    private int milliseconds;
    private ProductBuffer productBuffer;

    public Consumer(ProductBuffer productBuffer, int milliseconds) {
        this.productBuffer = productBuffer;
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        startConsuming();
    }

    private void startConsuming() {
        while (productBuffer.size() > 0) {
            productBuffer.remove(productBuffer.size() - 1);
            try {
                sleep(milliseconds);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(productBuffer);
        }
        throw new RuntimeException("Consumer trying to consume from empty List.");
    }
}
