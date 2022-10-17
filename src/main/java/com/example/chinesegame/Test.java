package com.example.chinesegame;

import com.example.chinesegame.dto.ParsedChinese;
import com.example.chinesegame.utils.ChineseParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        Server server = new Server();
        //1、服务端输出接口，服务端下发数据结构给前端
        Map<String, List<ParsedChinese>> sendData = server.sendDataToClient(chineseList);
        System.out.println(sendData);
        //
        Client client = new Client();
//        client.receiveDataFromServer( sendData,
//         consumeIndex,
//         row,  column);


    }
}
