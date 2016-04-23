package com.ramon.lcs.restOutput;

/**
 * Use primarily for returning a result.
 * Only attribute is result which is set by the
 * caller.
 */
public class LeastCommonResponse {

    private String lcs;

    public void setLcs(String lcs) {
        this.lcs = lcs;
    }

    public String getLcs() {
        return lcs;
    }
}
