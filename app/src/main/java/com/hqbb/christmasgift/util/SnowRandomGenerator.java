package com.hqbb.christmasgift.util;

import java.util.Random;

/**
 * 雪花随机生成器
 * @Author: yinlinhai
 * @Date: 2019/12/20
 */
public class SnowRandomGenerator {
    private static final Random RANDOM = new Random();

    // 区间随机
    public float getRandom(float lower, float upper) {
        float min = Math.min(lower, upper);
        float max = Math.max(lower, upper);
        return getRandom(max - min) + min;
    }

    // 生成一个指定上界的浮点数随机数
    public float getRandom(float upper) {
        return RANDOM.nextFloat() * upper;
    }

    // 生成一个指定上界的整数随机数
    public int getRandom(int upper) {
        return RANDOM.nextInt(upper);
    }
}
