package org.pi.overview.reader

import scala.io.Source
import java.net.URL
import scala.xml.{NodeSeq, XML}

/**
 * Created by Nicolas on 16.02.14.
 */
 trait XmlReader {

  val source: Source
  val xmlString: String
  val xml: NodeSeq
  def generateObjects[T](xml:NodeSeq): Seq[T]
}
