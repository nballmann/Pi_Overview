package org.pi.overview.reader

import scala.io.Source
import java.net.URL
import scala.xml.{NodeSeq, XML}
import org.pi.overview.model.Transit

/**
 * Created by Nicolas on 16.02.14.
 */
class TransitReader {

  val departureTime = System.currentTimeMillis() / 1000 + 300
  val source = Source.fromURL(new URL("http://maps.googleapis.com/maps/api/directions/xml?origin=Solingen+Hbf,+Ohligs,&destination=K%C3%B6ln+Hbf,+K%C3%B6ln,&sensor=false&departure_time=" + departureTime + "&alternatives=true&mode=transit"))
  val xmlString = source.mkString
  val xml = XML.loadString(xmlString)

  def generateObjects(xml:NodeSeq): Seq[Transit] = {
    for {
      leg <- xml \\ "leg"
    } yield Transit(leg \\ "duration" \\ "text" text,
                        leg \\ "transit_details" \\ "departure_stop" \\ "name" text,
                        leg \\ "transit_details" \\ "arrival_stop" \\ "name" text,
                        leg \\ "transit_details" \\ "line" \\ "short_name" text,
                        leg \\ "transit_details" \\ "departure_time" \\ "text" text,
                        leg \\ "transit_details" \\ "arrival_time" \\ "text" text)
  }
}
