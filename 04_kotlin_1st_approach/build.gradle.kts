tasks.register("printMd5") {
  doLast {
    val inputFile = file("../jug_nsk_logo.jpg")
    ant.withGroovyBuilder {
      "checksum"("file" to inputFile, "property" to "output_md5")
    }
    val outputMd5 = ant.properties["output_md5"]
    println("The checksum of $inputFile is $outputMd5")
  }
}

defaultTasks("printMd5")
