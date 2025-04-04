package org.skypro.skyshop.Art;

import org.skypro.skyshop.search.Searchable;

public record Article(String title, String text) implements Searchable {
    public Article {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
    }

    @Override
    public String getSearchTerm() {
        return getName() + " " + text();
    }


    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", title, text);
    }
}