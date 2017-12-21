package com.oag.interview

import java.nio.file.{Files, Path}
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import resource.managed

/**
  * This code is not part of the exercise and is only here to produce a sample input file with the expected structure.
  *
  * Do not change the behavior of this class or the structure of the input file as part of your solution.
  */
object CsvCreator {
  def createSampleCsv(path: Path): Unit = {
    managed(Files.newBufferedWriter(path)).acquireAndGet { writer =>
      writer.write("wellId,field,date,oil,gas,water,flare,choke,line_press")
      writer.newLine()

      (1 to 2173).foreach { i =>
        val wellId = 11111111111110L + i
        val rows = util.Random.nextInt(2100) + 380
        (1 to rows).foreach { j =>
          writer.write("%d,%s,%s,%d,%d,%d,%d,%d,%d".format(wellId,
                                                           field(wellId),
                                                           LocalDate.of(2017, 10, 1).minus(rows - j, ChronoUnit.DAYS),
                                                           prodValue(21, 121),
                                                           prodValue(4, 36),
                                                           prodValue(3, 31),
                                                           prodValue(1, 3),
                                                           prodValue(12, 24),
                                                           prodValue(50, 600)))
          writer.newLine()
        }
      }
    }
  }

  private def prodValue(lower: Int, upper: Int): Int = {
    val num = util.Random.nextInt(upper - lower + 1)
    if(num != 0) lower + (num - 1) else num
  }

  private val fields = Array("Elm Coulee",
                             "Beaver Lodge",
                             "Pine",
                             "Pennel",
                             "Cabin Creek",
                             "Little Knife",
                             "Tioga",
                             "Blue Buttes",
                             "Charlson")

  private def field(wellId: Long): String = {
    val idx = ((wellId / 10) % fields.length).toInt
    fields(idx)
  }
}
