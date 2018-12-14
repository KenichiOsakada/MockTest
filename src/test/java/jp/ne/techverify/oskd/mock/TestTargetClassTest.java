package jp.ne.techverify.oskd.mock;

import lombok.Data;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
public class TestTargetClassTest {

    private MockRandom mockedRandom;

    @Before
    public void before(){
        mockedRandom = new MockRandom();
    }

    @After
    public void after(){
        mockedRandom.tearDown();
    }

    @Test
    public void testRandomInt() {

        int max = 9;
        int min = 2;

        mockedRandom.setMax(max);
        mockedRandom.setMin(min);

        assertEquals(TestTargetClass.getRandomName(min,max),max);
        assertEquals(TestTargetClass.getRandomName(min,max),max);
    }

    @Data
    public class MockRandom extends MockUp<Random>{

        int max;
        int min;

        /**
         * 想定通りに{@link Random#nextInt(int)}を呼び出しているか確認する.
         * @param inv 実行情報取得
         * @param argMax 最大値
         * @return 指定された最大値を返却
         */
        @Mock(maxInvocations = 0)
        public int nextInt(Invocation inv, int argMax) {
            System.out.println("呼び出し回数＝"+inv.getInvocationCount());
            assertEquals("引数チェック",max-min,argMax);
            return argMax;
        }
    };
}
