package com.ramon.lcs.services;

import com.ramon.lcs.Application;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        String[] args = {"sungard", "sungarder", "garden"};
        String result = callToService(args);
        assertEquals(result, "gard");
    }

    private String callToService(String[] args)
    {
        return longestCommonService.findLongestCommonString(args);
    }

}