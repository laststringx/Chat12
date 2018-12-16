package com.laststringx.Chat12.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.laststringx.Chat12.model.TextAnalyzer;

@RestController
public class Driver {
	TextAnalyzer analyzer = new TextAnalyzer();

	@RequestMapping("/hello")
	public String sayHello() {
		return analyzer.getData();
	}

	@RequestMapping(value = "/ai/{userInput}", method = RequestMethod.GET)
	@ResponseBody
	public static String creatingResponse(@PathVariable("userInput") String userInput) throws InterruptedException {
		TextAnalyzer analyzer = new TextAnalyzer();
		/*
		 * System.out.println(analyzer.extractProperNouns(analyzer.tagPos(
		 * userInput))); return "Keywords detected from your text input :: " +
		 * analyzer.extractProperNouns(analyzer.tagPos(userInput));
		 */
		System.out.println(analyzer.getEverything(analyzer.tagPos(userInput)));
		return analyzer.getEverything(analyzer.tagPos(userInput));
	}

}
