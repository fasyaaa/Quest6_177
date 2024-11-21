package com.example.mvvmpt2.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvmpt2.R
import com.example.mvvmpt2.model.Mahasiswa
import com.example.mvvmpt2.model.RencanaStudi

@Composable
fun DetailView(
    modifier: Modifier = Modifier,
    dataMhs: Mahasiswa,
    dataMhs2: RencanaStudi,
    onBackClick: () -> Unit
){
    val listDataMahasiswa= listOf(
        Pair("NIM", dataMhs.nim),
        Pair("Nama", dataMhs.nama),
        Pair("Email", dataMhs.email),
        Pair("Mata Kuliah", dataMhs2.mataKuliah),
        Pair("Kelas", dataMhs2.kelas)
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(
                    id = R.color.primary
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ){
            Image(
                painter = painterResource(
                    id = R.drawable.logo
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(45.dp).clip(CircleShape)
            )
            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.Red,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Unggul dan Islami",
                    color = Color.Red,
                    fontWeight = FontWeight.Light
                )
            }
            Box{
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
//                        untuk mengatur shape pada bagian bagian tertentu
                        topEnd = 15.dp,
                        topStart = 15.dp
                    )
                )
                .fillMaxSize(),
        )
        {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                listDataMahasiswa.forEach { data ->
                    DetailVw(
                        judul = data.first,
                        Isinya = data.second
                    )
                }
                ElevatedButton(
                    onClick = onBackClick, modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Back")
                }
            }
        }
    }
}

@Composable
// untuk memanggil di elevated card
fun DetailVw(
    judul: String, Isinya: String
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        Text(text = judul,
            modifier = Modifier.weight(0.8f))
        Text(text = " : ",
            modifier = Modifier.weight(0.2f))
        Text(text = Isinya,
            modifier = Modifier.weight(2f))
    }
}