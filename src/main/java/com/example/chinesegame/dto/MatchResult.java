package com.example.chinesegame.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchResult {
    private List<PathNodeStr> pathNodeList;
    private String pathStr;
}
