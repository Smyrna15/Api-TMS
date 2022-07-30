package apis;

import java.util.ArrayList;

import DataProviders.DynamicServiceDataProvider;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProviders.ServiceDataProvider;
import DataReaders.ConverterUtil;
import io.restassured.response.Response;
import models.Customer;
import repos.FeeRepo;
import repos.InquiryRepo;
import repos.UserRepo;

public class FeeTest {
    @DataProvider(name = "fee-provider")
    public Object[][] feeProvider(){
        ArrayList<String[]> data  = new DynamicServiceDataProvider().getAllData();
        return ConverterUtil.arraylistOfArrayTo2DArray(data);
    }



    @Test(dataProvider = "fee-provider")
    public void testFeesWithValidUserAndMobileLineAndValidFee(String serviceName ,String serviceId ) {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
        String token  = eligibleCustomer.login();
        int brn = eligibleCustomer.getBrn(serviceId , InquiryRepo.get("extraqouta_line"));
//        action
        Response resp = eligibleCustomer.getFees(serviceId, FeeRepo.get("ValidFee",brn));
//        assert values in the response
        resp.prettyPrint();
    //    Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(dataProvider = "fee-provider")
    public void testFeesWithValidUserAndMobileLineAndInvalidFee(String serviceName ,String serviceId ) {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
        String token  = eligibleCustomer.login();
        int brn = eligibleCustomer.getBrn(serviceId , InquiryRepo.get("extraqouta_line"));
//        action
        Response resp = eligibleCustomer.getFees(serviceId, FeeRepo.get("InvalidFee",brn));
//        assert values in the response
        resp.prettyPrint();
        //    Assert.assertEquals(response.getStatusCode(), 200);

    }


    @Test(dataProvider = "fee-provider")
    public void testFeesWithInvalidUserAndMobileLineAndValidFee(String serviceName ,String serviceId ) {
        System.out.println("Testing service:"+serviceName+".");
//        precondition
        Customer eligibleCustomer = UserRepo.get("InvalidCustomer");
        String token  = eligibleCustomer.login();
        int brn = eligibleCustomer.getBrn(serviceId , InquiryRepo.get("extraqouta_line"));
//        action
        Response resp = eligibleCustomer.getFees(serviceId, FeeRepo.get("ValidFee",brn));
//        assert values in the response
        resp.prettyPrint();
        //    Assert.assertEquals(response.getStatusCode(), 200);

    }

}
