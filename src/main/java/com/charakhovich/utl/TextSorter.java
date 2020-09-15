package com.charakhovich.utl;

import com.charakhovich.exception.TextException;
import com.charakhovich.text.composite.TextPart;
import com.charakhovich.text.composite.TypeTextPart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextSorter {
    public static List<TextPart> sortByCountParts(TextPart text) throws TextException {
        if (text.getTypeTextPart()== TypeTextPart.SYMBOL) {
            throw new TextException("Method TextSorter.sortByCountParts is not supported for TypeTextPart.SYMBOL");
        }
        List<TextPart> resultList=text.getListTextPart();
        resultList.sort(Comparator.comparingInt(p->p.getListTextPart().size()));
        return resultList;
    }
    public static List<TextPart> sortByLengthParts(TextPart text,TypeTextPart type) throws TextException {
        if (text.getTypeTextPart()== TypeTextPart.SYMBOL) {
            throw new TextException("Method TextSorter.sortByLengthParts is not supported for TypeTextPart.SYMBOL");
        }
        List<TextPart> listTextPart= text.getListTextPart(type);
        listTextPart.sort(Comparator.comparingInt(p->p.getListTextPart().toString().length()));
        return listTextPart;
    }
    /*public static List<TextPart> sortBySymbolInComponentByAlphavit(TextPart text,char symbol) throws TextException {
        if (text.getTypeTextPart()== TypeTextPart.SYMBOL) {
            throw new TextException("Method TextSorter. sortBySymbolInComponentByAlphavit is not supported for TypeTextPart.SYMBOL");
        }
        List<TextPart> resultList=text.getListTextPart();
        resultList.sort(Comparator.comparingInt(p->p.getListTextPart().toString().toLowerCase().));
        return resultList;
    }*/
}
