public class BooleanWrapper {
    private boolean value;

    // Constructors
    public BooleanWrapper() {
        this.value = false; // Default value
    }

    public BooleanWrapper(boolean value) {
        this.value = value;
    }
    public boolean get() {
        return value;
    }

    public void set(boolean value) {
        this.value = value;
    }
}
