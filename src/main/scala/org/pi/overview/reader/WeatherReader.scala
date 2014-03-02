package org.pi.overview.reader

import scala.io.Source
import java.net.URL
import scala.xml.{XML, NodeSeq}
import org.pi.overview.model.{Forecast, Weather}

/**
 * Created by Nicolas on 16.02.14.
 */
class WeatherReader{
  val source = Source.fromURL(new URL("http://weather.yahooapis.com/forecastrss?w=667931&u=c"))
  val xmlString: String = source.mkString
  val xml: NodeSeq = XML.loadString(xmlString)

  val source_2 = Source.fromURL(new URL("http://weather.yahooapis.com/forecastrss?w=695336&u=c"))
  val s2XmlString = source_2.mkString
  val xml_2 = XML.loadString(s2XmlString)

  def generateObjects(xml: NodeSeq): org.pi.overview.model.Weather = {
    Weather(xml \\ "location" \ "@city" text,
                        xml \\ "@region" text,
                        xml \\ "@country" text,
                        xml \\ "@chill" text,
                        xml \\ "@direction" text,
                        xml \\ "@speed" text,
                        xml \\ "lastBuildDate" text,
                        xml \\ "item" \\ "condition" \ "@text" text,
                        xml \\ "item" \\ "condition" \ "@temp" text,
                        xml \\ "item" \\ "condition" \ "@date" text,
                        for {
                          fc <- xml \\ "item" \ "forecast"
                        } yield new Forecast(fc \ "@day" text,
                          fc \ "@date" text,
                          fc \ "@low" text,
                          fc \ "@high" text,
                          fc \ "@text" text)
    )
  }
}

object WeatherReader {
  val COLOGNE_WEATHER_URL = "http://weather.yahooapis.com/forecastrss?w=667931&u=c"
  val SOLINGEN_WEATHER_URL = "http://weather.yahooapis.com/forecastrss?w=695336&u=c"
}
