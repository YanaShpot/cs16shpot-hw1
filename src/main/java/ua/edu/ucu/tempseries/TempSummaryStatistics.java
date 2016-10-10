package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
        public double avgTemp;
        public double devTemp;
        public double minTemp;
        public double maxTemp;

        public TempSummaryStatistics(double [] temp) {
            TemperatureSeriesAnalysis temp1 = new TemperatureSeriesAnalysis(temp);
            this.avgTemp = temp1.average();
            this.devTemp = temp1.deviation();
            this.minTemp = temp1.min();
            this.maxTemp = temp1.max();
        }


    
}
