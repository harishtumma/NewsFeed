package com.example.newsfeed.presenter.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
 fun showAlert(alertDialogState: AlertDialogState?, onPrimary: () -> Unit, onDismiss: () -> Unit = {}) {

    var showDialog by remember { mutableStateOf(alertDialogState != null) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },

            title = {
                Text(text = alertDialogState?.title?:"")
            },

            text = {
                Text(alertDialogState?.description?:"")
            },

            confirmButton = {
                alertDialogState?.positiveButton?.let {
                    TextButton(onClick = {
                        // handle confirm
                        onPrimary()
                        showDialog = false
                    }) {
                        Text(it)
                    }
                }

            },

            dismissButton = {
                alertDialogState?.negativeButton?.let {
                    TextButton(onClick = {
                        onDismiss()
                        showDialog = false
                    }) {
                        Text(it)
                    }
                }
            }
        )
    }
}