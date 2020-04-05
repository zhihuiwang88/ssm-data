 package com.json.web.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

/**
* Apache Httpclient 4.X 工具包装类
<dependency>
    <groupId>org.apache.httpcomponents</groupId>
    <artifactId>httpclient</artifactId>
    <version>4.5.6</version>
</dependency>
*/
public class HttpClientNewUtil {
	
	private static final String CHARSET_UTF8 = "UTF-8";
	
	/**
	 * Get方式提交,URL中包含查询参数, 格式：http://www.g.cn?search=p&name=s.....
	 * 
	 * @param url
	 * 提交地址
	 * @return 响应消息
	 */
	public static String get(String url) throws Exception{
		return get(url, null, null);
	}
	
	
	/**
	 * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 查询参数集, 键/值对
	 * @return 响应消息
	 */
	public static String get(String url, Map params) throws Exception{
		return get(url, params, null);
	}
	
	
	/**
	 * Get方式提交,URL中不包含查询参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 查询参数集, 键/值对
	 * @param charset
	 * 参数提交编码集
	 * @return 响应消息
	 */
	public static String get(String url, Map params, String charset)throws Exception {
		if (url == null || StringUtils.isEmpty(url)) {
			return null;
		}
		List qparams = getParamsList(params);
		if (qparams != null && qparams.size() > 0) {
			charset = (charset == null ? CHARSET_UTF8 : charset);
			String formatParams = URLEncodedUtils.format(qparams, charset);
			url = (url.indexOf("?")) < 0 ? (url + "?" + formatParams) : (url
					.substring(0, url.indexOf("?") + 1) + formatParams);
		}
		HttpResponse response = null;
		HttpEntity entity = null;
		HttpClient client = new DefaultHttpClient();
		setHttpCilentTimeOut(client);
		HttpGet hg = new HttpGet(url);
		// 发送请求，得到响应
		response = client.execute(hg);
		try {
			entity = response.getEntity();
			if (response.getEntity() != null) {
				return EntityUtils.toString(response.getEntity());
			}
		} catch(Exception e){
			throw e;
		}finally {
			if (entity != null)
				entity.consumeContent();
			client.getConnectionManager().shutdown();
		}
		return null;
	}


