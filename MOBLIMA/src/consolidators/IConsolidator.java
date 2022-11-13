package consolidators;
import java.util.ArrayList;

/**
 * Interfacee for Object consolidators 
 */
public interface IConsolidator<T> {
    public abstract ArrayList<T> getAll();
}
