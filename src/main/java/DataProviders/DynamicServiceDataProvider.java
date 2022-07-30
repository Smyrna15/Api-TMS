package DataProviders;

import DataReaders.CsvReader;
import Requests.GetCategoriesRequest;
import models.GetCategoriesResponse;

import java.util.ArrayList;
import java.util.List;

public class DynamicServiceDataProvider {

    public ArrayList<String[]>  getInquiryData(){
        GetCategoriesRequest getCategoriesRequest= new GetCategoriesRequest();
        ArrayList<GetCategoriesResponse.Service> data=GetCategoriesRequest.getServices((GetCategoriesResponse) getCategoriesRequest.deserialize());
        List<String> Values=new ArrayList<>();
        ArrayList<String[]> inquiryData= new ArrayList<>();
        for (int i=1;i< data.size();i++)
        {
            if(data.get(i).inquirable==true)
            {
                Values.add( (data.get(i).serviceName )); //service name
                Values.add(String.valueOf (data.get(i).serviceID)); //service id
             inquiryData.add(Values.toArray(new String[Values.size()]));
            }
            Values.clear();
        }
        return inquiryData;
    }
    public ArrayList<String[]>  getAllData(){
        GetCategoriesRequest getCategoriesRequest= new GetCategoriesRequest();
        ArrayList<GetCategoriesResponse.Service> data=GetCategoriesRequest.getServices((GetCategoriesResponse) getCategoriesRequest.deserialize());
        List<String> Values=new ArrayList<>();
        ArrayList<String[]> inquiryData= new ArrayList<>();
        for (int i=1;i< data.size();i++)
        {
                Values.add( (data.get(i).serviceName )); //service name
                Values.add(String.valueOf (data.get(i).serviceID)); //service id
                inquiryData.add(Values.toArray(new String[Values.size()]));
            Values.clear();
        }
        return inquiryData;
    }

}
