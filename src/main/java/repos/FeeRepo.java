package repos;

import models.FeesBody;

import java.util.HashMap;
import java.util.Map;

public class FeeRepo {
   static Map<String, FeesBody> feeTestData = new HashMap<>()
    {{
        put("fee1",new FeesBody(450.7, "36", "6",null)); //"en"
    }
    };
    public static FeesBody get(String feeLabel, int brn)
    {
        FeesBody feesBody= feeTestData.get(feeLabel);
        feesBody.brn=brn;
        return  feesBody;
    }
}
