package models;

public class PaymentBody {
    public String version;
    public String serviceListVersion;
    public String billingAccount;
    public int brn;

    public PaymentBody(String version, String serviceListVersion) {
        this.version = version;
        this.serviceListVersion = serviceListVersion;
    }
}
