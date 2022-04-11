package com.ejobim.opplat.util;

import net.sf.json.JSONArray;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class httpclient {
	/*入参说明
	* 
	* param url 请求地址
	* param jsonObject	请求的json数据
	* param encoding	编码格式
	* 
	* */
	public static String jsonPost(String url,JSONArray jsonObject,String encoding){
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		String response = null;
		try {
			StringEntity s = new StringEntity(jsonObject.toString());
			s.setContentEncoding(encoding);
			s.setContentType("application/json");//发送json数据需要设置contentType
			post.setEntity(s);
			HttpResponse res = httpclient.execute(post);
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				String result = EntityUtils.toString(res.getEntity());
				System.out.println(result);
			}
		} catch (Exception e) {throw new RuntimeException(e);}
			return response;
	}
	
	public static void main(String[] args) {
		
		JSONArray array = new JSONArray();
		array.add("/Hollysys_bewg_model/5c14f091884c7100012a483c/CuGeShan/1CuGeShan/geshan/ChaJinGuZhang");
		jsonPost("http://model-bewg-bewg.huawei.bewg.hiacloud.net.cn:80/aggquery/query/queryCurrent", array, "utf-8");
	}
}