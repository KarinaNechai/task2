package com.charakhovich.text.composite.impl;

import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;

import java.util.List;

public class Symbol implements TextPart {
    private TypeTextPart typePartText;
    private char symbol;
    private TypeSymbol typeSymbol;

    public Symbol(TypeSymbol typeSymbol, char symbol) {
        this.typePartText = TypeTextPart.SYMBOL;
        this.typeSymbol = typeSymbol;
        this.symbol = symbol;
    }

    @Override
    public boolean add(TextPart textPart) {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public TextPart remove(int index) {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public TypeTextPart getTypeTextPart() {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public TextPart getChild(int index) {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public List<TextPart> getListTextPart() {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public List<TextPart> getListTextPart(TypeTextPart typeTextPart) {
        throw new UnsupportedOperationException("Method isn't supported");
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
