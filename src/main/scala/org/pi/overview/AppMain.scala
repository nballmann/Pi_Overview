package org.pi.overview

import org.pi.overview.reader.{WeatherReader, TransitReader, XmlReader}
import org.pi.overview.util.Utils

/**
 * Created by Nicolas on 16.02.14.
 */
object AppMain {
  def main(args: Array[String]) {
    val transit = new TransitReader
    for (i <- transit.generateObjects(transit.xml)) {
      println(i.toString)
    }
    val weather = new WeatherReader
    println(weather.generateObjects(weather.xml))

   // val sorted = Utils.mergesort(Seq(3,6,4,2,54,-1,8,4), (x: Int, y: Int) => x < y)
   // sorted.foreach(x => println(x))

  }
}
