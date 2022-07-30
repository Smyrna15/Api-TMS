package apis;

import DataProviders.DynamicServiceDataProvider;
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
        ArrayList<String[]> data  = new DynamicServiceDataProvider().getAllData();
        return ConverterUtil.arraylistOfArrayTo2DArray(data);
    }

    @Test(dataProvider = "payment-provider")
    public void testPaymentWithValidCustomerAndMobileLineAndValidPayment(String serviceName ,String serviceNumber )
    {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get("gobus_line").billingAccount;
        int brn = eligibleCustomer.getBrn(serviceNumber, InquiryRepo.get("gobus_line"));
//        action
        Response resp = eligibleCustomer.pay(serviceNumber, PaymentRepo.get("ValidPayment", brn,billingAccount));
//        assert values in the response
        resp.prettyPrint();
     //   Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test(dataProvider = "payment-provider")
    public void testPaymentWithValidCustomerAndMobileLineAndInvalidPayment(String serviceName ,String serviceNumber )
    {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get("gobus_line").billingAccount;
        int brn = eligibleCustomer.getBrn(serviceNumber, InquiryRepo.get("gobus_line"));
//        action
        Response resp = eligibleCustomer.pay(serviceNumber, PaymentRepo.get("InvalidPayment", brn,billingAccount));
//        assert values in the response
        resp.prettyPrint();
        //   Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test(dataProvider = "payment-provider")
    public void testPaymentWithInvalidCustomerAndMobileLineAndValidPayment(String serviceName ,String serviceNumber )
    {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("InvalidCustomer");
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get("gobus_line").billingAccount;
        int brn = eligibleCustomer.getBrn(serviceNumber, InquiryRepo.get("gobus_line"));
//        action
        Response resp = eligibleCustomer.pay(serviceNumber, PaymentRepo.get("ValidPayment", brn,billingAccount));
//        assert values in the response
        resp.prettyPrint();
        //   Assert.assertEquals(response.getStatusCode(), 200);

    }
    @Test(dataProvider = "payment-provider")
    public void testPaymentWithInvalidCustomerAndMobileLineAndInvalidBRN(String serviceName ,String serviceNumber )
    {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("InvalidCustomer");
        String token  = eligibleCustomer.login();
        String billingAccount= InquiryRepo.get("gobus_line").billingAccount;
        int brn = eligibleCustomer.getBrn(serviceNumber, InquiryRepo.get("gobus_line"));
//        action
        Response resp = eligibleCustomer.pay(serviceNumber, PaymentRepo.get("ValidPayment", 0,billingAccount));
//        assert values in the response
        resp.prettyPrint();
        //   Assert.assertEquals(response.getStatusCode(), 200);

    }
}
