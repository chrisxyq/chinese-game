package com.example.chinesegame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ParsedChinese的属性
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class ParsedChineseNode {
    private String chinese;
    /**
     * 字映射的值
     */
    private String value;
}
