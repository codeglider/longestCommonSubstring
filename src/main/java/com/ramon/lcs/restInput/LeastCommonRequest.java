package com.ramon.lcs.restInput;

import java.util.List;
import java.util.Map;

/**
 * Primarily used for providing the input.
 * Input is a list of objects that have
 * string value pairing.
 */
public class LeastCommonRequest {

    private List<TheValue> setOfStrings;

    public void setSetOfStrings(List<TheValue> setOfStrings) {
        this.setOfStrings = setOfStrings;
    }

    public List<TheValue> getSetOfStrings() {
        return setOfStrings;
    }
}
