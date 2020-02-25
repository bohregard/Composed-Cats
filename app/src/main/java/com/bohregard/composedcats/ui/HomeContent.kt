package com.bohregard.composedcats.ui

import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.AdapterList
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.bohregard.composedcats.model.CatObject
import com.bohregard.composedcats.model.Screen
import com.bohregard.composedcats.model.Status
import com.bohregard.composedcats.model.navigateTo
import com.koduok.compose.glideimage.GlideImage

@Composable
fun HomeContent(catObjects: List<CatObject>) {
    AdapterList(data = catObjects) {
        listItem(it)
    }
}

@Composable
fun listItem(catObject: CatObject) {
    val url = "https://cataas.com/c/s/${catObject.index}"
    val typography = MaterialTheme.typography()
    Row(modifier = LayoutPadding(16.dp)) {
        Column {
            Text(text = "Cat ${catObject.index}", style = typography.h4)
            Button(modifier = LayoutPadding(4.dp), onClick = { catObject.count++ }) {
                Text("Clicked ${catObject.count} times")
            }
            Button(modifier = LayoutPadding(4.dp), onClick = {
                Status.currentCat = catObject.index
                navigateTo(Screen.CatScreen(catObject.index))
            }) {
                Text("Go to this cat")
            }
        }
        Container(modifier = LayoutWidth.Fill) {
            Clip(shape = RoundedCornerShape(10.dp)) {
                GlideImage(url)
            }
        }
    }
}

@Preview
@Composable
fun listItemPreview() {
    listItem(CatObject())
}