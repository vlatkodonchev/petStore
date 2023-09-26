package com.petStore.controller;

import com.petStore.model.HistoryLog;
import com.petStore.service.implementation.HistoryLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/historyLog")
public class HistoryLogController {

    @Autowired
    HistoryLogServiceImpl historyLogService;

    @GetMapping("/all")
    public ResponseEntity<List<HistoryLog>> getAllHistoryLogs() {
        List<HistoryLog> logs = historyLogService.getAllHistoryLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }
}
