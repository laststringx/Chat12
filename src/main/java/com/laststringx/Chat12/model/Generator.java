package com.laststringx.Chat12.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Generator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		String code;
		String data;
		while (!((str = br.readLine()).equals("done"))) {
			int index = str.indexOf(" ");
			code = str.substring(0, index);
			data = str.substring(index, str.length());
		
		}
	}
}
