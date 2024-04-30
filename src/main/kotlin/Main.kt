import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.sql.DriverManager
import java.sql.SQLException

@Composable
@Preview
fun App() {

    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() = application {
//    Window(onCloseRequest = ::exitApplication) {
//        App()
//    }

    val url = "jdbc:mysql://localhost:3306/studentdb"

    val user = "studentuser"
    val passw = "password"

    var texto = ""

    try {
        Class.forName("com.mysql.cj.jdbc.Driver")
        val conexion = DriverManager.getConnection(url,user,passw)
        texto = "Conexión exitosa"
    } catch (e: SQLException) {
        texto = "Error en la conexión: ${e.message}"
    } catch (e: ClassNotFoundException) {
        texto = "No se encontró el driver JDBC: ${e.message}"
    }

    println(texto)
}
