package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
        public double avgTemp;
        public double devTemp;
        public double minTemp;
        public double maxTemp;

        public TempSummaryStatistics(double [] temp) {
            TemperatureSeriesAnalysis temperatureSeries = new TemperatureSeriesAnalysis(temp);
            this.avgTemp = temperatureSeries.average();
            this.devTemp = temperatureSeries.deviation();
            this.minTemp = temperatureSeries.min();
            this.maxTemp = temperatureSeries.max();
        }


    
}
