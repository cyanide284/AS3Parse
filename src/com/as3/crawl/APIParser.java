package com.as3.crawl;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class APIParser {

	/**
	 * Parse the HTML to extract all links
	 * @param args
	 * @throws NoSuchAlgorithmException 
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {

		ArrayList<String> APILinks = new ArrayList<String>();

		try {
			//File to parse
			File file = new File("test1.html");
			//use the JSOUP parse method to create a document
			Document doc = Jsoup.parse(file, "UTF-8", "");

			//get all <a> tag elements
			Elements links = doc.getElementsByTag("a");
			//keep count of all extracted links
			int count = 0;
			//extract title from all <a> tag elements and add them to an ArrayList
			for (Element element : links) {
				count++;
				String linkHref = element.attr("title");
				APILinks.add(linkHref.replaceAll("\\.", "/"));
			}
			new APICrawler().createLinks(APILinks);
			System.out.println(count);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}
