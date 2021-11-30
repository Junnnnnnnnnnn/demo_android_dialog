package com.yotdark.example_dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val button1: Button by lazy {
        findViewById(R.id.button1)
    }

    private val button2: Button by lazy {
        findViewById(R.id.button2)
    }

    private val button3: Button by lazy {
        findViewById(R.id.button3)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            initDialog()
        }
        button2.setOnClickListener {
            initCustomDialog()
        }
        button3.setOnClickListener {
            initBottomDialog()
        }
    }

    private fun initDialog(){
        val dialog = AlertDialog.Builder(this@MainActivity)
            dialog.setTitle("알림!")
            dialog.setMessage("알람창 기본입니다~")
            dialog.setPositiveButton("확인") { popup, _ ->
                Toast.makeText(this@MainActivity, "확인되었습니다", Toast.LENGTH_SHORT).show()
                popup.dismiss()
            }
            dialog.setNegativeButton("취소"){ popup, _ ->
                Toast.makeText(this@MainActivity, "취소되었습니다", Toast.LENGTH_SHORT).show()
                popup.dismiss()
            }

            dialog.show()
    }

    private fun initCustomDialog(){
        ModuleDialog(this@MainActivity, R.layout.dialog_layout).apply {
            setDefaultDialog()
            setCancelButton(true)
            setSlideBottomToTop(R.style.animation_dialog)
            setTitle("경고!")
            setMessage("당신은 탈모 빔을 맞았습니다.\n" +
                       "지금 바로 자라나라 머리머리를 말하지 않는다면 탈모가 걸릴 것입니다")
            setPositive {
                Toast.makeText(this@MainActivity, "자라나라 머리머리!!!!", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            setNegative {
                Toast.makeText(this@MainActivity, "그냥 탈모로 살래...", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            show()
        }
    }

    private fun initBottomDialog(){
        ModuleDialog(this@MainActivity, R.layout.dialog_bottom).apply {
            setBottomDialog()
            setSlideBottomToTop(R.style.animation_dialog)
            setTitle("경고!")
            setMessage("당신은 탈모 빔을 맞았습니다.\n지금 바로 자라나라 머리머리를 말하지 않는다면 탈모가 걸릴 것입니다")
            setPositive {
                Toast.makeText(this@MainActivity, "자라나라 머리머리!!!!", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            setNegative {
                Toast.makeText(this@MainActivity, "그냥 탈모로 살래...", Toast.LENGTH_SHORT).show()
                dismiss()
            }
            show()
        }
    }
}