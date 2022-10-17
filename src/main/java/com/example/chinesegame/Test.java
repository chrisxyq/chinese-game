package com.example.chinesegame;

import com.example.chinesegame.utils.ChineseParser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chrisxu
 * @create 2022-10-17 20:56
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class Test {
    public static void main(String[] args) throws Exception {
        List<String> chineseList = new ArrayList<>();
        chineseList.add("双");
        chineseList.add("夸");
        ChineseParser chineseParser = new ChineseParser(chineseList);
        System.out.println(chineseParser.getParsedChineseList());
    }
}
