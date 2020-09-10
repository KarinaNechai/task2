package com.charakhovich.text.composite.impl;

import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class TextComposite implements TextPart {
    private List<TextPart> listTextPart;
    private TypeTextPart typeTextPart;
    private static final String START_PARAGRAPH = "\t";
    private static final String END_PARAGRAPH = "\n";
    private static final String END_LEXEMA = "\\s";

    public TextComposite(TypeTextPart typeTextPart) {
        listTextPart = new LinkedList<>();
        this.typeTextPart = typeTextPart;
    }

    @Override
    public boolean add(TextPart textPart) {
        return this.listTextPart.add(textPart);
    }

    @Override
    public TextPart remove(int index) {
        return this.listTextPart.remove(index);
    }

    @Override
    public TextPart getChild(int index) {
        return this.listTextPart.get(index);
    }

    public TypeTextPart getTypeTextPart() {
        return typeTextPart;
    }

    public void setTypeTextPart(TypeTextPart typeTextPart) {
        this.typeTextPart = typeTextPart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextComposite that = (TextComposite) o;
        return Objects.equals(listTextPart, that.listTextPart) &&
                getTypeTextPart() == that.getTypeTextPart();
    }

    @Override
    public int hashCode() {
        return Objects.hash(listTextPart, getTypeTextPart());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (TextPart textPart : this.listTextPart
        ) {

            switch (textPart.getTypeTextPart()) {
                case PARAGRAPH: {
                    result.append(START_PARAGRAPH).append(textPart.toString()).append(END_PARAGRAPH);
                    break;
                }
                case LEXEME: {
                    result.append(textPart).append(END_LEXEMA);
                    break;
                }
                default: {
                    result.append(textPart);
                    break;
                }
            }
        }
        return String.valueOf(result);
    }
}