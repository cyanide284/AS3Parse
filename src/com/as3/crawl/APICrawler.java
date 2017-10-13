package com.as3.crawl;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class APICrawler {

	public void createLinks(ArrayList<String> APILinks) throws NoSuchAlgorithmException {

		String test = APILinks.get(6).toString();
		System.out.println(test);
		String fixedURL = "http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/";
		String generatedURL = fixedURL + test + ".html";
		System.out.println(generatedURL);

		try {
			Document doc = Jsoup
					.connect(
							"http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/flash/utils/ByteArray.html")
					.get();
			
			Element methodTable = doc.getElementById("summaryTableMethod");
			Elements links = methodTable.getElementsByClass("signatureLink");

			ArrayList<String> clears = new ArrayList<String>();

			for (Element link : links) {
				String clear = link.getElementsByAttributeValue("href", "#clear()").toString();
				if (!clear.isEmpty()) {
					clears.add(clear);
				}
			}
			
			for(String clear:clears){
				System.out.println(clear);
			}

			// System.out.println(links);

			// System.out.println(title);

			// byte[] bytesOfMessage = generatedURL.getBytes("UTF-8");
			// MessageDigest md = MessageDigest.getInstance("MD5");
			// byte[] thedigest = md.digest(bytesOfMessage);
			//
			// for(byte b:thedigest){
			// System.out.println(b);
			// }

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}
