package apis;

import java.util.ArrayList;

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
        ArrayList<String[]> data  = new ServiceDataProvider().getFeeData();
        return ConverterUtil.arraylistOfArrayTo2DArray(data);
    }



    @Test(dataProvider = "fee-provider")
    public void testFees(String serviceName ,String serviceId , String user, String line, String fee) {

//        precondition
        Customer eligibleCustomer = UserRepo.get(user);
        String token  = eligibleCustomer.login();
        int brn = eligibleCustomer.getBrn(serviceId , InquiryRepo.get(line));
//        action
        Response resp = eligibleCustomer.getFees(serviceId, FeeRepo.get(fee,brn));
//        assert values in the response
        resp.prettyPrint();
    //    Assert.assertEquals(response.getStatusCode(), 200);

    }



}
