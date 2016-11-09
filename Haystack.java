import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONObject;


public class Haystack extends HttpPost {
		  public static void main(String[] args) throws Exception {
			    URL url = new URL("http://challenge.code2040.org/api/haystack");
			    URLConnection conn = url.openConnection();
			    conn.setDoOutput(true);
			    conn.setRequestProperty("Content-Type", "application/json");
			    OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
			    String param = "{ \"token\":\"9de8c90bab0ff108fa09081b925a47c1\"}";
			    writer.write(param);
			    writer.flush();
			    String line;
			    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    while ((line = reader.readLine()) != null)
			      {	
			    	System.out.println(line);
				    JSONObject jsonObject = new JSONObject(line);
			        String needle = (jsonObject.getString("needle"));
			        JSONArray haystack = (jsonObject.getJSONArray("haystack"));
			        
			        for(int i=0;i<haystack.length();i++) {
			            if(needle.equals(haystack.get(i))) {
			                System.out.println("Found item at index " + i);
			                
				            String param2 = "{ \"token\":\"9de8c90bab0ff108fa09081b925a47c1\",\"needle\":\"" + i + "\"}";
				            URL url2 = new URL("http://challenge.code2040.org/api/haystack/validate");
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
				      	  }
					    }
			        
			      }	 
		  }  		        
}		  			    