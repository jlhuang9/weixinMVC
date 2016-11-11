package com.lianchuang.util;

/**
 * 常量
 * @author herosky
 *
 */
public class Constants {
	/**
	 * APPID
	 */
	public static String APPID = "wx7717b36a8ae348b9";
	/**
	 * SECRET
	 */
	public static String SECRET = "d1eb86d7073a11b02e48e6773caeab4b";
	/**
	 * 获取ACCESS_TOKEN接口
	 */
	public static String GET_ACCESSTOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/**
	 * ACCESS_TOKEN有效时间(单位：ms)
	 */
	public static int EFFECTIVE_TIME = 700000;
	/**
	 * conf.properties文件路径
	 */
	public static String CONF_PROPERTIES_PATH = "src/conf/config.properties";


	public static String OVERDUE_ACCESS_TOKEN_TIME = "1477574224376";
	public static String ACCESS_TOKEN = "auIGnYUPDjEEo0Ez2RtRs9r8xieWWk_tcEnIz-vcsV9taHfna0kVKti5nF1e0XrqARPtwjf77JgbnD7Jqk8OEmhyBYEfBJgLxJz_77atNC0nCmTDFqowfP6ysSbkY14qUQEfACACYM";
	/**
	 * 微信接入token ，用于验证微信接口
	 */
	public static String TOKEN = "iKuai";
}
