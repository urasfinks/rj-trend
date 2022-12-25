package ru.jamsys.component;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import ru.jamsys.trend.PolyTrendLine;

@Component
@Lazy
public class Trend {

    public double get(int degree, double[] line) {
        PolyTrendLine t = new PolyTrendLine(degree);
        double[] x = new double[line.length];
        for (int i = 0; i < line.length; i++) {
            x[i] = i + 1;
        }
        t.setValues(line, x);
        return t.predict(line.length + 1);
    }

}
