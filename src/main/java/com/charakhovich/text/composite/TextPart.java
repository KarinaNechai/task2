package com.charakhovich.text.composite;

public interface TextPart {
    public boolean add(TextPart textPart);
    public TextPart remove (int index);
    public TypeTextPart getTypeTextPart();
    public TextPart getChild(int index);
}