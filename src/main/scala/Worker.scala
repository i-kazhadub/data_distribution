import DataOperation.{Package, Stop, Wait}

import java.util.concurrent.Callable

class Worker(var input: DataSource, var output: DataSource) extends Callable[Int] {

  def call(): Int = {
    var numberOfPackages: Int = 0
    var shouldContinue: Boolean = true
    while (shouldContinue) {
      var dataPackage: DataPackage = null
      dataPackage = input.read(numberOfPackages)
      dataPackage.operation match {
        case Stop => {
          shouldContinue = false
          output.close()
        }
        case Package => {
          numberOfPackages += 1
          if (!output.write(dataPackage)) {
            printf("Write has failed.")
            shouldContinue = false
          }
        }
        case Wait => {
          Thread.sleep(5000)
        };
      }
    }
    numberOfPackages
  }


}
