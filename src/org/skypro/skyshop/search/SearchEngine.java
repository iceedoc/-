package org.skypro.skyshop.search;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        if (searchable != null) {
            searchables.add(searchable);
        }
    }

    public Map<String, Searchable> search(String query) {
        String lowerQuery = query.toLowerCase();

        return searchables.stream()
                .filter(s -> s.getSearchTerm().toLowerCase().contains(lowerQuery))
                .sorted(Comparator.comparing(Searchable::getName))
                .collect(Collectors.toMap(
                        Searchable::getName,
                        s -> s,
                        (existing, replacement) -> existing,
                        LinkedHashMap::new
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

        while (true) {
            index = text.toLowerCase().indexOf(search.toLowerCase(), index);
            if (index == -1) break;
            occurrences++;
            index += search.length();
        }
        return occurrences;
    }
}