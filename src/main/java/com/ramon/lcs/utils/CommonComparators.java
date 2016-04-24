package com.ramon.lcs.utils;

import com.ramon.lcs.restInput.TheValue;

import java.util.Comparator;

public class CommonComparators {

    public static Comparator<String> ALPHABETICAL_ORDER = new Comparator<String>() {
        @Override
        public int compare(String v1, String v2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(v1, v2);
            if(res == 0)
            {
                res = v1.compareTo(v2);
            }
            return res;
        }
    };

    public static Comparator<TheValue> VALUE_ALPHABETICAL_ORDER = new Comparator<TheValue>() {
        @Override
        public int compare(TheValue v1, TheValue v2) {
            int res = String.CASE_INSENSITIVE_ORDER.compare(v1.getValue(), v2.getValue());
            if(res == 0)
            {
                res = v1.getValue().compareTo(v2.getValue());
            }
            return res;
        }
    };

}
