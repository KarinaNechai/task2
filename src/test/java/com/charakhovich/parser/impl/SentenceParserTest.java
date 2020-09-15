package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.text.composite.TextPart;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SentenceParserTest {
    private static final String MAIN_MATHEMATICAL_EXPRESSION = "[(]*[+-]?(\\d{1,5}([.]?\\d{0,2})?[\\^+*/\\-][\\(*||\\d{1,5}(\\.?\\d{0,2})?[[\\^+*/\\-]||\\)*]]*)";
    private static final String temp="[(?<digit>\\d{1,5}\\.?\\d{0,2}?)|[ij]]";

    //private static final String MATHEMATICAL_EXPRESSION = "[(]*[+-]?([(]*\\d{1,5}\\.?(\\d{0,2})?[\\^+*/\\-]\\d{1,5}\\.?(\\d{0,2})?[)]*)*";//([\\^+*/\\-]\\d{1,5}\\.?(\\d{0,2})?)*";
//+"\\d{1,5}\\.?(\\d{0,2})?]";
  //  private static final String MATHEMATICAL_EXPRESSION="\\s*-?\\d+(\\s*[-+ *%/]\\s*-?\\d+)*\\s*";
    @Test
    public void testParse() throws TextException {
        TextPart textPart= (TextPart) SentenceParser.getInstance().parse(
        "It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page");
        textPart.toString();
    }
   // @Test
   /* public void setUp(){
       // String str="(-5+1.0/2*(2+5*2-2))*1200";
        String str="(71-(2*7*(3*(2-1/2*2)-2)-10/2))*4";
        String str1="5.";
        //boolean r1=str.matches(AA);
        boolean s=str.matches(MATHEMATICAL_EXPRESSION);
        boolean s1=str1.matches(temp);
        System.out.println(s);*/
  //  }
}