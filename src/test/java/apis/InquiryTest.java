package apis;

import DataProviders.DynamicServiceDataProvider;
import DataProviders.ServiceDataProvider;
import DataReaders.ConverterUtil;
import io.restassured.response.Response;
import models.Customer;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import repos.InquiryRepo;
import repos.UserRepo;

import java.util.ArrayList;

public class InquiryTest {
    @DataProvider(name = "inquiry-provider")
    public Object[][] inquiryProvider(){
        ArrayList<String[]> data  = new DynamicServiceDataProvider().getInquiryData();
        return  ConverterUtil.arraylistOfArrayTo2DArray(data);
    }


    @Test(dataProvider = "inquiry-provider")
    public void testInquiryWithValidUserAndMobileLine(String serviceName ,String serviceNumber) {
//        precondition
        System.out.println("Testing service:"+serviceName+".");
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
//        action
        Response response=  eligibleCustomer.inquiry(serviceNumber, InquiryRepo.get("extraqouta_line"));
//        assert values in the response
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "inquiry-provider")
    public void testInquiryWithValidUserAndLandLine(String serviceName ,String serviceNumber) {
//        precondition
        System.out.println("Testing service:"+serviceName+".");
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
//        action
        Response response=  eligibleCustomer.inquiry(serviceNumber, InquiryRepo.get("landline"));
//        assert values in the response
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test(dataProvider = "inquiry-provider")
    public void testInquiryWithInvalidUserAndLandLine(String serviceName ,String serviceNumber) {
//        precondition
        System.out.println("Testing service:"+serviceName+".");
        Customer eligibleCustomer = UserRepo.get("InvalidCustomer");
//        action
        Response response=  eligibleCustomer.inquiry(serviceNumber, InquiryRepo.get("landline"));
//        assert values in the response
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
