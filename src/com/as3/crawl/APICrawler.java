package com.as3.crawl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class APICrawler {

	public void createLinks(ArrayList<String> APILinks) throws NoSuchAlgorithmException {
		String fixedURL = "http://help.adobe.com/en_US/FlashPlatform/reference/actionscript/3/";
		BufferedWriter bw = null;
		try {
			 bw = new BufferedWriter(new FileWriter("../../../..//crawl.txt"));
			 for (String link : APILinks) {
					String generatedURL = fixedURL + link.toString() + ".html";
					
						Document doc = Jsoup.connect(generatedURL).get();
						
						Elements methods = doc.getElementsByClass("signatureLink");

						Elements clearMethods = doc.getElementsByAttributeValue("href", "#clear()");
						if(clearMethods.size()!=0)
							System.out.println(link.toString() + "\n" + clearMethods);
						bw.write(methods.toString());
				}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
