package com.example.gridlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridlistapp.model.CourseItemModel
import com.example.gridlistapp.ui.theme.GridListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridListAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CourseGridApp("Android")
                }
            }
        }
    }
}

@Composable
fun CourseGridApp(name: String, modifier: Modifier = Modifier) {

    //TODO: CourseGridList()
    CourseCard(CourseItemModel(R.drawable.photography, R.string.photography, 100))
}


@Composable
fun CourseCard(courseItemModel: CourseItemModel, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Row {
            Image(
                painter = painterResource(id = courseItemModel.imageResourceId),
                contentDescription = stringResource(id = courseItemModel.nameResourceId),
                modifier = Modifier
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.height(68.dp)
            ) {
                Text(
                    text = stringResource(id = courseItemModel.nameResourceId),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 8.dp)
                )
                Row(
                    modifier = Modifier.padding(start = 16.dp, bottom = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null
                    )
                    Text(
                        text = courseItemModel.numberOfCourses.toString(),
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                            .padding(start = 8.dp),
                    )
                }
            }
        }
    }
}


@Composable
fun CourseGridList() {

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    GridListAppTheme {
        CourseCard(CourseItemModel(R.drawable.photography, R.string.photography, 100))
    }
}