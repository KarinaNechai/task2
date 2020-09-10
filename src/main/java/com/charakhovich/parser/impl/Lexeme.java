package com.charakhovich.parser.impl;

import com.charakhovich.parser.TextParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.Symbol;
import com.charakhovich.text.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexeme implements TextParser {
    private String lexeme;
    private static final String WORD_SPLIT = "[\\p{L}\\p{M}\\p{N}]+(?:\\p{P}[\\p{L}\\p{M}\\p{N}]+)*|[\\p{P}\\p{S}]";
    private static final String PUNCTUATION_SPLIT = "\\pP";

    public Lexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    @Override
    public TextPart parse() {
        TextComposite resultLexeme = new TextComposite(TypeTextPart.LEXEME);
        List<String> parts = new ArrayList<>();
        Matcher matcher = Pattern.compile(WORD_SPLIT).matcher(this.lexeme);
        while (matcher.find()) {
            parts.add(matcher.group());
        }
        for (String partLexeme : parts
        ) {
            matcher = Pattern.compile(PUNCTUATION_SPLIT).matcher(partLexeme);
            if (matcher.find()) {
                char[] charsPunctuation = matcher.group().toCharArray();
                for (char ch : charsPunctuation
                ) {
                    Symbol puctuation = new Symbol(TypeSymbol.PUNCTUATION, ch);
                    resultLexeme.add(puctuation);
                }
            } else {
                Word word = new Word(partLexeme);
                TextPart wordParse = word.parse();
                resultLexeme.add(wordParse);
            }
        }
        return resultLexeme;
    }
}
