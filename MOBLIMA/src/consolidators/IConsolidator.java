package consolidators;
import java.util.ArrayList;

public interface IConsolidator<T, E> {
    public abstract ArrayList<T> getAll(E e);
}
