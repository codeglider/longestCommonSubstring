package com.ramon.lcs.restOutput;

import com.ramon.lcs.restInput.TheValue;

import java.util.List;

/**
 * Use primarily for returning a result.
 * Only attribute is result which is set by the
 * caller.
 */
public class LeastCommonResponse {

    private List<TheValue> results;

    public List<TheValue> getResults() {
        return results;
    }

    public void setResults(List<TheValue> results) {
        this.results = results;
    }
}
