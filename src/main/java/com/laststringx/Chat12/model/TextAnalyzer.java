package com.laststringx.Chat12.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.StringUtils;

public class TextAnalyzer {

	public String getData() {
		return "hello World";
	}

	public TextAnalyzer() {
		// TODO Auto-generated constructor stub
		tagger = new MaxentTagger(modelPath);

	}

	private HashSet<String> portfolio;
	private static final String modelPath = "edu\\stanford\\nlp\\models\\pos-tagger\\english-left3words\\english-left3words-distsim.tagger";
	private MaxentTagger tagger;

	public static HashSet<String> extractProperNouns(String taggedOutput) {
		HashSet<String> propNounSet = new HashSet<String>();
		String[] split = taggedOutput.split(" ");
		List<String> propNounList = new ArrayList<String>();
		for (String token : split) {
			String[] splitTokens = token.split("_");
			if (splitTokens[1].equals("NNP")) {
				propNounList.add(splitTokens[0]);
			} else {
				if (!propNounList.isEmpty()) {
					propNounSet.add(StringUtils.join(propNounList, " "));
					propNounList.clear();
				}
			}
		}
		if (!propNounList.isEmpty()) {
			propNounSet.add(StringUtils.join(propNounList, " "));
			propNounList.clear();
		}
		return propNounSet;
	}

	public static String getEverything(String taggedOutput) {
		StringBuilder sb = new StringBuilder("Nouns : ");
		System.out.println("In getEverything");
		System.out.println(taggedOutput);
		HashSet<String> propNounSet = extractProperNouns(taggedOutput);
		for (String str : propNounSet) {
			sb.append(str + ", ");
		}
		sb.append(System.getProperty("line.separator"));
		sb.append("Adjectives : ");
		final String tokens[] = taggedOutput.split(" ");
		for (String str : tokens) {
			String tokenSplit[] = str.split("_");
			if ("JJ".equals(tokenSplit[1])) {
				sb.append(tokenSplit[0] + ", ");
			}
		}
		sb.append(System.getProperty("line.separator"));
		sb.append("Adverbs : ");
		for (String str : tokens) {
			String tokenSplit[] = str.split("_");
			if ("RB".equals(tokenSplit[1]) || "RBS".equals(tokenSplit[1])) {
				sb.append(tokenSplit[0] + ", ");
			}
		}

		return sb.toString();
	}

	public String tagPos(String input) {
		return tagger.tagString(input);
	}

}
