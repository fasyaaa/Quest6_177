package com.example.mvvmpt2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmpt2.ui.view.screen.DetailView
import com.example.mvvmpt2.ui.view.screen.MahasiswaFormView
import com.example.mvvmpt2.ui.view.screen.RencanaStudiView
import com.example.mvvmpt2.ui.view.screen.SplashView
import com.example.mvvmpt2.ui.view.viewmodel.MahasiswaViewModel
import com.example.mvvmpt2.ui.view.viewmodel.RencanaStudyViewModel


enum class halaman{
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun PengelolaHalaman(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val krsUiState = krsViewModel.krsStateUi.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = halaman.Splash.name){
            SplashView (onMulaiButton =  {
                navController.navigate(
                    halaman.Mahasiswa.name
                )
            })
        }
        composable(route = halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()}
            )
        }
        composable(route = halaman.Matakuliah.name){
            RencanaStudiView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                    krsViewModel.saveDataKRS(it)
                    navController.navigate(halaman.Tampil.name) },
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(route = halaman.Tampil.name){
            DetailView(
                dataMhs = mahasiswaUiState,
                dataMhs2 = krsUiState,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}