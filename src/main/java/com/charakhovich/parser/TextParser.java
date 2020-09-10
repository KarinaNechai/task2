package com.charakhovich.parser;

import com.charakhovich.exception.TextException;
import com.charakhovich.text.composite.TextPart;

public interface TextParser {
    public TextPart parse() throws TextException;
}


