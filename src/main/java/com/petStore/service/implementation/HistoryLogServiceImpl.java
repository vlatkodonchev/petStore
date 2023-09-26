package com.petStore.service.implementation;

import com.petStore.model.HistoryLog;
import com.petStore.repository.HistoryLogRepository;
import com.petStore.service.HistoryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryLogServiceImpl implements HistoryLogService {

    @Autowired
    HistoryLogRepository historyLogRepository;

    @Override
    public List<HistoryLog> getAllHistoryLogs() {
        return historyLogRepository.findAll();
    }
}
