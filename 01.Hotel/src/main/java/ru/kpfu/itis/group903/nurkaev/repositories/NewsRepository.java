package ru.kpfu.itis.group903.nurkaev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.kpfu.itis.group903.nurkaev.models.News;

import java.util.List;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Sem 2
 */

public interface NewsRepository extends JpaRepository<News, Long> {

    @Query(nativeQuery = true, value = "WITH _title_tag_id AS (\n" +
            "    SELECT nh.id, nh.title, nh.description, nh.photo, nt.tag_id\n" +
            "    FROM news_hotel nh\n" +
            "             LEFT JOIN news_tag nt on nh.id = nt.news_id)\n" +
            "SELECT _title_tag_id.id, _title_tag_id.title, _title_tag_id.description, _title_tag_id.photo\n" +
            "FROM _title_tag_id\n" +
            "         INNER JOIN tag_hotel th ON th.id = _title_tag_id.tag_id\n" +
            "WHERE tagname = :tag_name")
    List<News> findByTag(@Param("tag_name") String tagName);

    /*@Query(nativeQuery = true, value = "UPDATE news_hotel " +
            "SET title = :title, description = :description, photo = :photo WHERE id = :id;")
    void update(News entity);*/
}
