package org.pi.overview.model

/**
 * Created by Nicolas on 16.02.14.
 */
case class Forecast(day:String, date:String, tempLow:String, tempHigh:String, text:String) {

  override def toString:String = {
    date + "\n" + day + "\nLow: " + tempLow + "\nHigh: " + tempHigh + "\n" + text
  }
}
