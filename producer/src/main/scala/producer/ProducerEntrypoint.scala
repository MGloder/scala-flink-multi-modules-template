package producer

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.api.scala._

import producer.source.SensorReadingGenerator

object ProducerEntrypoint {
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.addSource(new SensorReadingGenerator).print()

    env.execute()
  }

  case class Person(id: Int)

}
