package com.charakhovich.parser.impl;

import com.charakhovich.parser.DataParser;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;
import com.charakhovich.text.composite.impl.Symbol;
import com.charakhovich.text.composite.impl.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordParser implements DataParser {
    static final Logger logger = LogManager.getLogger();
//    private static final String MATHEMATICAL_EXPRESSION = "[(]*[+-]?(\\d{1,5}([.]?\\d{0,2})?[\\^+*/\\-][\\(*||\\d{1,5}(\\.?\\d{0,2})?[[\\^+*/\\-]||\\)*]]*)";
    private static final WordParser wordParser = new WordParser();

    private WordParser() {
    }

    public static WordParser getInstance() {
        return wordParser;
    }

    @Override
    public TextPart parse(String word) {
        TextComposite resultWord = new TextComposite(TypeTextPart.WORLD);
     /*   if (word.matches(MATHEMATICAL_EXPRESSION)) {
            String str = ReversePolishNotation.convertTo(word);
          //  Double d = ReversePolishNotation.calculateReversePolishNotation(str);
           // Symbol letter = new Symbol(TypeSymbol.NUMBER, d);

        } else {*/
            char[] charArray = word.toCharArray();
            for (char ch : charArray
            ) {
                TextPart letter = new Symbol(TypeSymbol.LETTER,ch);
                resultWord.add(letter);
            }
      //  }
        return resultWord;
    }
}

