package menus;

import java.util.ArrayList;

public interface ISelectorMenu<T> {
    public T startSelector(ArrayList<T> list, String header);
}
