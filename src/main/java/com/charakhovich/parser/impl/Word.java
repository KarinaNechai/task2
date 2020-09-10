package com.charakhovich.parser.impl;

import com.charakhovich.parser.TextParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.Symbol;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Word implements TextParser {
    private String word;
    static final Logger logger = LogManager.getLogger();

    public Word(String word) {
        this.word = word;
    }

    @Override
    public TextPart parse() {
        TextComposite resultWord = new TextComposite(TypeTextPart.WORLD);
        char[] charArray = this.word.toCharArray();
        for (char ch : charArray
        ) {
            Symbol letter = new Symbol(TypeSymbol.LETTER, ch);
            resultWord.add(letter);
        }
        return resultWord;
    }
}

