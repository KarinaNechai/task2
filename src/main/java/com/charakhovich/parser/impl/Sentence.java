package com.charakhovich.parser.impl;

import com.charakhovich.parser.TextParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.TextComposite;

public class Sentence implements TextParser {
    private String sentence;
    private static final String LEXEME_SPLIT = "\\s+";

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public TextPart parse() {
        TextComposite resultSentence=new TextComposite(TypeTextPart.SENTENCE);
        String[] arrayLexeme=this.sentence.split(LEXEME_SPLIT);
        for (String strLexeme:arrayLexeme
             ) {
            if (!strLexeme.isEmpty()){
                Lexeme lexeme=new Lexeme(strLexeme);
                TextPart lexemeParse=lexeme.parse();
                resultSentence.add(lexemeParse);
            }
            else {

            }
        }
        return resultSentence;
    }
}
