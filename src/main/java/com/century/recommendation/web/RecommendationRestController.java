package com.century.recommendation.web;

import com.century.recommendation.model.History;
import com.century.recommendation.model.User;
import com.century.recommendation.repository.HistoryRepository;
import com.century.recommendation.repository.UserRepository;
import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = RecommendationRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RecommendationRestController {
    static final String REST_URL = "/rest/recommendation";

    private final UserRepository repository;
    private final HistoryRepository historyRepository;

    public RecommendationRestController(UserRepository repository, HistoryRepository historyRepository) {
        this.repository = repository;
        this.historyRepository = historyRepository;
    }

    @GetMapping("/{idUser}")
    public List<History> getUser(@PathVariable int idUser) {
        checkId(idUser);
        List<History> recommendation = historyRepository.getRecommendation(idUser);
        if (recommendation.size() != 0)
            return recommendation;
        else
            return historyRepository.getNewRecommendation();
    }

    private void checkId(int id) {
        User dbUser = repository.getById(id);
        if (dbUser == null) {
            throw new NotFoundException("id=" + id);
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundException.class})
    public JSONObject handleValidationExceptions(NotFoundException ex) {
        JSONObject errors = new JSONObject();
        errors.put("Not found", ex.getMessage());
        return errors;
    }
}