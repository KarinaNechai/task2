package com.charakhovich.parser.impl;

import com.charakhovich.exception.TextException;
import com.charakhovich.parser.DataParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.Symbol;
import com.charakhovich.text.composite.impl.TextComposite;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements DataParser {
    private static final String WORD_SPLIT = "[\\p{L}\\p{M}\\p{N}]+(?:\\p{P}[\\p{L}\\p{M}\\p{N}]+)*|[\\p{P}\\p{S}]";
    private static final String PUNCTUATION_SPLIT = "\\pP";
    private static WordParser wordParser=WordParser.getInstance();
    private static final LexemeParser lexemeParser = new LexemeParser();

    private LexemeParser() {
    }

    public static LexemeParser getInstance() {
        return lexemeParser;
    }

    @Override
    public TextPart parse(String lexeme) throws TextException {
        TextComposite resultLexeme = new TextComposite(TypeTextPart.LEXEME);
        List<String> parts = new ArrayList<>();
        Matcher matcher = Pattern.compile(WORD_SPLIT).matcher(lexeme);
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
                TextPart wordParse = wordParser.parse(partLexeme);
                resultLexeme.add(wordParse);
            }
        }
        return resultLexeme;
    }
}
