package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.parser.DataParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphParser implements DataParser {
    private static final String SENTENCE_SPLIT ="(?<=[.!?\\.{3}])s";
    static final Logger logger = LogManager.getLogger();
    private static SentenceParser sentenceParser=SentenceParser.getInstance();
    private static final ParagraphParser paragraphParser =new ParagraphParser();

    private ParagraphParser() {
    }

    public static ParagraphParser getInstance() {
        return paragraphParser;
    }

    @Override
    public TextPart parse(String paragraph) throws TextException {
        TextComposite resultParagraph = new TextComposite(TypeTextPart.PARAGRAPH);
        String[] arraySentence = paragraph.split(SENTENCE_SPLIT);
        for (String sentence : arraySentence
        ) {
            sentence.trim();
            if (!sentence.isEmpty()) {
                TextPart sentenceParse = sentenceParser.parse(sentence);
                resultParagraph.add(sentenceParse);
            } else {
                logger.log(Level.WARN,"Sentence is empty");
            }
        }
        return resultParagraph;
    }
}

