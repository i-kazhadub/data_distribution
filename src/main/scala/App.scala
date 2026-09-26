import java.util.concurrent.{ArrayBlockingQueue, ThreadPoolExecutor, TimeUnit}
import scala.jdk.CollectionConverters._

object App {
  def main(args: Array[String]): Unit = {
    printf("Starting magic task...")
    val workQueue = new ArrayBlockingQueue[Runnable](30)
    val executor = new ThreadPoolExecutor(10, 90, 100, TimeUnit.HOURS, workQueue)
    def singleSource = ArrayConnector()
    def task1 = Worker(singleSource, ConsoleConnector())
    def task2 = Worker(singleSource, ConsoleConnector())
    def task3 = Worker(singleSource, ArrayConnector())
    def result = executor.invokeAll(List(task1, task3, task2).asJava)
    result.forEach(task => {
      def numberOfPackages = task.get(360, TimeUnit.HOURS)
      println(s"Number of packages processed by Worker: $numberOfPackages")
    })
    executor.shutdown()
  }
}
