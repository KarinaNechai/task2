package com.charakhovich.text.composite;

import java.util.List;

public interface TextPart {
    boolean add(TextPart textPart);

    TextPart remove(int index);

    TypeTextPart getTypeTextPart();

    TextPart getChild(int index);

    public List<TextPart> getListTextPart();
    public List<TextPart> getListTextPart(TypeTextPart typeTextPart);
}