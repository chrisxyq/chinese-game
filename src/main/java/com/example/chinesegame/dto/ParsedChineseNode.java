package com.example.chinesegame.dto;

import lombok.Data;

/**
 * ParsedChinese的属性
 */
@Data
public class ParsedChineseNode {
    private String var;
    /**
     * 字映射的值
     */
    private Integer value;
}
