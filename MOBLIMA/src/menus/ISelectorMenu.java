package menus;

import java.util.ArrayList;
/**
 * Interface for selectors
 */
public interface ISelectorMenu<T> {
    public T startSelector(ArrayList<T> list, String header);
}
