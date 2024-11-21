package com.example.mvvmpt2.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
    NavHost(
        navController = navController,
        startDestination = halaman.Splash.name,
        modifier = Modifier.padding()
    ){
        composable(route = halaman.Splash.name){
            SplashView (onMulaiButton =  {
                navController.navigate(halaman.Mahasiswa.name)
            })
        }
    }
}