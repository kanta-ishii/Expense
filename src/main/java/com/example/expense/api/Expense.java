package com.example.expense.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Expense {
    private Integer id;
    private LocalDate date; // 日付
    private String title; // タイトル
    private Integer amount; // 金額
    private String payer; // 支払い者
    private Integer split; // 分割支払いかどうか
    private String category; // 費用カテゴリ（例：食費、交通費、など）
}
