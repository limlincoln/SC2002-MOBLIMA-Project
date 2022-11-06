package entities;

abstract class ISeatLayout {
    ISeat[][] layout;
    public abstract void createLayout();
    public ISeat[][] getLayout() {
        return this.layout;
    }

    public void setLayout(ISeat[][] layout) {
        this.layout = layout;
    }

}
