package org.pi.overview.reader

import scala.xml.XML
import java.io.{InputStreamReader, FileInputStream}
import org.pi.overview.model.Properties
import scala.io.Source


/**
 * Created by Nicolas on 17.02.14.
 */
class PropertyReader {

  def load(fromFile: java.io.Reader): Properties = {
    val xml = XML.load(new InputStreamReader(new FileInputStream("../properties/properties.xml"), "UTF-8"))
    new Properties(

    )
  }
}
