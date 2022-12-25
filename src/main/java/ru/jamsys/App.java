package ru.jamsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.jamsys.trend.PolyTrendLine;

import java.util.Arrays;

@SpringBootApplication
public class App {

    public static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(App.class, args);
        //System.out.println("Hello World!");

        PolyTrendLine t = new PolyTrendLine(2);

        /*Random rand = new Random();
        double[] x = new double[1000*1000];
        double[] err = new double[x.length];
        double[] y = new double[x.length];
        for (int i=0; i<x.length; i++) { x[i] = 1000*rand.nextDouble(); }
        for (int i=0; i<x.length; i++) { err[i] = 100*rand.nextGaussian(); }
        for (int i=0; i<x.length; i++) { y[i] = x[i]*x[i]+err[i]; } // quadratic model*/


        t.setValues(new double[]{13,25,98,40,15,66}, new double[]{1,2,3,4,5,6});
        System.out.println("tl.predict(20) = " + t.predict(7));
        System.out.println(Arrays.toString(t.getCoefficients()));
    }

}