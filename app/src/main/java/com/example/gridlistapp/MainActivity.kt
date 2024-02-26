package com.example.gridlistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
import com.example.gridlistapp.data.DataSource
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
                    CourseGridApp(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}

@Composable
fun CourseGridApp(modifier: Modifier = Modifier) {
    CourseGridList(DataSource().loadCourses(), modifier = modifier)
}


@Composable
fun CourseCard(courseItemModel: CourseItemModel, modifier: Modifier = Modifier) {
    Card() {
        Row {
            Image(
                painter = painterResource(id = courseItemModel.imageResourceId),
                contentDescription = stringResource(id = courseItemModel.nameResourceId),
                modifier = modifier
                    .height(68.dp)
                    .width(68.dp)
                    .aspectRatio(1f),
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
fun CourseGridList(loadCourses: List<CourseItemModel>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(loadCourses) { course ->
            CourseCard(course)
        }
    }
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