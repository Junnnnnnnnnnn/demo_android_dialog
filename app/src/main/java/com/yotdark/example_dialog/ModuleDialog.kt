package com.yotdark.example_dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.LayoutRes

class ModuleDialog(private val context: Context, @LayoutRes private val res: Int) {

    private val dialog by lazy {
        Dialog(context)
    }

    private val window by lazy {
        dialog.window
    }

    init {
        dialog.setContentView(res)
        dialog.setCancelable(false)
    }

    fun setDefaultDialog(){
        dialog.findViewById<Button>(R.id.dialog_footer_confirm).setOnClickListener {
            dismiss()
        }
    }

    fun setBottomDialog(){
        window?.apply {
            setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            setGravity(Gravity.BOTTOM)
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    fun setSlideBottomToTop(res: Int){
        window?.attributes?.windowAnimations = res
    }

    fun setTitle(title: String){
        dialog.findViewById<TextView>(R.id.dialog_title).text = title
    }

    fun setMessage(message: String){
        dialog.findViewById<TextView>(R.id.dialog_description).text = message
    }

    fun setPositive(listener: View.OnClickListener){
        dialog.findViewById<Button>(R.id.dialog_footer_confirm).setOnClickListener(listener)
    }

    fun setNegative(listener: View.OnClickListener){
        dialog.findViewById<Button>(R.id.dialog_footer_cencel).setOnClickListener(listener)
    }

    fun setCancelButton(condition: Boolean){
        if(condition){
            dialog.findViewById<Button>(R.id.dialog_footer_cencel).visibility = View.VISIBLE
            return
        }
        dialog.findViewById<Button>(R.id.dialog_footer_cencel).visibility = View.GONE
    }

    fun dismiss(){
        dialog.dismiss()
    }

    fun show() = dialog.show()


}