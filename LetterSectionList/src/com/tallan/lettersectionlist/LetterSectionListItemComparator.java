package com.tallan.lettersectionlist;

import java.util.Comparator;

public class LetterSectionListItemComparator implements Comparator<LetterSectionListItem> {

    @Override
    public int compare(LetterSectionListItem i1, LetterSectionListItem i2) {
        return i1.getSortString().compareTo(i2.getSortString());
    }
}