package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class FeesBody {

        public double amount;
        public int brn;
        public String version;
        public String servicelistVersion;
        @JsonProperty("Data")
        public ArrayList<Datum> data;

    public FeesBody(double amount,String version, String servicelistVersion, ArrayList<Datum> data) {
        this.amount = amount;
        this.version = version;
        this.servicelistVersion = servicelistVersion;
        this.data = data;
    }

    public class Datum{
        @JsonProperty("Key")
        public String key;
        @JsonProperty("Value")
        public String value;
    }
}
