@file:Suppress("NonAsciiCharacters")

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.io.File
import java.io.FileNotFoundException

class Md5Test {

    /*
     * # echo 'А роза упала на лапу Азора' | md5sum
     * 51c823bdae6be9c036977958e417bd36  -
     */
    private val from = "А роза упала на лапу Азора"
    private val result = "51c823bdae6be9c036977958e417bd36"

    @Test
    fun `функция md5 работает и результат её выполения совпадает с эталонным значением`() {
        val content: ByteArray = (from + "\n").toByteArray()
        val actual = content.md5()
        assertEquals(result, actual)
    }

    @Test
    fun `успешно читаем из dev null`() = assertEquals("d41d8cd98f00b204e9800998ecf8427e", File("/dev/null").md5())

    @Test
    fun `ошибка "Отказано в доступе" при попытке чтения из etc shadow`() {
        assertThrows(FileNotFoundException::class.java) {
            File("/etc/shadow").md5()
        }
    }

    @Test
    fun `ошибка "Нет такого файла или каталога" при попытке чтения из несуществующего файла`() {
        assertThrows(FileNotFoundException::class.java) {
            File("фыоварлор23").md5()
        }
    }


}