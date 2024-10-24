package com.serwylo.lexica.lang;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class EnglishIPA extends English {

    private static Map<String, Integer> letterPoints = new HashMap<>();

    static {
        letterPoints.put("b", 1);
        letterPoints.put("d", 1);
        letterPoints.put("ij", 1);
        letterPoints.put("k", 1);
        letterPoints.put("l", 1);
        letterPoints.put("m", 1);
        letterPoints.put("n", 1);
        letterPoints.put("p", 1);
        letterPoints.put("s", 1);
        letterPoints.put("t", 1);
        letterPoints.put("æ", 1);
        letterPoints.put("ɑ", 1);
        letterPoints.put("ə", 1);
        letterPoints.put("ɛ", 1);
        letterPoints.put("ɪ", 1);
        letterPoints.put("ɹ", 1);
        letterPoints.put("aj", 2);
        letterPoints.put("ej", 2);
        letterPoints.put("f", 2);
        letterPoints.put("ow", 2);
        letterPoints.put("uw", 2);
        letterPoints.put("v", 2);
        letterPoints.put("z", 2);
        letterPoints.put("ŋ", 2);
        letterPoints.put("ɔ", 2);
        letterPoints.put("ɚ", 2);
        letterPoints.put("ɡ", 2);
        letterPoints.put("ʃ", 2);
        letterPoints.put("ʌ", 2);
        letterPoints.put("h", 3);
        letterPoints.put("j", 3);
        letterPoints.put("w", 3);
        letterPoints.put("ʒ", 3);
        letterPoints.put("ʊ", 5);
        letterPoints.put("θ", 5);
        letterPoints.put("aw", 7);
        letterPoints.put("ɔj", 12);
        letterPoints.put("ɜ", 12);
        letterPoints.put("ð", 16);
    }

    @Override
    public boolean isBeta() {
        return true;
    }

    @Override
    public String getName() {
        return "en_IPA";
    }

	// Prevent characters from being uppercased
    @Override
    public String toDisplay(String value) {
        return value;
    }

	// Handle diphthongs
    @Override
    public String applyMandatorySuffix(String value) {
        if (value.equals("i") || value.equals("a") || value.equals("e")) {
            return value + "j";
        }
		else if (value.equals("o") || value.equals("u")) {
			return value + "w";
		}

        return value;
    }
}
