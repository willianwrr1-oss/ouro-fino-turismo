package com.willian.ourofino

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.willian.ourofino.ui.OuroFinoApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OuroFinoApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    OuroFinoApp()
}
