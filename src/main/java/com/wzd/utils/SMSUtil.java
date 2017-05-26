package com.wzd.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * 发送短信工具
 * 
 * @author WeiZiDong
 *
 */
public class SMSUtil {
	private static Log logger = LogFactory.getLog(SMSUtil.class);
	private static final String MSG_PATH = "https://api.netease.im/sms/sendtemplate.action";
	private static final String APP_KEY = "d3decf0df6fb068e25a64131b7ab2541";
	private static final String APP_SECRET = "efe43d82fc0c";

	public static String send(String templateid, String[] mobiles, String[] params) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = HttpClientUtil.createSSLInsecureClient();
			httpPost = new HttpPost(MSG_PATH);
			// 设置header
			String nonce = CheckSumBuilder.getMD5(Double.toString(Math.random()));
			String curTime = Long.toString(11L);
			httpPost.setHeader("AppKey", APP_KEY);
			httpPost.setHeader("CurTime", curTime);
			httpPost.setHeader("Nonce", nonce);
			httpPost.setHeader("CheckSum", CheckSumBuilder.getCheckSum(APP_SECRET, nonce, curTime));
			httpPost.setHeader("charset", "utf-8");
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("templateid", templateid));
			list.add(new BasicNameValuePair("mobiles", JSON.toJSONString(mobiles)));
			list.add(new BasicNameValuePair("params", JSON.toJSONString(params)));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
			httpPost.setEntity(entity);
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, "utf-8");
				}
			}
			logger.debug("发送短信中...");
			logger.debug("templateid：" + templateid);
			logger.debug("mobiles：" + JSON.toJSONString(mobiles));
			logger.debug("params：" + JSON.toJSONString(params));
			logger.debug("result：" + result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			HttpClientUtils.closeQuietly(httpClient);
		}
		return result;
	}
}
