package org.skypro.skyshop.Art;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Название статьи не может быть пустым");
        }
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым");
        }
        this.title = title;
        this.text = text;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return getName().equals(article.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return String.format("%s%n%s", title, text);
    }
}