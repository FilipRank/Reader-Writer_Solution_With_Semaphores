import java.util.ArrayList;

/**
 * Essentially an ArrayList with a public maximum size constant.
 */
public class ProductBuffer<T> extends ArrayList<T> {
    public final int MAX_SIZE;

    public ProductBuffer(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public boolean isFull() {
        if (this.size() < MAX_SIZE) {
            return false;
        }
        return true;
    }
}
