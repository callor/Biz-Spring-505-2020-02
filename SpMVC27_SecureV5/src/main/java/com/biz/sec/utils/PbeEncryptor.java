package com.biz.sec.utils;

import java.util.Map;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PbeEncryptor {

	public static String getEncrypt(String plainText) {

		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();

		// 암호화를 하기위한 salt BIZ.COM 환경변수 값을 사용
		Map<String, String> envList = System.getenv();
		String strSalt = envList.get("BIZ.COM");
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(strSalt);
		return pbEnc.encrypt(plainText);

	}
}
