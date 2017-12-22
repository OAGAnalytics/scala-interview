package com.oag.interview

import com.opencsv.CSVParserBuilder
import java.nio.file.{Files, Paths}
import org.scalatest.{FlatSpec, Matchers}
import resource.managed
import scala.io.Source

class CsvTest extends FlatSpec with Matchers {
  private val dataDir = Paths.get("data")
  private val parser = new CSVParserBuilder().build()

  "csv" should "be created" in {
    Files.createDirectories(dataDir)

    val dataFile = dataDir.resolve("daily_prod.csv")
    CsvCreator.createSampleCsv(dataFile)

    Files.exists(dataFile) should be(true)
  }

  "oil-by-operated-day" should "contain appropriate columns" in {
    val transformer = new CsvTransformer(dataDir.resolve("daily_prod.csv"))
    val outFile = dataDir.resolve("oil-by-operated-day.csv")
    transformer.dailyOilToOperatedDay(outFile)

    val headers = managed(Files.newInputStream(outFile)) apply { is =>
      parser.parseLine(Source.fromInputStream(is).getLines().toSeq.head)
    }

    headers.size should be(4)
    headers(0) should be("wellId")
    headers(1) should be("cum_oil_180")
    headers(2) should be("cum_oil_360")
    headers(3) should be("cum_oil_720")
  }

  "gas-by-operated-day" should "contain appropriate columns" in {
    val transformer = new CsvTransformer(dataDir.resolve("daily_prod.csv"))
    val outFile = dataDir.resolve("gas-by-operated-day.csv")
    transformer.dailyGasToOperatedDay(outFile)

    val headers = managed(Files.newInputStream(outFile)) apply { is =>
      parser.parseLine(Source.fromInputStream(is).getLines().toSeq.head)
    }

    headers.size should be(4)
    headers(0) should be("wellId")
    headers(1) should be("cum_gas_180")
    headers(2) should be("cum_gas_360")
    headers(3) should be("cum_gas_720")
  }

  "water-by-operated-day" should "contain appropriate columns" in {
    val transformer = new CsvTransformer(dataDir.resolve("daily_prod.csv"))
    val outFile = dataDir.resolve("water-by-operated-day.csv")
    transformer.dailyWaterToOperatedDay(outFile)

    val headers = managed(Files.newInputStream(outFile)) apply { is =>
      parser.parseLine(Source.fromInputStream(is).getLines().toSeq.head)
    }

    headers.size should be(4)
    headers(0) should be("wellId")
    headers(1) should be("cum_water_180")
    headers(2) should be("cum_water_360")
    headers(3) should be("cum_water_720")
  }

  // TODO: Add a test that calls your new method for Oil and Gas and verifies appropriate output

  // TODO: Add a test that calls your new method for Oil and Water and verifies appropriate output

  // TODO: Add a test that calls your new method for Gas and Water and verifies appropriate output

  // TODO: Add a test that calls your new method for Oil, Gas, and Water and verifies appropriate output

  "cleanup" should "happen" in {
    managed(Files.list(dataDir)) apply { stream =>
      stream.forEach { path =>
        Files.delete(path)
      }
    }

    Files.delete(dataDir)

    Files.exists(dataDir) should be(false)
  }
}
