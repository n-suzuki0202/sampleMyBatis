package com.example.springmybatis.da.entity;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SomeTable {
    
    private int id;
    private LocalDate numberDate;
    private Integer stringInteger;
    private boolean stringBoolean;
    private List<String> stringList;
}
