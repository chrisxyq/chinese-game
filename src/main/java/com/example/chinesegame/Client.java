package com.example.chinesegame;


import com.example.chinesegame.dto.ParsedChinese;

import java.util.List;

public class Client {
    /**
     * 8行5列的二维数组
     */
    private final String[][] chineseSquare = new String[8][5];

    /**
     * 客户端消费服务端发来的数据
     *
     * @param parsedChineseList：服务端发送的所有数据
     * @param consumeIndex：客户端消费的数据位置索引
     * @param row：客户端接收的数据要放的位置：行
     * @param column：客户端接收的数据要放的位置：列
     */
    public void receiveDataFromServer(List<ParsedChinese> parsedChineseList,
                                      int consumeIndex,
                                      int row, int column) {

    }
}
