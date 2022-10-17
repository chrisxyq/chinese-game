package com.example.chinesegame.utils;

import com.example.chinesegame.dto.ParsedChinese;

import java.util.List;

public interface IChineseParser {
    List<ParsedChinese> parseChinese(String chinese) throws Exception;
}
