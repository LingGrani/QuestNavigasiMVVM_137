package com.example.p7mvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.p7mvvm.model.DataSiswa

@Composable
fun TampilDataView(
    modifier: Modifier = Modifier,
    uiState: DataSiswa,
    onBackButton: () -> Unit
) {
    Column (
        modifier = modifier.fillMaxSize().
        padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DetailMhs("Nama", uiState.nama)
        DetailMhs("Jenis Kelamin", uiState.jenisKelamin)
        DetailMhs("Email", uiState.email)
        DetailMhs("Alamat", uiState.alamat)
        DetailMhs("Nomor Telepon", uiState.noTelp)
        Button(onClick = onBackButton) {
            Text(text = "Kembali")
        }
    }
}

@Composable
fun DetailMhs(
    para:String, argu:String
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ){
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = para,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text= ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = argu,
                modifier = Modifier.weight(2f)
            )
        }
    }
}