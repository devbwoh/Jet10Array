package kr.ac.kumoh.ce.prof01.jet10array

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
//    private val viewModel: LottoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel.generate()
//
//        for (i in viewModel.numbers.indices)
//            Log.i("onCreate()", "Lotto ${viewModel.numbers[i]}")

        setContent {
            Jet10ArrayTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val viewModel: LottoViewModel = viewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Button(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                onClick = { viewModel.generate() }
            ) {
                Text(text = "번호 생성", fontSize = 20.sp)
            }

            if (LocalConfiguration.current.orientation
                == Configuration.ORIENTATION_LANDSCAPE)
                LottoLandscape()
            else
                LottoPortrait()
        }
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
        viewModel.numbers.map {
            Text(
                it.toString(),
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
}

@Composable
fun RowScope.TextNumber(number: Int) {
    Text(
        text = number.toString(),
        modifier = Modifier
            .weight(1F)
            .fillMaxSize()
            .background(Color(0xFF845EC2))
            .padding(8.dp)
            .wrapContentSize(),
        fontSize = 50.sp,
        color = Color(0xFFFEFEDF),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun LottoPortrait(viewModel: LottoViewModel = viewModel()) {
    Row {
        val textNumbers: List<@Composable () -> Unit> =
            viewModel.numbers.map {
                { TextNumber(number = it) }
            }

        Column(
            Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color(0xFFFEF7FF))
        ) {
            Row(
                Modifier
                    .weight(1F)
                    .padding(8.dp)) {
                textNumbers[0]()
                Spacer(modifier = Modifier.size(16.dp))
                textNumbers[1]()
            }
            Row(
                Modifier
                    .weight(1F)
                    .padding(8.dp)) {
                textNumbers[2]()
                Spacer(modifier = Modifier.size(16.dp))
                textNumbers[3]()
            }
            Row(
                Modifier
                    .weight(1F)
                    .padding(8.dp)) {
                textNumbers[4]()
                Spacer(modifier = Modifier.size(16.dp))
                textNumbers[5]()
            }
        }
    }
}