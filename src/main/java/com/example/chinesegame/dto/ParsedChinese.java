package com.example.chinesegame.dto;

import lombok.Data;

import java.util.HashMap;

/**
 * 服务端下发给前端的数据结构
 */
@Data
public class ParsedChinese {
    private ParsedChineseNode node;
    private HashMap<String,Integer> leftMap;
    private HashMap<String,Integer> rightMap;
    private HashMap<String,Integer> downMap;
}
