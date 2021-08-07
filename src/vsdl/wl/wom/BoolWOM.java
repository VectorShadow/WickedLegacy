package vsdl.wl.wom;

public class BoolWOM extends WickedObjectModel {
    private final boolean VALUE;

    public BoolWOM(boolean value) {
        VALUE = value;
    }

    public boolean value() {
        return VALUE;
    }
}
