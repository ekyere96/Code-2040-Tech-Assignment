import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.TimeZone;

import org.json.JSONObject;

public class DatingGame extends HttpPost {
	  public static void main(String[] args) throws Exception {
		    URL url = new URL("http://challenge.code2040.org/api/dating");
		    URLConnection conn = url.openConnection();
		    conn.setDoOutput(true);
		    conn.setRequestProperty("Content-Type", "application/json");
		    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
		    String param = "{ \"token\":\"9de8c90bab0ff108fa09081b925a47c1\"}";
		    writer.write(param);
		    writer.flush();
		    String line;
		    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    while ((line = reader.readLine()) != null) {
			      System.out.println(line);
		    

		      JSONObject jsonObject = new JSONObject(line);
		      String datestamp = jsonObject.getString("datestamp");
		      int interval = (jsonObject.getInt("interval"));
		      
		      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		      sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		      Date sec = sdf.parse(datestamp);
		      System.out.println(datestamp);
		      
		      long a = sec.getTime();
		      long b = (a + (interval * 1000));
		      
		      	Date date=new Date(b);
		        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		        df2.setTimeZone(TimeZone.getTimeZone("UTC"));
		        String validTime = df2.format(date);

		    
		      String param2 = "{ \"token\":\"9de8c90bab0ff108fa09081b925a47c1\",\"datestamp\":\"" + validTime + "\"}";
		      System.out.println(param2);
		      URL url2 = new URL("http://challenge.code2040.org/api/dating/validate");
			    URLConnection conn2 = url2.openConnection();
			    conn2.setDoOutput(true);
			    conn2.setRequestProperty("Content-Type", "application/json");
			    OutputStreamWriter writer2 = new OutputStreamWriter(conn2.getOutputStream());
			    writer2.write(param2); 
			    writer2.flush();
			    String line2;
			    BufferedReader reader2 = new BufferedReader(new InputStreamReader(conn2.getInputStream()));
			    while ((line2 = reader2.readLine()) != null) {
			      System.out.println(line2);
			    }
		    writer.close();
		    reader.close();
		    }
	  }
}