package com.ramon.lcs.utils;

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

}
