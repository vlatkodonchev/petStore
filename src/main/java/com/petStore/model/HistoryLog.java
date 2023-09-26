package com.petStore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "history-log")
@Data
@NoArgsConstructor
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Date of execution")
    private LocalDate date;

    private int successfulPurchases;

    private int failedPurchases;
}
