package com.medicine.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CharacterUtils {

    public static List<String> stringTochars(String strs) {
       if (strs == null || strs.length() == 0) {
           return new ArrayList<>();
       }
       return Arrays.asList(strs.split(","));
    }

    public static String charsToString(List<String> characters) {
        if (characters == null || characters.size() == 0) {
            return "";
        }
        StringBuffer s = new StringBuffer();
        characters.forEach(e->s.append(e + ","));
        return s.substring(0, s.length()-1);
    }
}
