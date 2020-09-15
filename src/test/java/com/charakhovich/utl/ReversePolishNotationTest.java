package com.charakhovich.utl;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReversePolishNotationTest {
    String MATH_OPERATOR_REGEXP = "[\\^+*/\\-]";
    String BRACKET_OPEN = "\\(";
    String BRACKET_CLOSE = "\\)";
    String SPLITTER = "\\s";
    String NUMBER = "[0-9]";

    @Test(dataProvider = "dataConvertToReversePolishNotation")
    public void testConvertToReversePolishNotation(String convertString,String expected) {
        String actual=ReversePolishNotation.convertTo(convertString);
        Assert.assertEquals(actual,expected);
    }

    @DataProvider(name = "dataConvert")
    public Object[][] dataConvertToReversePolishNotation(){
        return new Object[][]{
                {"(-5+1/2*(2+5*2-4))*1200", "0\\s5\\s1\\s2\\s/\\s2\\s5\\s2\\s*\\s4\\s-\\s+\\s*\\s+\\s-\\s1200\\s*"}
        };
    }

    @Test
    public void testCalculate() {
        Double actual=ReversePolishNotation.calculate("0 5 1 2 / 2 5 2 * 4 - + * + - 1200 *");
     //   Double actual1=ReversePolishNotation.calculateReversePolishNotation("0 5 1 2 / 2 5 2 * 4 - + * + - 1200 *");
        boolean flag;
    }
}
