package com.example.springmybatis.da.mapper;

import com.example.springmybatis.da.entity.SomeTable;
import com.example.springmybatis.da.query.SomeTableSelectQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SomeTableMapper {
    List<SomeTable> select(SomeTableSelectQuery query);
}
