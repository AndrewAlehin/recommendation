package com.century.recommendation.repository;

import com.century.recommendation.model.History;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryRepository {

    private final CrudHistoryRepository crudRepository;

    public HistoryRepository(CrudHistoryRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<History> getRecommendation(int id) {
        return crudRepository.getRecommendation(id);
    }

    public List<History> getNewRecommendation() {
        return crudRepository.getNewRecommendation();
    }
}