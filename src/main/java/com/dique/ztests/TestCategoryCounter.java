package com.dique.ztests;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TestCategoryCounter {
	public Map<String, Integer> excecute() {
		String extension_html = ".html";

		String other_path = "./other";
		String web_path = "./web";
		String pcgame_path = "./pcgame";

		List<String> category_paths = new ArrayList<String>();
		category_paths.add(other_path);
		category_paths.add(web_path);
		category_paths.add(pcgame_path);

		Map<String, Integer> categories_count = category_count(category_paths, extension_html);

		return categories_count;

	}

	public static Map<String, Integer> category_count(List<String> paths, String extension) {
		List<String> category_paths = paths;
		String extension_html = extension;

		Map<String, Integer> categories_count = new HashMap<String, Integer>();

		for(int i = 0; i < category_paths.size(); i++) {
			String category_path = category_paths.get(i);
			int category_count = file_search(category_path, extension_html);

			String category = category_path.replace("./", "");
			categories_count.put(category, category_count);
		}

		return categories_count;

	}

	public static Integer file_search(String path, String extension) {
		File dir = new File(path);
		File files[] = dir.listFiles();
		int file_count = 0;
		for(int i=0; i<files.length; i++) {
			String file_name = files[i].getName();
			if(files[i].isDirectory()) {
				file_search(path + "/" + file_name, extension);
			}
			else {
				if(file_name.endsWith(extension)) {
					file_count++;
				}
			}
		}
		return file_count;

	}
}
