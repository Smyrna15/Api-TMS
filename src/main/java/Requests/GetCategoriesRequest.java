package Requests;

import api.GetRequest;
import api.URI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import models.Customer;
import models.GetCategoriesResponse;
import repos.UserRepo;

import java.io.FileReader;
import java.util.ArrayList;

public class GetCategoriesRequest extends GetRequest {
    public GetCategoriesRequest() {
        super(new URI("http://10.90.3.158:8080/"), "api/services/categories/0?ServiceListVersion=0", GetCategoriesResponse.class);
        Customer eligibleCustomer = UserRepo.get("ValidCustomer");
        String token  = eligibleCustomer.login();
        addHeader("Authorization","Bearer "+token);
    }
    @SneakyThrows
    public  GetCategoriesResponse getResponse()
    {
        Gson objectMapper = new Gson();
        FileReader reader = new FileReader(".\\src\\test\\resources\\response.json");
        return objectMapper.fromJson(reader, GetCategoriesResponse.class);
    }
    public static void main (String [] args )
    {
        GetCategoriesRequest getCategoriesRequest= new GetCategoriesRequest();
        getCategoriesRequest.getResponse();
        ArrayList<GetCategoriesResponse.Service> result= getServices(getCategoriesRequest.getResponse());
        for(GetCategoriesResponse.Service o:result)
        System.out.println(o.serviceName +" : "+o.serviceID );
        System.out.println(result.size());

    }
    public ArrayList<GetCategoriesResponse.Service> getServices()
    {
        return  getServices(this.send().as(GetCategoriesResponse.class).serviceList.serviceCategory);
    }
    public static ArrayList<GetCategoriesResponse.Service> getServices(GetCategoriesResponse response )
    {
        return  getServices(response.serviceList.serviceCategory);
    }
    public static ArrayList<GetCategoriesResponse.Service> getServices(ArrayList<GetCategoriesResponse.ServiceCategory> list)
    {ArrayList<GetCategoriesResponse.Service> services= new ArrayList<>();
        for (GetCategoriesResponse.ServiceCategory item: list){
        if (item.services.isEmpty())
            services.addAll(getServices(item.serviceCategory));
        else services.addAll(item.services);
    }
    return services;
    }
}
