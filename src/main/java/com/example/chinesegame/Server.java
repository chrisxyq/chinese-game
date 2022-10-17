package com.example.chinesegame;

import com.example.chinesegame.dto.ParsedChinese;
import com.example.chinesegame.utils.ChineseParser;

import java.util.List;
import java.util.Map;

/**
 * Q、服务端保存汉字和偏旁的数据结构，并如何验证汉字组合正确？请用编码实现
 * 分两部分：
 * 1、服务端输出接口，比如客户端读取接口，服务端下发什么样的数据结构给前端？
 * 2、2、客户端上传接口，客户端上传什么样的数据结构给服务端，用来服务端验证？
 * 说明：
 * 1、参照上图游戏规则，设计服务端下发接口契约和客户端验证数据契约（需要实现具体拆解实例和验证过程），核心就是服务端字怎么拆，客户端怎么合并，最后怎么验证合并的是否正确。
 * 2、 限定一个字 最多只能分三块， 上中下， 左中右，或者如图所示 蠢字 上下下， 或者下上上，还有霸上左下右下等。形式不限。
 * 3、汉字示例：双、夸、蠢、从、鹏、朋、森、林、好、孙、骑、霸
 * 4、并非是需要罗列所有汉字，而是总结出汉字拆解和合并的规律
 */
public class Server {
    /**
     * 服务端保存汉字和偏旁的数据结构
     */
    private List<String> chineseList;
    private Map<String,List<ParsedChinese>> parsedChineseMap;

    public List<String> getChineseList() {
        return chineseList;
    }

    public Map<String, List<ParsedChinese>> getParsedChineseMap() {
        return parsedChineseMap;
    }

    /**
     * 1、服务端输出接口，服务端下发数据结构给前端
     *
     * @param chineseList
     * @return
     * @throws Exception
     */
    public Map<String, List<ParsedChinese>> sendDataToClient(List<String> chineseList) throws Exception {
        this.chineseList = chineseList;
        this.parsedChineseMap = ChineseParser.parseList(chineseList);
        return this.parsedChineseMap;
    }
}
