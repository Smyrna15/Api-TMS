package enums;

import models.Customer;

public enum USER {
    VALID(new Customer("111", "25802580", "6", "2", "3", "354125111789563", "2021-01-13T13:16:20",  "1", "6" ,null,null));
    private final Customer value;
    USER(final Customer newValue) {
        value = newValue;
    }
    public Customer getValue() {
        return value;
    }
}
