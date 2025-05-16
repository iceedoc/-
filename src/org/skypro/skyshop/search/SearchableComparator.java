package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lenDiff = Integer.compare(s2.getName().length(), s1.getName().length());
        return lenDiff != 0 ? lenDiff : s1.getName().compareTo(s2.getName());
    }
}
