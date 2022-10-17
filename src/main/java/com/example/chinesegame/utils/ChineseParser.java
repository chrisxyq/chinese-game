package com.example.chinesegame.utils;

import com.example.chinesegame.dto.Neighbor;
import com.example.chinesegame.dto.ParsedChinese;
import com.example.chinesegame.dto.ParsedChineseNode;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 读取中文字
 * 得到 服务端下发给前端的数据结构
 */
public class ChineseParser implements IChineseParser {

    public static Map<String,List<ParsedChinese>> parseList(List<String> list) throws Exception {
        Map<String,List<ParsedChinese>> map = new HashMap<>();
        for (String chinese : list) {
            Map<String,List<ParsedChinese>> subMap = parseChinese(chinese);
            for (String key : subMap.keySet()) {
                if(map.containsKey(key)){
                    map.get(key).addAll(subMap.get(key));
                }else{
                    map.put(key,subMap.get(key));
                }
            }
        }
        return map;
    }

    public static Map<String,List<ParsedChinese>> parseChinese(String chinese) throws Exception {
        Map<String,List<ParsedChinese>> map = null;
        switch (chinese) {
            case "双":
                ParsedChinese parsedChinese1 = new ParsedChinese();
                parsedChinese1.setValue(StrokeComputer.getBiShun("又"));
                HashMap<String, String> leftMap = new HashMap<>();
                leftMap.put("又", StrokeComputer.getBiShun("又"));
                parsedChinese1.setNeighborList(new ArrayList<>(Collections.singletonList(
                        new Neighbor(leftMap, null, null))));
                //
                ParsedChinese parsedChinese2 = new ParsedChinese();
                parsedChinese2.setValue(StrokeComputer.getBiShun("又"));
                HashMap<String, String> rightMap = new HashMap<>();
                rightMap.put("又", StrokeComputer.getBiShun("又"));
                parsedChinese2.setNeighborList(new ArrayList<>(Collections.singletonList(
                        new Neighbor(null, rightMap, null))));
                //
                map = new HashMap<>();
                List<ParsedChinese> parsedChineseList =new ArrayList<>();
                parsedChineseList.add(parsedChinese1);
                parsedChineseList.add(parsedChinese2);
                map.put("又",parsedChineseList);
                break;
            case "夸":
                parsedChinese1 = new ParsedChinese();
                parsedChinese1.setValue(StrokeComputer.getBiShun("大"));
                HashMap<String, String> downMap = new HashMap<>();
                downMap.put("亏", StrokeComputer.getBiShun("亏"));
                parsedChinese1.setNeighborList(new ArrayList<>(Collections.singletonList(
                        new Neighbor(null, null, downMap))));
                map = new HashMap<>();
                map.put("大",new ArrayList<>(Collections.singletonList(
                        parsedChinese1)));
                //
                parsedChinese2 = new ParsedChinese();
                parsedChinese2.setValue(StrokeComputer.getBiShun("亏"));
                map.put("亏",new ArrayList<>(Collections.singletonList(
                        parsedChinese2)));
                break;
            default:
                throw new UnsupportedOperationException("暂不支持该中文");
        }

        return map;
    }
}
