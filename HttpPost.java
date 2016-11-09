import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
public class HttpPost {
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
	    while ((line = reader.readLine()) != null) {
	      System.out.println(line);
	    }
	    writer.close();
	    reader.close();

	 }
}

