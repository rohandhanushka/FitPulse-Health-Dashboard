package com.example.fitpulse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFF8F9FA)) {
                    FitnessDashboard()
                }
            }
        }
    }
}

@Composable
fun FitnessDashboard() {
    Column(modifier = Modifier.padding(20.dp)) {
        Text(text = "Good Morning! \uD83D\uDC4B", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(text = "Let's crush your goals today.", color = Color.Gray, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(30.dp))

        // Stats Row
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            StatCard(
                title = "Steps",
                value = "6,540",
                color = Color(0xFF4CAF50),
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatCard(
                title = "Calories",
                value = "320 kcal",
                color = Color(0xFFFF9800),
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Recent Activity Section
        Text(text = "Recent Activity", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        ActivityCard(title = "Morning Run", duration = "30 mins", distance = "3.2 km")
        Spacer(modifier = Modifier.height(12.dp))
        ActivityCard(title = "Yoga Session", duration = "45 mins", distance = "-")
    }
}

@Composable
fun StatCard(title: String, value: String, color: Color, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.1f)),
        modifier = modifier
            .fillMaxWidth()
            .height(110.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = color)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = title, fontSize = 14.sp, color = Color.DarkGray)
        }
    }
}

@Composable
fun ActivityCard(title: String, duration: String, distance: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = duration, fontSize = 14.sp, color = Color.Gray)
            }
            if (distance != "-") {
                Text(text = distance, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2196F3))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFitnessDashboard() {
    MaterialTheme {
        FitnessDashboard()
    }
}