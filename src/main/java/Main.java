public class Main {

    public static final ProductBuffer<Object> productBuffer = new ProductBuffer<>(5);

    public static void main(String[] args) {
        Thread producer = new Producer(productBuffer, 100);
        producer.start();
    }

}
