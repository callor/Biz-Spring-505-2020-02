package com.biz.shop.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
/*
 * 키보드에서 문자열을 입력받아서
 * 암호화된 문자열을 생성
 */
public class MySQLEnc {

	public static void main(String[] args) {
		
		/*
		 * 로컬컴퓨터에 설정된 환경변수들 목록을 가져와서
		 * 그중에 BIZ.COM으로 등록된 값을 보여라
		 */
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		Map<String,String> envList = System.getenv();
		System.out.println(envList.get("BIZ.COM"));
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("MySQL UserName >> ");
		String userName = scanner.nextLine();
		
		System.out.print("MySQL Password >> ");
		String password = scanner.nextLine();
		
		/*
		 * 암호화를 하기 위한 설정
		 * 알고리즘과 Salt password 설정
		 */
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		
		// 환경변수에서 SALT 비번 가져오기
		pbEnc.setPassword(envList.get("BIZ.COM"));
		
		// BIZ.COM 문자열로 SALT 비번으로 하기
		// pbEnc.setPassword("BIZ.COM");

		String encUserName = pbEnc.encrypt(userName);
		String encPassword = pbEnc.encrypt(password);

		System.out.printf("userName : %s \n",encUserName);
		System.out.printf("password : %s \n",encPassword);
		
		ResourceLoader resLoader = new DefaultResourceLoader();
		Resource res 
		= resLoader.getResource("file:src/main/resources/"
				+ "db.connection2.properties");
				
		String saveUserName = String.format("mysql.username=%s",
							encUserName);
		String savePassword = String.format("mysql.password=%s",
							encPassword);
		
			PrintWriter out;
			try {
				
				out = new PrintWriter(res.getFile());
				out.println(saveUserName);
				out.println(savePassword);
				out.flush();
				out.close();
				System.out.println(res.getFile().toString() 
							+ " 저장 완료!!!");
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		scanner.close();
		

	}
}





