package DataReaders;

import DataProviders.ServiceDataProvider;

import java.util.ArrayList;
import java.util.Arrays;

public class ConverterUtil {

    public static Object [] arraylistToArray(ArrayList<String[]> arrayList)
    {    int size = arrayList.size();
        Object  arrayData[]=new Object[size];
        for (int i= 0;i<size;i++){
            arrayData[i]= arrayList.get(i);
        }
        return arrayData;
    }
    public static Object [][] nestedArrayTo2DArray(Object[] nestedArray)
    {
        Object[][] twoDimentionalArray = Arrays.stream(nestedArray).map(Object[].class::cast).toArray(Object[][]::new);
        return twoDimentionalArray;
    }
    public static Object [][] arraylistOfArrayTo2DArray(ArrayList<String[]> arrayList)
    {   Object[] oneDimentionalArray = arraylistToArray(arrayList);
        Object[][] twoDimentional = Arrays.stream(oneDimentionalArray).map(Object[].class::cast).toArray(Object[][]::new);
        return twoDimentional;
    }
}
