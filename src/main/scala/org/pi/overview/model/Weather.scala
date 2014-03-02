package org.pi.overview.model

/**
 * Created by Nicolas on 16.02.14.
 */
case class Weather(city:String,
                    region:String,
                    country:String,
                    windChill:String,
                    windDirection:String,
                    windSpeed:String,
                    lastUpdate:String,
                    currConditionText:String,
                    currConditionTemp:String,
                    currConditionDate:String,
                    forecast:Seq[Forecast]) {

  override def toString:String = {
    city + " " + region + " " + country + "\n" +
    currConditionDate + "\n" +
    currConditionText + "\n" +
    currConditionTemp + "\n" +
    "Chill: " + windChill + " Wind direction: " + windDirection + " Wind Speed: " + windSpeed + "\n" +
    "Last Update: " + lastUpdate + "\n" + forecast.mkString("\n")
  }

}
