package com.example.chinesegame.dto;

import lombok.Data;

import java.util.HashMap;

/**
 * 服务端下发给前端的数据结构
 */
@Data
public class ParsedChinese {
    private ParsedChineseNode node;
    /**
     * key为中文，value为笔画的值
     */
    private HashMap<String,String> leftMap;
    private HashMap<String,String> rightMap;
    private HashMap<String,String> downMap;

}
