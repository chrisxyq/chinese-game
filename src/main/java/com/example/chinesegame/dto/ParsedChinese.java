package com.example.chinesegame.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * 服务端下发给前端的数据结构
 */
@Data
public class ParsedChinese {
    /**
     * 字映射的值
     */
    private String value;
    private List<Neighbor> neighborList;


}
