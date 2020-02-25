package com.bohregard.composedcats.ui

import androidx.compose.Composable
import androidx.ui.core.Clip
import androidx.ui.core.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.LayoutPadding
import androidx.ui.layout.LayoutWidth
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.koduok.compose.glideimage.GlideImage

@Composable
fun CatContent(int: Int) {
    val url = "https://cataas.com/c/s/$int"
    Column(modifier = LayoutPadding(16.dp)) {
        Text("You've selected cat $int")
        Container(modifier = LayoutWidth.Fill) {
            Clip(shape = RoundedCornerShape(10.dp)) {
                GlideImage(url)
            }
        }
    }
}

@Preview
@Composable
fun CatContentPreview() {
    CatContent(int = 0)
}