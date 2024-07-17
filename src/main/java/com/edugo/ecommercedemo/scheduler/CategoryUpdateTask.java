package com.edugo.ecommercedemo.scheduler;

import com.edugo.ecommercedemo.dto.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class CategoryUpdateTask {

    private RestClient restClient;

    @Autowired
    public CategoryUpdateTask(RestClient restClient) {}

    @Scheduled(cron = "0 0 1 * * ?")
    public void updateCategories() {
        List<CategoryDTO> categories = restClient.get()
                .uri("https://api.develop.bricks.com.ar/loyalty/category/producer")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
