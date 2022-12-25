package ru.jamsys.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import ru.jamsys.App;

class TrendTest {

    @BeforeAll
    static void beforeAll() {
        String[] args = new String[]{};
        App.context = SpringApplication.run(App.class, args);
    }

    @Test
    void get() {
        Trend bean = App.context.getBean(Trend.class);
        Assertions.assertEquals(Double.parseDouble("27.700000000000017"), bean.get(2, new double[]{13, 25, 98, 40, 15, 66}), "#1");
        Assertions.assertEquals(Double.parseDouble("160.00000000000068"), bean.get(3, new double[]{13, 25, 98, 40, 15, 66}), "#2");
        Assertions.assertEquals(Double.parseDouble("512.4999999999927"), bean.get(4, new double[]{13, 25, 98, 40, 15, 66}), "#3");
        Assertions.assertEquals(Double.parseDouble("512.4999999999927"), bean.get(5, new double[]{13, 25, 98, 40, 15, 66}), "#3");
    }
}