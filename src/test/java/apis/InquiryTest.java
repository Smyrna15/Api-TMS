package apis;

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
        ArrayList<String[]> data  = new ServiceDataProvider().getInquiryData();
        return  ConverterUtil.arraylistOfArrayTo2DArray(data);
    }



    @Test(dataProvider = "inquiry-provider")
    public void testInquiry(String serviceName ,String serviceNumber,  String user, String line) {
//        precondition
        System.out.println(serviceName);
        Customer eligibleCustomer = UserRepo.get(user);
//        action
        Response response=  eligibleCustomer.inquiry(serviceNumber, InquiryRepo.get(line));
//        assert values in the response
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
