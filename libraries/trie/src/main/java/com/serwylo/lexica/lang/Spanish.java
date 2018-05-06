package com.serwylo.lexica.lang;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Spanish extends Language {

    private static Map<String, Integer> letterPoints = new HashMap<>();

    static {
        letterPoints.put("a", 1);
        letterPoints.put("á", 1);
        letterPoints.put("b", 1);
        letterPoints.put("c", 1);
        letterPoints.put("d", 1);
        letterPoints.put("e", 1);
        letterPoints.put("f", 1);
        letterPoints.put("g", 1);
        letterPoints.put("h", 1);
        letterPoints.put("i", 1);
        letterPoints.put("é", 1);
        letterPoints.put("j", 1);
        letterPoints.put("k", 1);
        letterPoints.put("l", 1);
        letterPoints.put("m", 1);
        letterPoints.put("í", 1);
        letterPoints.put("n", 1);
        letterPoints.put("o", 1);
        letterPoints.put("p", 1);
        letterPoints.put("ñ", 1);
        letterPoints.put("q", 1);
        letterPoints.put("r", 1);
        letterPoints.put("ó", 1);
        letterPoints.put("s", 1);
        letterPoints.put("t", 1);
        letterPoints.put("u", 1);
        letterPoints.put("v", 1);
        letterPoints.put("w", 1);
        letterPoints.put("x", 1);
        letterPoints.put("y", 1);
        letterPoints.put("z", 1);
        letterPoints.put("ú", 1);
        letterPoints.put("ü", 1);
    }

    @Override
    public boolean isBeta() {
        return true;
    }

    @Override
    public Locale getLocale() {
        return new Locale("es");
    }

    @Override
    public String getName() {
        return "es";
    }

    @Override
    public String toDisplay(String value) {
        return value.toUpperCase(getLocale());
    }

    @Override
    public String applyMandatorySuffix(String value) {
        return value;
    }

    @Override
    protected Map<String, Integer> getLetterPoints() {
        return letterPoints;
    }
}
