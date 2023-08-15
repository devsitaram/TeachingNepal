package com.edu.teachingnepal.features.util.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.edu.teachingnepal.R
import com.edu.teachingnepal.ui.theme.Purple80

/**
 * this is the sample of normal dialog box
 * this dialog box can required for
 * @param title
 * @param text
 * @param onDismiss function
 */
@Composable
fun SampleDialogBox(title: String, text: String, onDismiss: () -> Unit) {
//    val activity = (LocalContext.current as Activity)
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(text = title) },
        text = { Text(text = text) },
        modifier = Modifier.fillMaxWidth(),
        dismissButton = {
            TextButton(
                onClick = { onDismiss() }
            ) {
                Text(text = "Dismiss")
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onDismiss() } // activity.finish()
            ) {
                Text(text = "Confirm")
            }
        }
    )
}

/**
 * this dialog box can required for
 * @param title
 * @param text
 * @param onDismiss function
 */
@Composable
fun ButtonDialogBox(title: String, text: String, onDismiss: () -> Unit = {}) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = {
            TextView(
                text = title,
                style = TextStyle(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        text = { Text(text = text) },
        modifier = Modifier.fillMaxWidth(),
        shape = ShapeDefaults.ExtraSmall,
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier,
                    onClick = { onDismiss() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.purple_500)
                    )
                ) {
                    TextView(text = "Okay", style = TextStyle(), modifier = Modifier)
                }
            }
        }
    )
}