package models;

public class InquiryBody {
    public String billingAccount;
    public String version;
    public String serviceListVersion;
    public InquiryBody(String billingAccount, String version, String serviceListVersion) {
        this.billingAccount = billingAccount;
        this.version = version;
        this.serviceListVersion = serviceListVersion;
    }
}
