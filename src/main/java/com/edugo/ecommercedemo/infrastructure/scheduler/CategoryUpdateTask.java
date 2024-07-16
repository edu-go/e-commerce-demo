package com.edugo.ecommercedemo.infrastructure.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CategoryUpdateTask {

    @Scheduled
    public void updateCategories() {
        //TODO - update categories
    }
}
