package repos;

import models.InquiryBody;

import java.util.HashMap;
import java.util.Map;

public class InquiryRepo {
   static Map<String, InquiryBody> inquiryTestData = new HashMap<>()
    {{
        put("gobus_line",new InquiryBody("01200341116",  "36", "6")); //"en"
        put("extraqouta_line",new InquiryBody("01000341116",  "36", "6")); //"en"
        put("shahry_line",new InquiryBody("01100341116",  "36", "6")); //"en"
        put("landline",new InquiryBody("0223750617",  "36", "6")); //"en"


    }
    };
    public static InquiryBody get(String line)
    {
        return  inquiryTestData.get(line);
    }
}
