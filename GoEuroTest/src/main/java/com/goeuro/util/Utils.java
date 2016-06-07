package com.goeuro.util;

import org.apache.commons.lang3.CharEncoding;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Utils {

	public static String callURL(String url) throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		url = url.replaceAll(" ", "%20");
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		String responseBody = null;
		try {
			HttpEntity entity = response.getEntity();
			responseBody = EntityUtils.toString(entity, CharEncoding.UTF_8);
		} finally {
			response.close();
		}
		return responseBody;
	}
}
