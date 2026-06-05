package com.library.backend.controller;

import com.library.backend.dto.NhatKyHoatDongResponse;
import com.library.backend.service.ActivityLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class NhatKyHoatDongController {

    private final ActivityLogService activityLogService;

    public NhatKyHoatDongController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping
    public List<NhatKyHoatDongResponse> getLatestLogs(
            @RequestParam(defaultValue = "50") int limit
    ) {
        return activityLogService.getLatestLogs(limit);
    }
}