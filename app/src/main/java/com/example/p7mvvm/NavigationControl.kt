package com.example.p7mvvm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p7mvvm.viewmodel.SiswaViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.p7mvvm.model.JenisKel.JenisJk
import com.example.p7mvvm.ui.view.FormulirView
import com.example.p7mvvm.ui.view.TampilDataView

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl (
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()
){
    val uistate by viewModel.statusUI.collectAsState()
    NavHost(navController = navHost, startDestination = Halaman.FORMULIR.name){
        composable(
            route = Halaman.FORMULIR.name
        ){
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisJk.map { id ->
                    konteks.resources.getString(id)
                },
                onSubmitClicked = {
                    viewModel.SaveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                },
                modifier = modifier
            )
        }
        composable(
            route = Halaman.TAMPILDATA.name
        ){
            TampilDataView(
                uiState = uistate,
                onBackButton = {
                    navHost.popBackStack()
                },
                modifier = modifier
            )
        }
    }
}