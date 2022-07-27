package DataReaders;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CsvReader {
    String filePath;

    public CsvReader(String path) {
        this.filePath = FilenameUtils.separatorsToSystem(path);
    }

    public Map<String, String[]> getDataAsKeysAndRows() throws FileNotFoundException {
        Map<String, String[]> RowData = new HashMap<String, String[]>();
        Scanner sc = new Scanner(new File(filePath));
        //sets the delimiter pattern
        sc.useDelimiter("\\r\\n");
        while (sc.hasNext())  //returns a boolean value
        {
            String Data[] = sc.next().split(",");
            String Values[] = Arrays.copyOfRange(Data, 1, Data.length);
            RowData.put(Data[0], Values);
        }
        //closes the scanner
        sc.close();
        return RowData;
    }
    public  ArrayList<String[]> getDataAsRows()  {
       ArrayList<String[]> rowData = new ArrayList<>();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //sets the delimiter pattern
        sc.useDelimiter("\\r\\n");
        while (sc.hasNext())  //returns a boolean value
        {
            String Data[] = sc.next().split(",");
//            String Values[] = Arrays.copyOfRange(Data, 1, Data.length);
            rowData.add(Data);
        }
        //closes the scanner
        sc.close();
        return rowData;
    }
    public static void main(String [] args ) throws FileNotFoundException {
       CsvReader csvReader= new CsvReader("src/test/resources/ReqCfg.csv");
        ArrayList<String[]> data = csvReader.getDataAsRows();
//        Map<String, String[]> dataAsKeysAndRows = csvReader.getDataAsKeysAndRows();
//        for(Map.Entry<String, String[]> entry: dataAsKeysAndRows.entrySet()) {
////            System.out.print(entry);
//            System.out.println("data:"+entry.getKey()+",values"+entry.getValue().toString());
////            System.out.print(", ");
//        }
        for (int i =0;i< data.size();i++ )
        {
            System.out.println(data.get(i)[2]);
        }
    }

}
