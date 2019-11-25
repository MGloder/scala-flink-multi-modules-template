package producer.source

import java.util.Calendar

import org.apache.flink.streaming.api.functions.source.{RichParallelSourceFunction, SourceFunction}
import producer.schema.SensorReading

import scala.util.Random

class SensorReadingGenerator extends RichParallelSourceFunction[SensorReading] {
  var running: Boolean = true

  val maxItem = 10
  val scaler = 100

  override def run(ctx: SourceFunction.SourceContext[SensorReading]): Unit = {
    val rand = new Random()

    val taskId = this.getRuntimeContext.getIndexOfThisSubtask

    while (running) {
      val curTime = Calendar.getInstance.getTimeInMillis
      val sourceList = (0 to rand.nextInt(maxItem)).foreach {
        i => ctx.collectWithTimestamp(SensorReading(i.toString, rand.nextFloat() * scaler, curTime), curTime)
      }
      Thread.sleep(3000)
    }
  }

  override def cancel(): Unit = running = false
}
