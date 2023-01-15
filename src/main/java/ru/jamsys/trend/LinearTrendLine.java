package ru.jamsys.trend;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class LinearTrendLine {
    public static double main(double[] line, double predict) {

        // creating regression object, passing true to have intercept term
        SimpleRegression simpleRegression = new SimpleRegression(true);

        // passing data to the model
        // model will be fitted automatically by the class
        double[][] doubles = new double[line.length][2];
        for (int i = 0; i < line.length; i++) {
            doubles[i][0] = i;
            doubles[i][1] = line[i];
        }

        simpleRegression.addData(doubles);

        // querying for model parameters
        // System.out.println("slope = " + simpleRegression.getSlope());
        // System.out.println("intercept = " + simpleRegression.getIntercept());

        // trying to run model for unknown data
        // System.out.println(predict);
        return simpleRegression.predict(line.length - 1 + predict);

    }
}
