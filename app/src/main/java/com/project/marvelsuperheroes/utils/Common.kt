package com.project.marvelsuperheroes.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.project.marvelsuperheroes.utils.PrivateConstants.PRIVATE_KEY
import com.project.marvelsuperheroes.utils.PrivateConstants.PUBLIC_KEY
import java.math.BigInteger
import java.security.MessageDigest

fun Long.toTimestampString(): String {
    return this.toString()
}

fun String.generateHash(): String {
    val toHash = this + PRIVATE_KEY + PUBLIC_KEY
    return toHash.md5()
}

private fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun showErrorDialog(message: String, context: Context) {
    AlertDialog.Builder(context)
        .setTitle("Error")
        .setMessage(message)
        .setPositiveButton("OK") { dialog, _ ->
            dialog.dismiss()
        }
        .show()
}