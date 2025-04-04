package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentSize;

    public SearchEngine(int initialCapacity) {
        this.searchables = new Searchable[initialCapacity];
        this.currentSize = 0;
    }

    public void add(Searchable searchable) {
        if (currentSize < searchables.length) {
            searchables[currentSize++] = searchable;
        }
    }

    public Searchable[] search(String query) {
        List<Searchable> results = new ArrayList<>();

        for (int i = 0; i < currentSize; i++) {
            Searchable searchable = searchables[i];
            if (searchable.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(searchable);
                if (results.size() == 5) {
                    break;
                }
            }
        }

        return results.toArray(new Searchable[0]);
    }
}