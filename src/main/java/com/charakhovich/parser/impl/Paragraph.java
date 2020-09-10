package com.charakhovich.parser.impl;

import com.charakhovich.parser.TextParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Paragraph implements TextParser {
    private String paragraph;
    private static final String SENTENCE_SPLIT ="(?<=[.!?.{3}])s";
    static final Logger logger = LogManager.getLogger();

    public Paragraph(String paragraph) {
        this.paragraph = paragraph;
    }

    @Override
    public TextPart parse() {
        TextComposite resultParagraph = new TextComposite(TypeTextPart.PARAGRAPH);
        String[] arraySentence = this.paragraph.split(SENTENCE_SPLIT);
        for (String strSentence : arraySentence
        ) {
            strSentence.trim();
            if (!strSentence.isEmpty()) {
                Sentence sentence = new Sentence(strSentence);
                TextPart sentenceParse = sentence.parse();
                resultParagraph.add(sentenceParse);
            } else {
                logger.log(Level.WARN,"Sentence is empty");
            }
        }
        return resultParagraph;
    }
}

