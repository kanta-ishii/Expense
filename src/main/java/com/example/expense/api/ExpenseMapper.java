package com.example.expense.api;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import java.util.List;


@Mapper
public interface ExpenseMapper {

    // 1件の経費データを挿入
    @Insert("INSERT INTO expense (date, title, amount, payer, split, category) " +
            "VALUES (#{date}, #{title}, #{amount}, #{payer}, #{split}, #{category})")
    void insertExpense(Expense expense);

    // IDで経費データを取得
    @Select("SELECT * FROM expense WHERE id = #{id}")
    Expense getExpenseById(Integer id);

    // すべての経費データを取得
    @Select("SELECT * FROM expense")
    List<Expense> getAllExpenses();

    // 経費データを更新
    @Update("UPDATE expense SET date = #{date}, title = #{title}, amount = #{amount}, " +
            "payer = #{payer}, split = #{split}, category = #{category} WHERE id = #{id}")
    void updateExpense(Expense expense);

    // IDで経費データを削除
    @Delete("DELETE FROM expense WHERE id = #{id}")
    void deleteExpense(Integer id);
}
