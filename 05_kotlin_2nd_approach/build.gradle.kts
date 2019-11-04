/**
 * вычисляет md5-сумму содержимого файла
 *
 * файл должен существовать и быть доступным для чтения
 */

fun File.checksum(): String {
  ant.withGroovyBuilder {
    "checksum"("file" to this@checksum, "property" to "output_md5")
  }
  return ant.properties["output_md5"] as String
}

tasks.register("printMd5") {
  doLast {
    val inputFile = file("../jug_nsk_logo.jpg")
    println("The checksum of $inputFile is ${inputFile.checksum()}")
  }
}

defaultTasks("printMd5")
