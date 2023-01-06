package ru.jamsys.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.jamsys.trend.PolyTrendLine;

@Component
@Lazy
public class Trend {

    public double get(int degree, double[] line) {
        return get(degree, line, line.length + 1);
    }

    public double get(int degree, double[] line, double predict) {
        PolyTrendLine t = new PolyTrendLine(degree);
        double[] x = new double[line.length];
        for (int i = 0; i < line.length; i++) {
            x[i] = i + 1;
        }
        t.setValues(line, x);
        return t.predict(predict);
    }

}
