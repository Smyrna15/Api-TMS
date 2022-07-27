package repos;

import models.FeesBody;
import models.PaymentBody;

import java.util.HashMap;
import java.util.Map;

public class PaymentRepo {
   static Map<String, PaymentBody> paymentTestData = new HashMap<>()
    {{
        put("payment1",new PaymentBody("1", "36")); //"en"
    }
    };
    public static PaymentBody get(String paymentLabel, int brn,String billingAccount )
    {
        PaymentBody paymentBody= paymentTestData.get(paymentLabel);
        paymentBody.brn=brn;
        paymentBody.billingAccount=billingAccount;
        return  paymentBody;
    }
}
