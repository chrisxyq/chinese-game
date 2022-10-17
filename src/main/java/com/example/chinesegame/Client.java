package com.example.chinesegame;


import com.example.chinesegame.dto.ParsedChinese;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

public class Client {
    /**
     * 8行5列的二维数组
     */
    private final String[][] chineseSquare = new String[8][5];

    /**
     * todo：客户端消费服务端发来的数据
     * todo：服务端记录map的数量
     * todo：客户端记录map元素消费的剩余数量
     *
     * @param parsedChineseList：服务端发送的所有数据
     * @param consumeIndex：客户端消费的数据位置索引
     * @param row：客户端接收的数据要放的位置：行
     * @param column：客户端接收的数据要放的位置：列
     */
    public void receiveDataFromServer(Map<String, List<ParsedChinese>> parsedChineseList,
                                      int consumeIndex,
                                      int row, int column) {
        validation(parsedChineseList, consumeIndex, row, column);

    }

    /**
     * todo：map中的key可能重复多次出现
     * @param parsedChineseList
     * @param consumeIndex
     * @param row
     * @param column
     */
    private void validation(Map<String, List<ParsedChinese>> parsedChineseList, int consumeIndex, int row, int column) {
        if (CollectionUtils.isEmpty(parsedChineseList)) {
            throw new RuntimeException("parsedChineseList empty!");
        }
        if (consumeIndex < 0 || consumeIndex > parsedChineseList.size() - 1) {
            throw new RuntimeException("consumeIndex invalid!");
        }
        if (row < 0 || row > chineseSquare.length - 1) {
            throw new RuntimeException("row invalid!");
        }
        if (column < 0 || column > chineseSquare[0].length - 1) {
            throw new RuntimeException("column invalid!");
        }
        if (StringUtils.hasLength(chineseSquare[row][column])) {
            throw new RuntimeException("row or column invalid!");
        }
    }
}
