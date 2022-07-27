package enums;

public enum SERVICE {
 
    shahry(767),gobus(646),EXTRA_QUOTA(214);
    private final int value;
    SERVICE(final int newValue) {
        value = newValue;
    }
    public int getValue() {
        return value;
    }
}
