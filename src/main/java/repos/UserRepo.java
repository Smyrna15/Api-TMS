package repos;


import models.Customer;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
   static Map<String, Customer> userTestData = new HashMap<>()
    {{put("customer1",new Customer("111", "25802580", "6", "2", "3", "354125111789563", "2021-01-13T13:16:20", "1", "6" ,null,null)); //"en"
    }
    };
    public static Customer get(String customerLabel)
    {
        return  userTestData.get(customerLabel);
    }
}
