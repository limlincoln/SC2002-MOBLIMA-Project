package consolidators;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Interface IConsolidator.
 *
 * @param <T> the generic type
 */
public interface IConsolidator<T> {
    
    /**
	 * Get all ArrayList.
	 *
	 * @return ArrayList
	 */
    public abstract ArrayList<T> getAll();
}
