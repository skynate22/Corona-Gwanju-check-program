package com.boar.crn.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PatientInfo_parser {
	
	public Map<Integer, List<String>> getBasicInformation(Document doc) {
		Elements routeInfoList = doc.select("tbody tr");
		
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		int count = 0;
		for(Element infoItem : routeInfoList) {
			Elements infoItemList = infoItem.select("table.in_default tr");
			
			List<String> list = new ArrayList<String>();
			
			for(Element basicItem : infoItemList) {
			String content = basicItem.select("tr td.txt_left").text();
			list.add(content);
		}
		
			if (!list.isEmpty()) {
				map.put(count, list);
				count++;
		}
	}
	return map;
 }
}