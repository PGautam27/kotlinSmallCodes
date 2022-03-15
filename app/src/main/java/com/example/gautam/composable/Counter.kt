package com.example.gautam.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.*
import androidx.compose.ui.tooling.preview.Preview

val x =20
@Composable
fun CountIndicatorCircle(
   score : score
) {
    val animationProgress by animateFloatAsState(
        targetValue = score.value.toFloat()/100.0F,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

        Box{
            CircularProgressIndicatorBackGround(
                modifier = Modifier
                    .height(280.dp)
                    .width(280.dp),
                color = score.color
            )
            CircularProgressIndicator(
                progress = animationProgress,
                modifier = Modifier
                    .height(280.dp)
                    .width(280.dp),
                color = score.textColor,
                strokeWidth = 16.dp,
            )
            Column(modifier = Modifier
                .align(Alignment.Center)
                .padding(start = 10.dp)) {
                Text(
                    text = "${score.value}%",
                    color = Color.Black,
                    fontFamily = FontFamily.Default,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Readiness Score",
                    color = Color.Gray,
                    fontFamily = FontFamily.Default,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .background(score.color)){
                    Text(
                        text = "${score.status}",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp, bottom = 4.dp, top = 4.dp),
                        color = score.textColor
                    )
                }
            }
        }
}
@Composable
fun CircularProgressIndicatorBackGround(
    modifier: Modifier = Modifier,
    color: Color
) {
    val style = with(LocalDensity.current) { Stroke(16.dp.toPx()) }

    Canvas(
        modifier = modifier,
        onDraw = {

            val innerRadius = (size.minDimension - style.width) / 2

            drawArc(
                color = color,
                startAngle = 0f,
                sweepAngle = 360f,
                topLeft = Offset(
                    (size / 2.0f).width - innerRadius,
                    (size / 2.0f).height - innerRadius
                ),
                size = Size(innerRadius * 2, innerRadius * 2),
                useCenter = false,
                style = style
            )
        }
    )
}

@Preview
@Composable
fun cou() {
 CountIndicatorCircle(score = score(10))   
}