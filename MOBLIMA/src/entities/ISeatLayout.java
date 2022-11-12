package entities;

import java.util.Optional;

// TODO: Auto-generated Javadoc
/**
 * The Class ISeatLayout.
 */
abstract class ISeatLayout {
    
    /** The layout. */
    ISeat[][] layout;
    
    /**
	 * Creates the layout.
	 *
	 * @param <T> the generic type
	 * @return the optional
	 */
    public abstract <T> Optional<T> createLayout();
    
    /**
	 * Gets the layout.
	 *
	 * @return the layout
	 */
    public ISeat[][] getLayout() {
        return this.layout;
    }

    /**
	 * Sets the layout.
	 *
	 * @param layout the new layout
	 */
    public void setLayout(ISeat[][] layout) {
        this.layout = layout;
    }

}
