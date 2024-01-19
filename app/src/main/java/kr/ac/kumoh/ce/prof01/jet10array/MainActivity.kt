package kr.ac.kumoh.ce.prof01.jet10array

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import kr.ac.kumoh.ce.prof01.jet10array.ui.theme.Jet10ArrayTheme

class MainActivity : ComponentActivity() {
    private val viewModel: LottoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.generate()

        for (i in viewModel.numbers.indices)
            Log.i("onCreate()", "Lotto ${viewModel.numbers[i]}")

        setContent {
            Jet10ArrayTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        if (LocalConfiguration.current.orientation
                == Configuration.ORIENTATION_LANDSCAPE)
            LottoLandscape()
        else
            LottoPortrait()
    }
}

@Composable
fun LottoLandscape(viewModel: LottoViewModel = viewModel()) {
    Row(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color(0xFFFBEAFF)),
    ) {
        Text(
            viewModel.numbers[0].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
        Text(
            viewModel.numbers[1].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
        Text(
            viewModel.numbers[2].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
        Text(
            viewModel.numbers[3].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
        Text(
            viewModel.numbers[4].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
        Text(
            viewModel.numbers[5].toString(),
            Modifier
                .weight(1F)
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFF845EC2))
                .wrapContentSize(),
            fontSize = 50.sp,
            color = Color(0xFFFBEAFF),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun LottoPortrait() {

}