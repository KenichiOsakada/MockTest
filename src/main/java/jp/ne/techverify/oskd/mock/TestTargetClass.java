package jp.ne.techverify.oskd.mock;

import java.util.Random;

/**
 * Test対象クラス
 */
public class TestTargetClass {
    /**
     * min-max間のランダムな整数を返却します.
     * @param min 最小値
     * @param max 最大値
     * @return ランダムな整数
     *
     */
    public static int  getRandomName(int min, int max){
        return new Random().nextInt(max-min) + min;
    }
}
