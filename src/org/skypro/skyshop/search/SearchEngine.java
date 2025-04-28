package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;


public class SearchEngine {
    private final Set<Searchable> searchables = new HashSet<>();

    public static Comparator<Searchable> getSearchableComparator() {
        return new SearchableComparator();
    }
    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }
    public Set<Searchable> search(String query) {
        String lowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(getSearchableComparator())
                ));
    }
    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxOccurrences = 0;

        for (Searchable searchable : searchables) {
            int occurrences = countOccurrences(searchable.getSearchTerm(), search);
            if (occurrences > maxOccurrences) {
                maxOccurrences = occurrences;
                bestMatch = searchable;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найден подходящий результат для поиска: " + search);
        }

        return bestMatch;
    }
    private int countOccurrences(String text, String search) {
        int occurrences = 0;
        int index = 0;
        String lowerText = text.toLowerCase();
        String lowerSearch = search.toLowerCase();

        while (true) {
            index = lowerText.indexOf(lowerSearch, index);
            if (index == -1) break;
            occurrences++;
            index += search.length();
        }
        return occurrences;
    }
}