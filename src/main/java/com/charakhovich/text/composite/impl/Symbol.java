package com.charakhovich.text.composite.impl;

import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeSymbol;
import com.charakhovich.text.composite.TypeTextPart;

public class Symbol implements TextPart {
    private TypeTextPart typePartText;
    private char symbol;
    private TypeSymbol typeSymbol;

    public Symbol(TypeSymbol typeSymbol,char symbol) {
        this.typePartText = TypeTextPart.SYMBOL;
        this.typeSymbol=typeSymbol;
        this.symbol=symbol;
    }

    @Override
    public boolean add(TextPart textPart) {
        return false;
    }

    @Override
    public TextPart remove(int index) {
        return null;
    }

    @Override
    public TypeTextPart getTypeTextPart() {
        return typePartText;
    }

    @Override
    public TextPart getChild(int index) {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