	private static void setHttpCilentTimeOut(HttpClient client) {
		client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
		client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 60000);
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @return 响应消息
	 */
	public static String post(String url, Map params)throws Exception {
		return post(url, params, null);
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @param charset
	 * 参数提交编码集
	 * @return 响应消息
	 */
	public static String post(String url, Map params, String charset)throws Exception {
		if (url == null || StringUtils.isEmpty(url)) {
			return null;
		}
		// 创建HttpClient实例
		HttpResponse response = null;
		HttpEntity entity = null;
		HttpClient client = new DefaultHttpClient();
		setHttpCilentTimeOut(client);
		UrlEncodedFormEntity formEntity = null;
		try {
			if (charset == null || StringUtils.isEmpty(charset)) {
				formEntity = new UrlEncodedFormEntity(getParamsList(params));
			} else {
				formEntity = new UrlEncodedFormEntity(getParamsList(params), charset);
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("不支持的编码集", e);
		}
		HttpPost hp = new HttpPost(url); 
		hp.addHeader("Referer","10.148.68.72");
		hp.setEntity(formEntity);
		// 发送请求，得到响应
		response = client.execute(hp);
		try {
			entity = response.getEntity();
			if (response.getEntity() != null) {
				return EntityUtils.toString(response.getEntity());
			}
		} catch(Exception e){
			throw e;
		}finally {
			if (entity != null)
				entity.consumeContent();
			client.getConnectionManager().shutdown();
		}
		return null;
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @return 响应消息
	 */
	public static String postXml(String url, String Xml) throws Exception {
		return postXml(url, Xml, null);
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @param charset
	 * 参数提交编码集
	 * @return 响应消息
	 */
	public static String postXml(String url, String Xml, String charset) throws Exception {
		if (url == null || StringUtils.isEmpty(url)) {
			return null;
		}
		// 创建HttpClient实例
		HttpResponse response = null;
		HttpEntity entity = null;
		HttpClient client = new DefaultHttpClient();
		setHttpCilentTimeOut(client);
		StringEntity myEntity = new StringEntity(Xml,charset==null?CHARSET_UTF8:charset);
		
		HttpPost hp = new HttpPost(url); 
		hp.addHeader("Content-type", "application/xml");
		hp.setEntity(myEntity);
		// 发送请求，得到响应
		response = client.execute(hp);
		try {
			entity = response.getEntity();
			if (response.getEntity() != null) {
				return EntityUtils.toString(response.getEntity());
			}
		} catch(Exception e){
			throw e;
		}finally {
			if (entity != null)
				entity.consumeContent();
			client.getConnectionManager().shutdown();
		}
		
		
		return null;
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @return 响应消息
	 */
	public static String postJson(String url, String json)throws Exception  {
		return postJson(url, json, null);
	}
	
	
	/**
	 * Post方式提交,URL中不包含提交参数, 格式：http://www.g.cn
	 * 
	 * @param url
	 * 提交地址
	 * @param params
	 * 提交参数集, 键/值对
	 * @param charset
	 * 参数提交编码集
	 * @return 响应消息
	 */
	public static String postJson(String url, String json, String charset) throws Exception {
		if (url == null || StringUtils.isEmpty(url)) {
			return null;
		}
		// 创建HttpClient实例
		HttpResponse response = null;
		HttpEntity entity = null;
		HttpClient client = new DefaultHttpClient();
		setHttpCilentTimeOut(client);
		StringEntity myEntity = new StringEntity(json,charset==null?CHARSET_UTF8:charset);
		
		HttpPost hp = new HttpPost(url); 
		hp.addHeader("Content-type", "application/json");
		hp.setEntity(myEntity);
		// 发送请求，得到响应
		response = client.execute(hp);
		try {
			entity = response.getEntity();
			if (response.getEntity() != null) {
				return EntityUtils.toString(response.getEntity());
			}
		} catch(Exception e){
			throw e;
		}finally {
			if (entity != null)
				entity.consumeContent();
			client.getConnectionManager().shutdown();
		}
		
		
		return null;
	}
	

	
	/**
	 * 将传入的键/值对参数转换为NameValuePair参数集
	 * @param paramsMap
	 * 参数集, 键/值对
	 * @return NameValuePair参数集
	 */
	private static List getParamsList(Map paramsMap) {
		if (paramsMap == null || paramsMap.size() == 0) {
			return null;
		}
		List params = new ArrayList();
		Iterator<Map.Entry<String, Object>> it = paramsMap.entrySet().iterator();
		while (it.hasNext()) {
		   Map.Entry<String, Object> entry = it.next();
		   params.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		}
		return params;
	}
	
	
	
	/** 
     * 发送https请求 
     * 为单向请求 
     * @param url 
     * @param xmlStr 
     * @return 
     */  
    public static String httpsPost(String url,Map params) {  
        long responseLength = 0;                         //响应长度    
        String responseContent = "";                     //响应内容    
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例  
        setHttpCilentTimeOut(httpClient);
        X509TrustManager xtm = new X509TrustManager(){   //创建TrustManager    
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public X509Certificate[] getAcceptedIssuers() {   
                return null;   //return new java.security.cert.X509Certificate[0];    
            }  
        };    
        try {    
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext    
            SSLContext ctx = SSLContext.getInstance("TLS");    
                
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用    
            ctx.init(null, new TrustManager[]{xtm}, null);    
                
            //创建SSLSocketFactory    
          //SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);  
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);  
                
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上    
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));    
                
            HttpPost httpPost = new HttpPost(url); 
            //创建HttpPost    
//            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数    
//            for(Map.Entry<String,String> entry : params.entrySet()){    
//                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));    
//            }    
            UrlEncodedFormEntity formEntity = null;
    		try {
    			formEntity = new UrlEncodedFormEntity(getParamsList(params),CHARSET_UTF8);
    		} catch (UnsupportedEncodingException e) {
    			throw new RuntimeException("不支持的编码集", e);
    		}
    		httpPost.addHeader("Referer","20.124.143.20");
            httpPost.setEntity(formEntity);    
                
            HttpResponse response = httpClient.execute(httpPost); //执行POST请求    
            HttpEntity entity = response.getEntity();             //获取响应实体    
                
            if (null != entity) {    
                responseLength = entity.getContentLength();    
                responseContent = EntityUtils.toString(entity, "UTF-8");    
                EntityUtils.consume(entity); //Consume response content    
            }    
        } catch (KeyManagementException e) {    
            e.printStackTrace();    
        } catch (NoSuchAlgorithmException e) {    
            e.printStackTrace();    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        } catch (ClientProtocolException e) {    
            e.printStackTrace();    
        } catch (ParseException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源    
        }  
        return responseContent;  
    } 
    public static String httpsPostJson(String url,String jsonStr) {  
        long responseLength = 0;                         //响应长度    
        String responseContent = "";                     //响应内容    
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例  
        setHttpCilentTimeOut(httpClient);
        X509TrustManager xtm = new X509TrustManager(){   //创建TrustManager    
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public X509Certificate[] getAcceptedIssuers() {   
                return null;   //return new java.security.cert.X509Certificate[0];    
            }  
        };    
        try {    
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext    
            SSLContext ctx = SSLContext.getInstance("TLS");    
                
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用    
            ctx.init(null, new TrustManager[]{xtm}, null);    
                
            //创建SSLSocketFactory    
          //SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);  
            SSLSocketFactory socketFactory = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);    
                
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上    
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));    
                
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/json");
            //创建HttpPost    
//            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数    
//            for(Map.Entry<String,String> entry : params.entrySet()){    
//                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));    
//            }    
            StringEntity myEntity = new StringEntity(jsonStr,CHARSET_UTF8);
            httpPost.setEntity(myEntity);    
                
            HttpResponse response = httpClient.execute(httpPost); //执行POST请求    
            HttpEntity entity = response.getEntity();             //获取响应实体    
                
            if (null != entity) {    
                responseLength = entity.getContentLength();    
                responseContent = EntityUtils.toString(entity, "UTF-8");    
                EntityUtils.consume(entity); //Consume response content    
            }    
        } catch (KeyManagementException e) {    
            e.printStackTrace();    
        } catch (NoSuchAlgorithmException e) {    
            e.printStackTrace();    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        } catch (ClientProtocolException e) {    
            e.printStackTrace();    
        } catch (ParseException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源    
        }  
        return responseContent;  
    }
    
    
    private static final String KEY_STORE_TYPE_TRUST = "jks"; //如果证书为bks格式，那么要改为bks，同时下面的KEY_STORE_TYPE_CLIENT也要改为bks  
