package com.example.foodai.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FA)) // Light Gray background
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- Header Section ---
        Spacer(modifier = Modifier.height(30.dp))

        // Profile Icon with Material3 Surface
        Surface(
            modifier = Modifier.size(90.dp),
            shape = CircleShape,
            color = Color(0xFF1A73E8) // Hex: Primary Blue
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Jane Doe",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF202124)
        )
        Text(
            text = "jane.doe@newsmail.com",
            fontSize = 14.sp,
            color = Color.Gray
        )

        // --- Bio Card ---
        Card(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F0FE)), // Light blue tint
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Passionate about global politics and tech trends. Reading news since 2015.",
                modifier = Modifier.padding(16.dp),
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = Color(0xFF1A73E8)
            )
        }

        // --- Features List ---
        ProfileOption(label = "Edit Profile", icon = Icons.Default.Edit)
        ProfileOption(label = "View Saved News", icon = Icons.Default.Favorite)

        Spacer(modifier = Modifier.weight(1f))

        // --- Logout Button (M3 syntax) ---
        Button(
            onClick = { /* Action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)), // Hex: Alert Red
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Log Out", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun ProfileOption(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    // M3 Card for list items
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color(0xFF1A73E8))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = label, fontSize = 16.sp, color = Color(0xFF202124))
        }
    }
}


@Preview
@Composable
fun preview(){
    ProfileScreen()

}