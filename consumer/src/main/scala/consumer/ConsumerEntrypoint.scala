package consumer

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.api.scala._

object ConsumerEntrypoint {
  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.fromElements(Seq(1,2,3)).print()

    env.execute()
  }

  case class Person(id: Int)

}
