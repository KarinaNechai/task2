package com.charakhovich.parser;

import com.charakhovich.exception.TextException;
import com.charakhovich.text.composite.TextPart;

public interface DataParser {
    TextPart parse(String text) throws TextException;
}


