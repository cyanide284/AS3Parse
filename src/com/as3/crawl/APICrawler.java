package com.as3.crawl;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class APICrawler {

	public void createLinks(ArrayList APILinks) throws NoSuchAlgorithmException {

		String test = APILinks.get(6).toString();
		System.out.println(test);
		String fixedURL = "http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/";
		String generatedURL = fixedURL + test + ".html";
		System.out.println(generatedURL);

		try {
			Document doc = Jsoup.connect(generatedURL).get();
			String title = doc.html();
			System.out.println(title);
			
//			byte[] bytesOfMessage = generatedURL.getBytes("UTF-8");
//			MessageDigest md = MessageDigest.getInstance("MD5");
//			byte[] thedigest = md.digest(bytesOfMessage);
//			
//			for(byte b:thedigest){
//				System.out.println(b);
//			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
