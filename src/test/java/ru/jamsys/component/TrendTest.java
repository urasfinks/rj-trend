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
        Assertions.assertEquals(28, Math.round(bean.get(2, new double[]{13, 25, 98, 40, 15, 66})), "#1");
        Assertions.assertEquals(160, Math.round(bean.get(3, new double[]{13, 25, 98, 40, 15, 66})), "#2");
        Assertions.assertEquals(512, Math.round(bean.get(4, new double[]{13, 25, 98, 40, 15, 66})), "#3");
        Assertions.assertEquals(506, Math.round(bean.get(5, new double[]{13, 25, 98, 40, 15, 66, 300})), "#4");

    }

    @Test
    void getPredict() {
        Trend bean = App.context.getBean(Trend.class);
        Assertions.assertEquals(5, Math.round(bean.get(2, new double[]{1, 2, 3, 4})), "#1");
        Assertions.assertEquals(5, Math.round(bean.get(2, new double[]{1, 2, 3, 4}, 1)), "#2");
        Assertions.assertEquals(6, Math.round(bean.get(2, new double[]{1, 2, 3, 4}, 2)), "#3");
        Assertions.assertEquals(7, Math.round(bean.get(3, new double[]{1, 2, 3, 4, 5}, 2)), "#4");

    }
}