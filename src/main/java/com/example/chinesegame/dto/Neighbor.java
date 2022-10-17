package com.example.chinesegame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neighbor {
    /**
     * key为中文，value为笔画的值
     */
    private HashMap<String, String> leftMap;
    private HashMap<String, String> rightMap;
    private HashMap<String, String> downMap;
}
