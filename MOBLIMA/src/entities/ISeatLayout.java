package entities;

import java.util.Optional;

abstract class ISeatLayout {
    ISeat[][] layout;
    public abstract <T> Optional<T> createLayout();
    public ISeat[][] getLayout() {
        return this.layout;
    }

    public void setLayout(ISeat[][] layout) {
        this.layout = layout;
    }

}
