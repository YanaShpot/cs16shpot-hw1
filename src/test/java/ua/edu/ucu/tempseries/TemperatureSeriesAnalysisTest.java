package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeviationOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.max();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.min();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZerotestOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.findTempClosestToValue(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsOfEmptyArr() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsTooSmall() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // expect exception here
        seriesAnalysis.addTemps(2,-300);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 31.963758774587195;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -2.0d;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-0.7,-1.1,-5,-7,-8,-23,-2,-100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -0.7d;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void  testFindTempClosestToZero() {
        double[] temperatureSeries = {-2, 2, 34, 35, -36, 37, 100, 39, 40};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 2.0d;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001d);
    }

    @Test
    public void  testFindTempClosestToValue() {
        double[] temperatureSeries = {-2, 2, 34, 35, -36, 37, 100, 39, 40};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 37;
        double actualResult = seriesAnalysis.findTempClosestToValue(36.5d);
        assertEquals(expResult, actualResult, 0.00001d);
    }

    @Test
    public void testGreaterThenValue() {
        double[] temperatureSeries = {-0.7,1.1,5,7,8,23,-2,100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[4];
        expResult[0] = 7.0;
        expResult[1] = 8.0;
        expResult[2] = 23.0;
        expResult[3] = 100.0;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(6);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testLessThenValue() {
        double[] temperatureSeries = {-0.7, 1.1, 5, 7, 8, 23, -2, 100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[4];
        expResult[0] = -0.7;
        expResult[1] = 1.1;
        expResult[2] = 5.0;
        expResult[3] = -2.0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(6);
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {-0.7, 1.1, 5, 7, 8, 23, -2, 100};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 31.963758774587195;
        TempSummaryStatistics sumStat = seriesAnalysis.summaryStatistics();
        double actualResult = sumStat.devTemp;
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void  testAddTemp() {
        double[] temperatureSeries = new double[]{2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 3;

        int actualResult = seriesAnalysis.addTemps( 1.0, 3.1 );

        assertEquals(expResult, actualResult, 0.00001d);
    }
}
