package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.parser.DataParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextParser implements DataParser {
    private static final String MATHEMATICAL_EXPRESSION = "[(]*[+-]?(\\d{1,5}([.]?\\d{0,2})?[\\^+*/\\-][\\(*||\\d{1,5}(\\.?\\d{0,2})?[[\\^+*/\\-]||\\)*]]*)";
    private static final String PARAGRAPH_SPLIT = "(\\t|\\s{4})";
    private static final String INCREMENT_REGEXP = "+{2}";
    private static final String DECREMENT_REGEXP = "-{2}";
    private static final String PARAMETER_I = "i";
    private static final String PARAMETER_J = "j";
    static final Logger logger = LogManager.getLogger();
    private static final TextParser textParser=new TextParser();
    private ParagraphParser paragraphParser=ParagraphParser.getInstance();

    private TextParser(){
    }
    public static TextParser getInstance(){
        return textParser;
    }
    @Override
    public TextComposite parse(String text) throws TextException {
        TextComposite resultText = new TextComposite(TypeTextPart.TEXT);
        String[] arrayParagraph = text.split(PARAGRAPH_SPLIT);
        for (String paragraph : arrayParagraph
        ) {
            paragraph.trim();
            if (!paragraph.isEmpty()) {
                TextPart paragraphParse=paragraphParser.parse(paragraph);
                resultText.add(paragraphParse);
            } else {
                logger.log(Level.WARN, "Paragraph is empty");
            }
        }
        return resultText;
    }

}
