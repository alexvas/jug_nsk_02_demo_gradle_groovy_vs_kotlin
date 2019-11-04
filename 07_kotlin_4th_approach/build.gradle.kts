
tasks.register("printMd5") {
  doLast {
    val inputFile = file("../jug_nsk_logo.jpg")
    println("The checksum of $inputFile is ${inputFile.md5()}")
  }
}

defaultTasks("printMd5")
