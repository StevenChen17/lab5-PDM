package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.lab5.data.AppDatabase
import com.example.lab5.data.TaskRepository
import com.example.lab5.navigation.AppNavGraph
import com.example.lab5.ui.theme.Lab5Theme
import com.example.lab5.viewModel.GeneralViewModel
import com.example.lab5.viewModel.GeneralViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                val navController = rememberNavController()
                val db = AppDatabase.getDatabase(applicationContext)
                val repository = TaskRepository(db.taskDao())
                val generalViewModel: GeneralViewModel = viewModel(
                    factory = GeneralViewModelFactory(repository)
                )

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(
                        navController = navController,
                        generalViewModel = generalViewModel
                    )
                }
            }
        }
    }
}

