import java.io.File
import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

/**
 * вычисляет md5-сумму содержимого файла
 *
 * файл должен существовать и быть доступным для чтения
 * иначе летит FileNotFoundException
 */
fun File.md5() = readBytes().md5()

internal fun ByteArray.md5(): String {
    val digest: ByteArray = MessageDigest
            .getInstance("MD5")
            .digest(this)
    // https://www.javacodemonk.com/md5-and-sha-256-in-java-kotlin-and-android-96ed9628
    return DatatypeConverter.printHexBinary(digest).toLowerCase()
}