//  private static final String KEY_STORE_TYPE_CLIENT = "PKCS12"; //如果KEY_STORE_TYPE_TRUST为jks，则KEY_STORE_TYPE_CLIENT为PKCS12  
    private static final String KEY_STORE_TYPE_CLIENT = "PKCS12"; //如果KEY_STORE_TYPE_TRUST为bks，则
    public static String httpsPostJson2(String url,String jsonStr) throws Exception {  
        long responseLength = 0;                         //响应长度    
        String responseContent = "";                     //响应内容    
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例    
        setHttpCilentTimeOut(httpClient);    
        try {    
        	 KeyStore keyStore  = KeyStore.getInstance(KeyStore.getDefaultType());  
        	 KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());  
            // KeyStore trustStore  = KeyStore.getInstance(KEY_STORE_TYPE_TRUST);  
             InputStream ksIn = new FileInputStream("./arkeystore");  
             InputStream tsIn = new FileInputStream(new File("./arkeystore"));  
             try {  
                keyStore.load(ksIn, "anrong123".toCharArray());  
                 trustStore.load(tsIn, "anrong123".toCharArray());  
             } finally {  
                 try { ksIn.close(); } catch (Exception ignore) {}  
                 try { tsIn.close(); } catch (Exception ignore) {}  
             }  
             //双向验证加载keystore和truststore两个证书  
            // SSLSocketFactory socketFactory = new SSLSocketFactory(keyStore, "anrong123", trustStore);  
             SSLSocketFactory socketFactory = new SSLSocketFactory("TLS", keyStore, "anrong123", trustStore, null, null, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
             
             /* 
              * 单向验证，只加载truststore 
             SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore); 
             */  
             //SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore); 
             
             Scheme sch = new Scheme("https", 443, socketFactory);  
             httpClient.getConnectionManager().getSchemeRegistry().register(sch); 
        	
        	
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/json");
            //创建HttpPost    
//            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数    
//            for(Map.Entry<String,String> entry : params.entrySet()){    
//                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));    
//            }    
            StringEntity myEntity = new StringEntity(jsonStr,CHARSET_UTF8);
            httpPost.setEntity(myEntity);    
                
            HttpResponse response = httpClient.execute(httpPost); //执行POST请求    
            HttpEntity entity = response.getEntity();             //获取响应实体    
                
            if (null != entity) {    
                responseLength = entity.getContentLength();    
                responseContent = EntityUtils.toString(entity, "UTF-8");    
                EntityUtils.consume(entity); //Consume response content    
            }    
        } catch (KeyManagementException e) {    
            e.printStackTrace();    
        } catch (NoSuchAlgorithmException e) {    
            e.printStackTrace();    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        } catch (ClientProtocolException e) {    
            e.printStackTrace();    
        } catch (ParseException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源    
        }  
        return responseContent;  
    }
    public static String httpsPostJson3(String url,String jsonStr) throws Exception {  
        long responseLength = 0;                         //响应长度    
        String responseContent = "";                     //响应内容    
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例    
        setHttpCilentTimeOut(httpClient);  
        try {    
        	httpClient =WebClientDevWrapper.wrapClient(httpClient);
        	
        	
            HttpPost httpPost = new HttpPost(url);  
            httpPost.addHeader("Content-type", "application/json");
            //创建HttpPost    
//            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数    
//            for(Map.Entry<String,String> entry : params.entrySet()){    
//                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));    
//            }    
            StringEntity myEntity = new StringEntity(jsonStr,CHARSET_UTF8);
            httpPost.setEntity(myEntity);    
                
            HttpResponse response = httpClient.execute(httpPost); //执行POST请求    
            HttpEntity entity = response.getEntity();             //获取响应实体    
                
            if (null != entity) {    
                responseLength = entity.getContentLength();    
                responseContent = EntityUtils.toString(entity, "UTF-8");    
                EntityUtils.consume(entity); //Consume response content    
            }    
        }  catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        } catch (ClientProtocolException e) {    
            e.printStackTrace();    
        } catch (ParseException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源    
        }  
        return responseContent;  
    }
    
    /**
     * 避免HttpClient的”SSLPeerUnverifiedException: peer not authenticated”异常
     * 不用导入SSL证书
     * @author shipengzhi(shipengzhi@sogou-inc.com)
     *
     */
    public static class WebClientDevWrapper {

        public static org.apache.http.client.HttpClient wrapClient(org.apache.http.client.HttpClient base) {
            try {
                SSLContext ctx = SSLContext.getInstance("TLS");
                X509TrustManager tm = new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {}
                };
                ctx.init(null, new TrustManager[] { tm }, null);
                SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                SchemeRegistry registry = new SchemeRegistry();
                registry.register(new Scheme("https", 443, ssf));
                ThreadSafeClientConnManager mgr = new ThreadSafeClientConnManager(registry);
                return new DefaultHttpClient(mgr, base.getParams());
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            }
        }
    }
	/** 
     * 发送https请求 
     * 为单向请求 
     * @param url 
     * @param xmlStr 
     * @return 
     */  
    public static String httpsPostXml(String url,String xmlStr) {  
        long responseLength = 0;                         //响应长度    
        String responseContent = "";                     //响应内容    
        HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例  
        setHttpCilentTimeOut(httpClient);
        X509TrustManager xtm = new X509TrustManager(){   //创建TrustManager    
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}    
            public X509Certificate[] getAcceptedIssuers() {   
                return null;   //return new java.security.cert.X509Certificate[0];    
            }  
        };    
        try {    
            //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext    
            SSLContext ctx = SSLContext.getInstance("TLS");    
                
            //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用    
            ctx.init(null, new TrustManager[]{xtm}, null);    
                
            //创建SSLSocketFactory    
            //SSLSocketFactory socketFactory = new SSLSocketFactory(ctx);    
            SSLSocketFactory socketFactory =new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
            //通过SchemeRegistry将SSLSocketFactory注册到我们的HttpClient上    
            httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 443, socketFactory));    
                
            HttpPost httpPost = new HttpPost(url);
            httpPost.addHeader("Content-type", "application/xml");
            //创建HttpPost    
//            List<NameValuePair> formParams = new ArrayList<NameValuePair>(); //构建POST请求的表单参数    
//            for(Map.Entry<String,String> entry : params.entrySet()){    
//                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));    
//            }    
            httpPost.setEntity(new StringEntity(xmlStr, "UTF-8"));    
                
            HttpResponse response = httpClient.execute(httpPost); //执行POST请求    
            HttpEntity entity = response.getEntity();             //获取响应实体    
                
            if (null != entity) {    
                responseLength = entity.getContentLength();    
                responseContent = EntityUtils.toString(entity, "UTF-8");    
                EntityUtils.consume(entity); //Consume response content    
            }    
        } catch (KeyManagementException e) {    
            e.printStackTrace();    
        } catch (NoSuchAlgorithmException e) {    
            e.printStackTrace();    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        } catch (ClientProtocolException e) {    
            e.printStackTrace();    
        } catch (ParseException e) {    
            e.printStackTrace();    
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源    
        }  
        return responseContent;  
    }  
}