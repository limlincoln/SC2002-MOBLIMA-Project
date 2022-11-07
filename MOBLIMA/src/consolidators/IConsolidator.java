package consolidators;
import java.util.ArrayList;

public interface IConsolidator<T> {
    public abstract ArrayList<T> getAll();
}
