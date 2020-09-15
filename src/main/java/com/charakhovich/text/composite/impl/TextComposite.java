package com.charakhovich.text.composite.impl;

import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;

import java.util.*;

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

    public List<TextPart> getListTextPart() {
        return Collections.unmodifiableList(listTextPart);
    }

    @Override
    public List<TextPart> getListTextPart(TypeTextPart typeTextPart) {
        List<TextPart> resultPartList = new ArrayList<>();
        if (typeTextPart != TypeTextPart.SYMBOL ){
               if (typeTextPart != this.typeTextPart) {
            for (TextPart part : listTextPart
            ) {
                if (!(part.getTypeTextPart()== TypeTextPart.SYMBOL)){
                    List<TextPart> temp=part.getListTextPart(typeTextPart);
                    if (!temp.isEmpty()){
                        resultPartList.addAll(part.getListTextPart(typeTextPart));
                    }
                }
                    resultPartList.addAll(part.getListTextPart(typeTextPart));
            }
        }
               else {

               }
        }
        return resultPartList;
    }

    @Override
    public boolean add(TextPart textPart) {
        boolean b=listTextPart.add(textPart);
        return b;
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
        for (TextPart textPart : listTextPart
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