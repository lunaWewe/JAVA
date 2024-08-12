package tw.luna.pretty;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class Luna61 {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx");
			URLConnection conn = url.openConnection();
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(bin));

			String line;
			StringBuffer sb = new StringBuffer(); // 把資料先做大字串進入再解析
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			bin.close();

			parseJSON(sb.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void parseJSON(String json) {
		JSONArray root = new JSONArray(json);
		System.out.println(root.length());

		for (int i = 0; i < root.length(); i++) {
			JSONObject element = root.getJSONObject(i);
			String name = element.getString("Name");
			String addr = element.getString("SalePlace");
			String tel = element.getString("ContactTel");
			System.out.printf("%s:%s:%s\n", name, addr, tel);
		}

	}

}
