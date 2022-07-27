package apis;

import DataProviders.ServiceDataProvider;
import DataReaders.ConverterUtil;
import io.restassured.response.Response;
import models.Customer;
import enums.SERVICE;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repos.InquiryRepo;
import repos.PaymentRepo;
import repos.UserRepo;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentTest {
    @DataProvider(name = "payment-provider")
    public Object[][] paymentProvider(){
        ArrayList<String[]> data  = new ServiceDataProvider().getPaymentData();
        return ConverterUtil.arraylistOfArrayTo2DArray(data);
    }

    @Test(dataProvider = "payment-provider")
    public void testPayment(String serviceName ,String serviceNumber ,String user, String line, String payment)
    {
//        precondition
        Customer eligibleCustomer = UserRepo.get(user);
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get(line).billingAccount;
        int brn = eligibleCustomer.getBrn(serviceNumber, InquiryRepo.get(line));
//        action
        Response resp = eligibleCustomer.pay(serviceNumber, PaymentRepo.get(payment, brn,billingAccount));
//        assert values in the response
        resp.prettyPrint();
     //   Assert.assertEquals(response.getStatusCode(), 200);

    }
}
