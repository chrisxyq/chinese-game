package com.example.chinesegame.utils;

import com.example.chinesegame.dto.ParsedChinese;
import com.example.chinesegame.dto.ParsedChineseNode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 读取中文字
 * 得到 服务端下发给前端的数据结构
 */
public class ChineseParser implements IChineseParser {

    public static List<ParsedChinese> parseList(List<String> list) throws Exception {
        List<ParsedChinese> resList = new ArrayList<>();
        for (String s : list) {
            resList.addAll(parseChinese(s));
        }
        return resList;
    }

    public static List<ParsedChinese> parseChinese(String chinese) throws Exception {
        List<ParsedChinese> parsedChineseList = null;
        switch (chinese){
            case "双":
                ParsedChinese parsedChinese = new ParsedChinese();
                parsedChinese.setNode(new ParsedChineseNode("又",StrokeComputer.getBiShun("又")));
                HashMap<String, String> leftMap = new HashMap<>();
                leftMap.put("又",StrokeComputer.getBiShun("又"));
                parsedChinese.setLeftMap(leftMap);
                HashMap<String, String> rightMap = new HashMap<>();
                rightMap.put("又",StrokeComputer.getBiShun("又"));
                parsedChinese.setRightMap(rightMap);
                parsedChineseList= new ArrayList<>(Collections.singletonList(parsedChinese));
                break;
            case "夸":
                ParsedChinese parsedChinese1 = new ParsedChinese();
                parsedChinese1.setNode(new ParsedChineseNode("大",StrokeComputer.getBiShun("大")));
                HashMap<String, String> downMap = new HashMap<>();
                downMap.put("亏",StrokeComputer.getBiShun("亏"));
                parsedChinese1.setDownMap(downMap);
                parsedChineseList = new ArrayList<>();
                parsedChineseList.add(parsedChinese1);
                ParsedChinese parsedChinese2 = new ParsedChinese();
                parsedChinese2.setNode(new ParsedChineseNode("亏",StrokeComputer.getBiShun("亏")));
                parsedChineseList.add(parsedChinese2);
                break;
            default:
                throw new UnsupportedOperationException("暂不支持该中文");
        }
        return parsedChineseList;
    }
}
