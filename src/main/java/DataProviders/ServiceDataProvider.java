package DataProviders;

import DataReaders.CsvReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceDataProvider {
    CsvReader csvReader= new CsvReader("src/test/resources/testdata/TestData.csv");
    public ArrayList<String[]>  getInquiryData(){
        ArrayList<String[]> data = csvReader.getDataAsRows();
        List<String> Values=new ArrayList<>();
        String [] arrayValues={};
        ArrayList<String[]> inquiryData= new ArrayList<>();
        for (int i=1;i< data.size();i++)
        {
            if((data.get(i)[2]).equalsIgnoreCase("y"))
            {
                System.out.println(data.get(i)[0]);
                Values.add( (data.get(i)[0]) ); //service name
                Values.add( (data.get(i)[1]) ); //service id
                Values.add( (data.get(i)[3]) ); //user
                Values.add( (data.get(i)[4]) ); //line

             inquiryData.add(Values.toArray(new String[Values.size()]));
            }
            Values.clear();
        }
        return inquiryData;
    }
    public ArrayList<String[]>  getFeeData(){
        ArrayList<String[]> data = csvReader.getDataAsRows();
        ArrayList<String> Values=new ArrayList<>();
        ArrayList<String[]> feeData= new ArrayList<>();
        for (int i=1;i< data.size();i++)
        {

                Values.add( (data.get(i)[0]) ); //service name
                Values.add( (data.get(i)[1]) ); //service id
                Values.add( (data.get(i)[3]) ); //user
                Values.add( (data.get(i)[4]) ); //line
                Values.add( (data.get(i)[5]) ); //fee
                //service name
                feeData.add( Values.toArray(new String[Values.size()]));
            Values.clear();
        }

        return feeData;
    }
    public ArrayList<String[]>  getPaymentData(){
        ArrayList<String[]> data = csvReader.getDataAsRows();
        ArrayList<String> Values=new ArrayList<>();
        ArrayList<String[]> paymentData= new ArrayList<>();
        for (int i=1;i< data.size();i++)
        {

            Values.add( (data.get(i)[0]) ); //service name
            Values.add( (data.get(i)[1]) ); //service id
            Values.add( (data.get(i)[3]) ); //user
            Values.add( (data.get(i)[4]) ); //line
            Values.add( (data.get(i)[6]) ); //payment
            //service name
            paymentData.add( Values.toArray(new String[Values.size()]));
            Values.clear();
        }
        return paymentData;
    }

}
