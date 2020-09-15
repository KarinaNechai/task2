package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.parser.DataParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;

public class SentenceParser implements DataParser {
    private static final String LEXEME_SPLIT = "\\s+";
    private static LexemeParser lexemeParser=LexemeParser.getInstance();
    private static final SentenceParser sentenceParser = new SentenceParser();

    private SentenceParser() {
    }

    public static SentenceParser getInstance() {
        return sentenceParser;
    }
    @Override
    public TextPart parse(String sentence) throws TextException {
        TextComposite resultSentence=new TextComposite(TypeTextPart.SENTENCE);
        String[] arrayLexeme=sentence.split(LEXEME_SPLIT);
        for (String lexeme:arrayLexeme
             ) {
            if (!lexeme.isEmpty()){
                TextPart lexemeParse= lexemeParser.parse(lexeme);
                resultSentence.add(lexemeParse);
            }
            else {

            }
        }
        return resultSentence;
    }
}
