package com.wzd.utils;

import java.util.Random;

public class CodeUtil {
	private static String codes = "23456789ABCDEFGHJKMNPQRSTUVWXYZ";
	private static Random r = new Random();

	// 随机生成一个字符
	private static char randomChar() {
		int index = r.nextInt(codes.length());
		return codes.charAt(index);
	}

	// 生成指定长度的随机字符
	public static String get(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			String s = randomChar() + "";
			sb.append(s);
		}
		return sb.toString();
	}
}
