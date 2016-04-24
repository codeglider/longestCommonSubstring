package com.ramon.lcs.services;

import com.ramon.lcs.Application;
import com.ramon.lcs.restInput.TheValue;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class LongestCommonServiceTest {

    @Autowired
    private LongestCommonService longestCommonService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testFindLongestCommonString() throws Exception {
        List<TheValue> args = new ArrayList<TheValue>();
        args.add(new TheValue("sungard"));
        args.add(new TheValue("sungarder"));
        args.add(new TheValue("garden"));
        List<TheValue> result = callToService(args);
        boolean testPassed = true;
        for (TheValue value: result) {
            if(!value.getValue().equals("gard"))
                testPassed = false;
        }
        assertTrue(testPassed);
    }

    @Test
    public void testFindMultipleLongestCommonString() throws Exception {
        List<TheValue> args = new ArrayList<TheValue>();
        args.add(new TheValue("sdropungard"));
        args.add(new TheValue("sungarderdrop"));
        args.add(new TheValue("dropgarden"));

        List<TheValue> results = callToService(args);

        List<TheValue> expectedResults = new ArrayList<TheValue>();
        expectedResults.add(new TheValue("drop"));
        expectedResults.add(new TheValue("gard"));

        assertTrue(results.size() == expectedResults.size());

        for (int i = 0; i < results.size(); i++) {
            assertTrue(results.get(i).getValue().equals(expectedResults.get(i).getValue()));
        }

    }

    private List<TheValue> callToService(List<TheValue> args)
    {
        return longestCommonService.findLongestCommonString(args);
    }

}