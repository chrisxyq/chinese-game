package com.example.chinesegame;


import com.example.chinesegame.dto.MatchResult;
import com.example.chinesegame.dto.StrokeNode;
import com.example.chinesegame.dto.PathNodeStr;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

public class Client {
    /**
     * 对应不同方向遍历-->向上、向下、向左、向右
     */
    private static int[][]           DIRECTIONS   = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * 存放汉字的二维数组
     */
    private        StrokeNode[][]    board        = null;
    private        List<PathNodeStr> pathNodeList = new LinkedList<>();

    public Client(int boardRow, int boardColumn) {
        this.board = new StrokeNode[boardRow][boardColumn];
    }

    public List<PathNodeStr> getPathNodeList() {
        return pathNodeList;
    }

    public StrokeNode[][] getBoard() {
        return board;
    }

    /**
     * 由于是dfs，先打印的是最深层
     *
     * @param i：当前遍历的行
     * @param j：当前遍历的列
     * @param word：目标字符串
     * @param p：当前遍历到目标字符串的第几个字符
     * @return
     */
    public MatchResult receiveDataFromServer(int i, int j, String[] word, int p, StrokeNode node) {
        System.out.println(String.format("客户端接收数据:%s，放置到第%s行，第%s列", node, i + 1, j + 1));
        board[i][j] = node;
        boolean res = dfs(i, j, word, p);
        StringBuilder pathStr = new StringBuilder();
        if (res) {
            /**
             * 字体从按照上下左右的顺序写
             */
            pathNodeList = pathNodeList.stream().sorted(new Comparator<PathNodeStr>() {
                @Override
                public int compare(PathNodeStr o1, PathNodeStr o2) {
                    int compare = Integer.compare(o1.getRow(), o2.getRow());
                    if (compare != 0) {
                        return compare;
                    }
                    return Integer.compare(o1.getColumn(), o2.getColumn());
                }
            }).collect(Collectors.toList());
            for (PathNodeStr nodeStr : pathNodeList) {
                pathStr.append(nodeStr.getStr());
            }
            System.out.println(String.format("客户端接收数据:%s找到合并汉字,匹配结果：%s", node, pathStr));
        } else {
            System.out.println(String.format("客户端接收数据:%s未找到合并汉字,待匹配汉字：%s", node,Arrays.toString(word)));
        }
        return new MatchResult(pathNodeList,pathStr.toString());
    }

    public boolean dfs(int i, int j, String[] word, int p) {
        if (p == word.length) return true;
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == null ||
                !Objects.equals(board[i][j].getStrokeNum(), word[p])) {
            return false;
        }
        String temp = word[p];
        board[i][j] = new StrokeNode("*", board[i][j].getValidDirections());
        boolean flag = false;
        for (int index = 0; index < DIRECTIONS.length; index++) {
            if (board[i][j].getValidDirections()[index] == 0) {
                continue;
            }
            flag = flag || dfs(i + DIRECTIONS[index][0], j + DIRECTIONS[index][1], word, p + 1);
            if (flag) {
                pathNodeList.add(new PathNodeStr(i, j, temp));
                break;
            }
        }
        board[i][j] = new StrokeNode(temp, board[i][j].getValidDirections());
        return flag;
    }

    /**
     * step4、匹配成功，客户端清除匹配结果
     * @param pathNodeList
     */
    public void clearMatchResult(List<PathNodeStr> pathNodeList) {
        if(!CollectionUtils.isEmpty(pathNodeList)){
            for (PathNodeStr pathNodeStr : pathNodeList) {
                board[pathNodeStr.getRow()][pathNodeStr.getColumn()]=null;
            }
            this.pathNodeList = new LinkedList<>();
        }
    }

}
