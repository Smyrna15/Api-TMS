package models;

import java.util.ArrayList;

public class GetCategoriesResponse {
    public int code;
    public String message;
    public Object serviceListVersion;
    public ServiceList serviceList;
    public class Service{
        public int serviceID;
        public String serviceName;
        public double value;
        public String categoryTitle;
        public int paymentModeID;
        public int status;
        public String currency;
        public double minValue;
        public double maxValue;
        public int interval;
        public boolean inquirable;
        public int billPaymentModeID;
        public ArrayList<ServiceParameter> serviceParameter;
    }

    public class ServiceCategory{
        public int id;
        public String name;
        public int parentID;
        public boolean lastNode;
        public int index;
        public int level;
        public String serviceSubCategoryLabel;
        public ArrayList<Service> services;
        public ArrayList<ServiceCategory> serviceCategory;
    }

    public class ServiceList{
        public int id;
        public String name;
        public int parentID;
        public boolean lastNode;
        public int index;
        public int level;
        public String serviceSubCategoryLabel;
        public ArrayList<Object> services;
        public ArrayList<ServiceCategory> serviceCategory;
    }

    public class ServiceParameter{
        public String label;
        public String title;
        public String valueModeID;
        public String valueTypeID;
        public String optional;
        public String sequence;
        public String key;
        public ValueList valueList;
        public String value;
        public String validationExpression;
        public String validationMessage;
    }

    public class Value{
        public String key;
        public String value;
    }

    public class ValueList{
        public ArrayList<Value> values;
    }
}
