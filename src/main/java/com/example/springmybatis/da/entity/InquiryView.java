package com.example.springmybatis.da.entity;

import lombok.*;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class InquiryView extends Inquiry {
    /**
     * ユーザー
     */
    private User user;
}
