package ru.kpfu.itis.group903.nurkaev.services;

import ru.kpfu.itis.group903.nurkaev.models.News;

import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface NewsService {
    void save(News entity);

    void delete(News entity);

//    void update(News entity);

    List<News> findByTag(String tagName);

    List<News> getAllNews();
}
