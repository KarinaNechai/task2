package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.parser.TextParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Text implements TextParser {
    private String text;
    private static final String PARAGRAPH_SPLIT = "(\\t|\\s{4})";
    static final Logger logger = LogManager.getLogger();

    public Text(String text) {
        this.text = text;
    }

    @Override
    public TextComposite parse() throws TextException {
        TextComposite resultText = new TextComposite(TypeTextPart.TEXT);
        String[] arrayParagraph = this.text.split(PARAGRAPH_SPLIT);
        for (String strParagraph : arrayParagraph
        ) {
            strParagraph.trim();
            if (!strParagraph.isEmpty()) {
                Paragraph paragraph = new Paragraph(strParagraph);
                TextPart paragraphParse = paragraph.parse();
                resultText.add(paragraphParse);
            } else {
                logger.log(Level.WARN,"Paragraph is empty");

            }
        }
        return resultText;
    }
}
