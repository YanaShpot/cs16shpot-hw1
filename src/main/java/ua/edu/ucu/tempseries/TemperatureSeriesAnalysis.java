package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis { 
    public double[] temperatureSeries;
    public int len;

    public TemperatureSeriesAnalysis() { 

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) { 
        this.len = temperatureSeries.length;
        this.temperatureSeries = new double[this.len];
       for (int i = 0; i < this.len; ++i) { 
           if (temperatureSeries[i] >= -273) { 
               this.temperatureSeries[i] = temperatureSeries[i];
           }
           else { 
               throw new InputMismatchException();
           }


       }


    }

    public double average() { 
        double sum = 0;
        if (this.len == 0) { 
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < this.len; ++i) { 
            sum += this.temperatureSeries[i];
        }

        return sum/this.temperatureSeries.length;

    }

    public double deviation() { 
        if (this.temperatureSeries == null) { 
            throw new IllegalArgumentException();
        }
        double aver = this.average();
        double squareDeviation = 0;
        for (int i = 0; i < this.len; ++i) { 
            squareDeviation += Math.pow(this.temperatureSeries[i] - aver,2);
        }


        return Math.sqrt(squareDeviation / this.len);

    }

    public double min() { 
        if (this.len == 0) { 
            throw new IllegalArgumentException();
        }
        double min = this.temperatureSeries[0];
        for (int i = 1; i < this.len; ++i) { 
            if (this.temperatureSeries[i] < min) { 
                min = this.temperatureSeries[i];
            }
        }
        return min;


    }

    public double max() { 
        if (this.len == 0) { 
            throw new IllegalArgumentException();
        }
        double max = this.temperatureSeries[0];
        for (int i = 1; i < this.len; ++i) { 
            if (this.temperatureSeries[i] > max) { 
                max = this.temperatureSeries[i];
            }
        }
        return max;

        //return 0;
    }

    public double findTempClosestToZero() { 
        if (this.len == 0) { 
            throw new IllegalArgumentException();
        }
        double minAbs = Double.MAX_VALUE;
        for (int i = 0; i < this.len; ++i) { 
            if (Math.abs(this.temperatureSeries[i]) < Math.abs(minAbs)
                    || this.temperatureSeries[i] == Math.abs(minAbs) ) { 
                minAbs = this.temperatureSeries[i];
            }
        }
        return minAbs;

    }

    public double findTempClosestToValue(double tempValue) { 
        if (this.len == 0) { 
            throw new IllegalArgumentException();
        }
        double closest = Double.MAX_VALUE;
        for (int i = 0; i < this.len; ++i) { 
            if (Math.abs(this.temperatureSeries[i] - tempValue)
                    < Math.abs(closest - tempValue)) {
                closest = this.temperatureSeries[i];
            }
        }
        return closest;

    }

    public double[] findTempsLessThen(double tempValue) { 
        double [] arrOfLess = new double [this.len];
        int j = 0;
        for (int i = 0; i < this.len; ++i) { 
            if (this.temperatureSeries[i] < tempValue) { 
                arrOfLess[i] = this.temperatureSeries[i];
                j++;
            }
        }
        double []  arrOfLessF= new double [j];
        for (int i=0; i<this.len; ++i) { 
            if (arrOfLess[i] != 0) { 
                arrOfLessF[arrOfLessF.length - j] = arrOfLess[i];
                --j;
            }
        }
        return arrOfLessF;

    }

    public double[] findTempsGreaterThen(double tempValue) { 
        double [] arrOfG = new double [this.len];
        int j = 0;
        for (int i = 0; i < this.len; ++i) { 
            if (this.temperatureSeries[i] > tempValue ) { 
                arrOfG[i] = this.temperatureSeries[i];
                j++;
            }
        }
        double []  arrOfGF= new double [j];
        for (int i=0; i<this.len; ++i ) { 
            if (arrOfG[i] !=0 ) { 
                arrOfGF[arrOfGF.length - j] = arrOfG[i];
                --j;
            }
        }
        return arrOfGF;
    }

    public TempSummaryStatistics summaryStatistics() { 
        if (this.temperatureSeries == null ) { 
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(this.temperatureSeries);
    }

    public int addTemps(double... temps) { 


        for (double i: temps) { 
            if (i < -273.1) { 
                throw new InputMismatchException();
            }
        }
        if (this.temperatureSeries.length == this.len) { 
            while (this.temperatureSeries.length - this.len < temps.length) { 
                double[] newTempSeries = new double[this.temperatureSeries.length * 2];
                for (int i = 0; i < this.temperatureSeries.length; ++i) { 
                    newTempSeries[i] = this.temperatureSeries[i];
                }
                this.temperatureSeries = newTempSeries;
            }
        }
        for (double t: temps ) { 
            this.temperatureSeries[this.len] = t;
            this.len += 1;
        }
        return this.len;

    }
}
