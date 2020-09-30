package com.century.recommendation.repository;

import com.century.recommendation.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true)
public interface CrudHistoryRepository extends JpaRepository<History, Integer> {

    @Query(value = "select h.* from user_table\n" +
            "left join coordination c on user_table.id = c.user_id\n" +
            "left join history h on user_table.id = h.user_id\n" +
            "where c.coordination = (select coordination from coordination where user_id = :userId) and user_table.id <> :userId", nativeQuery = true)
    List<History> getRecommendation(@Param("userId") int userId);

    @Query(value = "select * from history order by date desc\n" +
            "limit 5", nativeQuery = true)
    List<History> getNewRecommendation();
}
