package org.skypro.skyshop.search;

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();

    default String getStringRepresentation() {
        return String.format("%s — %s", getName(), getContentType());
    }

    default String getDetailedStringRepresentation() {
        return String.format("%s — %s (%s)", getName(), getContentType(), getSearchTerm());
    }
}