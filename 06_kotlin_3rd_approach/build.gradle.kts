import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * вычисляет md5-сумму содержимого файла
 *
 * файл должен существовать и быть доступным для чтения
 */
fun File.checksum(): String {
    val bytes: ByteArray = MessageDigest
            .getInstance("MD5")
            .digest(this.readBytes())
    // https://www.javacodemonk.com/md5-and-sha-256-in-java-kotlin-and-android-96ed9628
    return DatatypeConverter.printHexBinary(bytes).toUpperCase()
}

tasks.register("printMd5") {
    doLast {
        val inputFile = file("../jug_nsk_logo.jpg")
        println("The checksum of $inputFile is ${inputFile.checksum()}")
    }
}

defaultTasks("printMd5")
