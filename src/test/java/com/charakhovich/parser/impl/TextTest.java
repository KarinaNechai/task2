package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.text.composite.impl.TextComposite;
import org.testng.annotations.Test;

public class TextTest {

    @Test
    public void testParse() throws TextException {
        Text text = new Text("\tIt has survived - not only (five) centuries, but also the leap into " +
                "electronic typesetting, remaining  unchanged.  " +
                "\tIt was popularised in the  with the release of Letraset sheets " +
                "containing Lorem Ipsum passages, and more recently with desktop publishing software " +
                "like Aldus PageMaker including versions of Lorem Ipsum.\n" +
                "    It is a long established fact that a reader will be distracted by the readable\n" +
                "content of a page when looking at its layout. The point of using (71-(2*i--*(3*(2-1/2*2)-\n" +
                "2)-10/2))*++i Ipsum is that it has a more-or-less normal distribution of letters, as\n" +
                "opposed to using (Content here), content here', making it look like readable English.\n" +
                "    It is a (-5+1/2*(2+5*2- --j))*1200 established fact that a reader will be of a page\n" +
                "when looking at its layout.\n" +
                "\tBye.");
        TextComposite textComposite = text.parse();
        String string = textComposite.toString();
        Boolean flag=true;
    }
}