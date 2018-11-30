/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.free.code.utils.http;

import com.alibaba.fastjson.JSONArray;
import com.free.code.utils.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 *@ClassName HttpClientUtils
 *@Description HTTP客户端工具类（支持HTTPS）
 *@Author hsiangcn@sina.com
 *@Date 2018/11/28 11:35
 *@Version 1.0
 */
public class HttpClientUtils {

	/**
	 *  HTTP / HTTPS 的 GET 请求
	 *  	默认编码集为：UTF-8
	 *
	 * @param: [url]
	 * @return: java.lang.String
	 * @auther: user
	 * @date: 2018/11/28 11:47
	 */
	public static String doGet(String url){
		return doGet(url, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 *  HTTP / HTTPS 的 GET 请求
	 *	可指定编码集，若未指定编码集默认为：UTF-8
	 *
	 * @param: [url, charset]
	 * @return: java.lang.String
	 * @auther: user
	 * @date: 2018/11/28 11:47
	 */
	public static String doGet(String url, String charset){
		HttpGet httpGet = new HttpGet(url);
		checkCharset(charset);
		return executeRequest(httpGet, charset);
	}

	/**
	 * 	HTTP / HTTPS doPost 请求，传递JSON字符串格式参数，
	 * 	默认编码集为：UTF-8
	 *
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doPost(String url, String param) {
		return HttpClientUtils.doPost(url, param, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 *
	 * HTTP / HTTPS doPost 请求，传递JSON字符串格式参数，
	 *	可指定编码集，若未指定编码集默认为：UTF-8
	 * @param:
	 * @return:
	 * @auther: user
	 * @date: 2018/11/28 11:38
	 */
	public static String doPost(String url, String param, String charset) {
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		try {
			if (StringUtils.isNotBlank(param)) {
				checkCharset(charset);
				//设置请求头
				httpPost.setHeader(HttpHeaders.CONTENT_TYPE, HttpHeaders.APPLICATION_JSON);
				httpPost.setEntity(new StringEntity(param));
				result = executeRequest(httpPost, charset);
				return result;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 	HTTP / HTTPS doPost 请求，传递JSON字符串格式参数，
	 * 	默认编码集为：UTF-8
	 *
	 * @param url
	 * @param paramMap
	 * @return
	 */
	public static String doPost(String url, Map<String, String> paramMap) {
		return doPost(url, paramMap, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 * 	HTTP / HTTPS doPost 请求，传递map格式参数，
	 * 	可指定编码集，若未指定编码集默认为：UTF-8
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 */
	public static String doPost(String url, Map<String, String> paramMap, String charset) {
		HttpPost httpPost = new HttpPost(url);
		String result = null;
		try {
			if (paramMap != null){
				checkCharset(charset);
				List<NameValuePair> nvps = Arrays.asList();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, charset);
				formEntity.setContentEncoding(charset);
				httpPost.setEntity(formEntity);
				result = executeRequest(httpPost, charset);
			}
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 功能描述: http / https 的GET请求,增加异步请求头参数
	 *	默认字符集为：UTF-8
	 * @param: [url]
	 * @return: java.lang.String
	 * @auther: user
	 * @date: 2018/11/28 11:56
	 */
	public static String ajaxGet(String url) {
		return ajaxGet(url, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 * 功能描述: 功能描述: http / https 的GET请求,增加异步请求头参数
	 *	可指定编码集，若未指定编码集默认为：UTF-8
	 * @param: [url, charset]
	 * @return: java.lang.String
	 * @auther: user
	 * @date: 2018/11/28 11:57
	 */
	public static String ajaxGet(String url, String charset) {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader(HttpHeaders.X_REQUESTED_WITH, HttpHeaders.XML_HTTP_REQUEST);
		checkCharset(charset);
		return ajaxGet(url, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 * 	HTTP / HTTPS Post 请求,增加异步请求头参数，传递JSON字符串格式参数，
	 * 	默认编码集为：UTF-8
	 *
	 * @param url
	 * @param param
	 * @return
	 */
	public static String ajaxPost(String url, String param) {
		return HttpClientUtils.ajaxPost(url, param, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 *
	 * HTTP / HTTPS Post 请求,增加异步请求头参数，传递JSON字符串格式参数，
	 *	可指定编码集，若未指定编码集默认为：UTF-8
	 * @auther: user
	 * @date: 2018/11/28 11:38
	 */
	public static String ajaxPost(String url, String param, String charset) {
		String result = null;
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(HttpHeaders.X_REQUESTED_WITH, HttpHeaders.XML_HTTP_REQUEST);
		try {
			if (StringUtils.isNotBlank(param)) {
				checkCharset(charset);
				//设置请求头
				httpPost.setHeader(HttpHeaders.CONTENT_TYPE, HttpHeaders.APPLICATION_JSON);
				httpPost.setEntity(new StringEntity(param));
				result = executeRequest(httpPost, charset);
				return result;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 	HTTP / HTTPS doPost 请求，增加异步请求头参数，传递JSON字符串格式参数，
	 * 	默认编码集为：UTF-8
	 *
	 * @param url
	 * @param paramMap
	 * @return
	 */
	public static String ajaxPost(String url, Map<String, String> paramMap) {
		return ajaxPost(url, paramMap, HttpHeaders.CHARSET_UTF_8);
	}

	/**
	 * 	HTTP / HTTPS doPost 请求，增加异步请求头参数，传递map格式参数，
	 * 	可指定编码集，若未指定编码集默认为：UTF-8
	 * @param url
	 * @param paramMap
	 * @param charset
	 * @return
	 */
	public static String ajaxPost(String url, Map<String, String> paramMap, String charset) {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(HttpHeaders.X_REQUESTED_WITH, HttpHeaders.XML_HTTP_REQUEST);
		String result = null;
		try {
			if (paramMap != null){
				checkCharset(charset);
				List<NameValuePair> nvps = Arrays.asList();
				for (Map.Entry<String, String> entry : paramMap.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
				}
				UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(nvps, charset);
				formEntity.setContentEncoding(charset);
				httpPost.setEntity(formEntity);
				result = executeRequest(httpPost, charset);
			}
		} catch (UnsupportedEncodingException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 *  检查charset字符集是否为空，为空设置为UTF-8
	 *
	 * @param: [charset]
	 * @return: void
	 * @auther: user
	 * @date: 2018/11/28 11:55
	 */
	private static void checkCharset(String charset) {
		if (StringUtils.isBlank(charset)) {
			charset = HttpHeaders.CHARSET_UTF_8;
		}
	}

	/**
	 *	执行一个http/https请求，传递HttpGet或HttpPost参数
	 *
	 * @param httpRequest
	 * @param charset
	 * @return
	 */
	private static String executeRequest(HttpUriRequest httpRequest, String charset) {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		HttpEntity entity = null;
		String result = null;
		try {
			if (HttpHeaders.HTTPS.equalsIgnoreCase(httpRequest.getURI().getScheme())) {
				httpclient = createSSLInsecureClient();
			} else {
				httpclient = HttpClients.createDefault();
			}
			response = httpclient.execute(httpRequest);
			entity = response.getEntity();
			result = EntityUtils.toString(entity);
		} catch (Exception ex) {

		} finally {
			try {
				EntityUtils.consume(entity);
				response.close();
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 创建 SSL连接
	 */
	private static CloseableHttpClient createSSLInsecureClient(){
		try {
			SSLContext ctx = new SSLContextBuilder().loadTrustMaterial(new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					// 信任所有
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(ctx, new HostnameVerifier() {
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			});
			return HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (GeneralSecurityException ex) {
			throw new RuntimeException(ex);
		}
	}

//	public static void main(String[] args) {
//		System.out.println(doPost("https://admin2.ccsdapp.com/app/login/userinfo","{\"user_code\": \"1037619709159591936\"}"));
//	}

}
