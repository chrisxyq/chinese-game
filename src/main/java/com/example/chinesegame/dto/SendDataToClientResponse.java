package com.example.chinesegame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendDataToClientResponse {
    /**
     * 服务端发送的词汇列表
     */
    List<StrokeNode> strokeNodeList ;
    /**
     * 目标单词
     */
    List<String[]> wordList;
}
