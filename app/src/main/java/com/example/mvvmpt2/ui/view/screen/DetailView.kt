package com.example.mvvmpt2.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        listDataMahasiswa.forEach{data ->
            DetailVw(judul = data.first,
                Isinya = data.second)
        }
        ElevatedButton(
            onClick = onBackClick ,modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Back")
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