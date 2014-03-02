package org.pi.overview.model

/**
 * Created by Nicolas on 16.02.14.
 */
case class Transit(duration: String = "N/A",
                    departureStop: String = "N/A",
                    arrivalStop: String = "N/A",
                    line: String = "N/A",
                    departureTime: String = "N/A",
                    arrivalTime: String = "N/A") {

  override def toString: String = {
    "Connection:\n" + "Train: " + line +
    departureStop + " " + departureTime + "\n" +
    arrivalStop + " " + arrivalTime + "\n"
  }


}
