package dataDriven;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
public class CreatingJSONDocument {
   public static void main(String args[]) {
      //Creating a JSONObject object
      JSONObject jsonObject = new JSONObject();
      //Inserting key-value pairs into the json object
      jsonObject.put("ID", "1");
      jsonObject.put("First_Name", "Ignasious");
      jsonObject.put("Last_Name", "Jegan");
      jsonObject.put("Date_Of_Birth", "07-12-1984");
      jsonObject.put("Place_Of_Birth", "Madurai");
      jsonObject.put("Country", "India");
      try {
         FileWriter file = new FileWriter(""
         		+ "");
         file.write(jsonObject.toJSONString());
         file.close();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println("JSON file created: "+jsonObject);
   }
}
