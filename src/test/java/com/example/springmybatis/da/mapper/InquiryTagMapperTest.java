package com.example.springmybatis.da.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springmybatis.da.entity.InquiryTag;
import com.example.springmybatis.da.query.InquiryTagSelectQuery;
import com.example.springmybatis.da.query.InquiryTagSelectQuery.OrderByField;
import com.example.springmybatis.da.query.InquiryTagSelectQuery.SortOrder;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InquiryTagMapperTest {

    @Autowired
    private InquiryTagMapper inquiryTagMapper;

    @Test
    void find() {
       var inquiryTag = inquiryTagMapper.find(1);

       assertNotNull(inquiryTag);

       assertEquals("問合せ", inquiryTag.getDescription());

    }

    @Test
    void select() {
       var query = new InquiryTagSelectQuery();

       query.setDescription("問合せ");

       query.addOrderCondition(OrderByField.INQUIRY_ID, SortOrder.DESC);
       query.addOrderCondition(OrderByField.ID, SortOrder.ASC);

       var list = inquiryTagMapper.select(query, new RowBounds(0, 100));

       assertEquals(2, list.size());

       var inquiryTag = list.get(0);

       assertEquals(7, inquiryTag.getId());
    }


	@Test
    void insertUpdateDelete() {
       var inquiryTag = new InquiryTag();
       inquiryTag.setInquiryId(1);
       inquiryTag.setDescription("保存");
       inquiryTag.setCreated(LocalDateTime.now());

       inquiryTagMapper.insert(inquiryTag);

       assertEquals(8, inquiryTag.getId());

       inquiryTag.setDescription("保管");

       inquiryTagMapper.update(inquiryTag);

       var updatedInquiryTag = inquiryTagMapper.find(8);

       assertNotNull(updatedInquiryTag);

       assertEquals(updatedInquiryTag.getDescription(), inquiryTag.getDescription());

       inquiryTagMapper.delete(8);

       var deletedInquiryTag = inquiryTagMapper.find(8);

       assertNull(deletedInquiryTag);

    }

	@Test
    void findView() {
       var inquiryTagView = inquiryTagMapper.findView(1);

       assertNotNull(inquiryTagView);

       var inquiry = inquiryTagView.getInquiry();

       assertNotNull(inquiry);

       assertEquals("Contents1", inquiry.getContents());
    }

	@Test
    void findView2() {
       var inquiryTagView = inquiryTagMapper.findView2(1);

       assertNotNull(inquiryTagView);

       var inquiry = inquiryTagView.getInquiry();

       assertNotNull(inquiry);

       assertEquals("Contents1", inquiry.getContents());
    }
}
