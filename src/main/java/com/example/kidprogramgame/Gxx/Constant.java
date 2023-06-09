package com.example.kidprogramgame.Gxx;

//一些常量
public class Constant {
    //地图快大小
    public static final int blockSize = 64;
    //地图块行列数量
    public static final int blockNum = 10;
    //图片路径前缀
    public static final String imagePath = "file:src/main/resources/com/example/kidprogramgame/image/";

    //地图高度
    public static final int mapHeight = 640;
    //地图宽度
    public static final int mapWidth = 640;
    //地图块编号代表
    // 0 - 陆地
    // 1 - 陷阱
    // 2 - 水
    // 3 - 家
    // 4 - 星星

    //返回状态编号代表
    //-1 - 越界 彻底迷路了
    // 0 - 正常
    // 1 - 掉进陷阱了
    // 2 - 掉进水里了
    // 3 - 到家了
}
