# 🏃[Android] Dialog demo

## ✏️ Study

## 🌍 Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## 🤨 Why

- `Toast`, `SnackBar` 로 표현 하기 힘든 것들을 `Dialog`를 통해서 처리 하기 위해 사용

## 🙋 Try 

- 기본 `AlertDialog` 설정
- 커스텀 `Dialog` 설정
- 하단 고정 `Dialog` 설정

## ✏️ 기본 Dialog 설정

### ✏️ AlertDialog 사용해 기본 Dialog 설정 해보기

> MainActivity.kt

```kotlin
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
```

![스크린샷 2021-11-30 오후 5 04 10](https://user-images.githubusercontent.com/39250642/144015913-ad7ff0ba-f613-4128-998f-1bc3fd4b0ea7.png)


## ✏️ 커스텀 Dialog 설정

### ✏️ 커스텀 Dialog layout 구성 하기

> dialog_layout.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:id="@+id/dialog_header"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:background="#eb5757"
        app:layout_constraintBottom_toTopOf="@+id/dialog_title"
        app:layout_constraintEnd_toStartOf="@+id/dialog_guide"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_chainStyle="packed">

        <ImageView
            android:id="@+id/dialog_icon"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:src="@drawable/dialog_status_error_70"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <ImageView
            android:id="@+id/dialog_plus_1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/dialog_status_plus_15"
            app:layout_constraintBottom_toBottomOf="@+id/dialog_icon"
            app:layout_constraintEnd_toStartOf="@+id/dialog_icon"
            app:layout_constraintHorizontal_bias="0.9"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/dialog_icon"
            app:layout_constraintVertical_bias="0.2" />

        <ImageView
            android:id="@+id/dialog_plus_2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/dialog_status_plus_15"
            app:layout_constraintBottom_toBottomOf="@+id/dialog_icon"
            app:layout_constraintEnd_toStartOf="@+id/dialog_icon"
            app:layout_constraintHorizontal_bias="1"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="@+id/dialog_icon"
            app:layout_constraintVertical_bias="0.8" />

        <ImageView
            android:id="@+id/dialog_plus_3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/dialog_status_plus_15"
            app:layout_constraintBottom_toBottomOf="@+id/dialog_icon"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0"
            app:layout_constraintStart_toEndOf="@+id/dialog_icon"
            app:layout_constraintTop_toTopOf="@+id/dialog_icon"
            app:layout_constraintVertical_bias="0.3" />
    </androidx.constraintlayout.widget.ConstraintLayout>

    <TextView
        android:id="@+id/dialog_title"
        style="@style/text_title_dialog"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="제목"
        app:layout_constraintBottom_toTopOf="@+id/dialog_description"
        app:layout_constraintTop_toBottomOf="@+id/dialog_header"
        app:layout_constraintStart_toStartOf="parent"/>

    <TextView
        android:id="@+id/dialog_description"
        style="@style/text_description_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="설명"
        app:layout_constraintBottom_toTopOf="@+id/dialog_footer_confirm"
        app:layout_constraintEnd_toEndOf="@+id/dialog_guide"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/dialog_title" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_cencel"
        style="@style/cancel_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="취소"
        android:visibility="gone"
        app:layout_constraintEnd_toStartOf="@+id/dialog_footer_confirm"
        app:layout_constraintHorizontal_weight="1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/dialog_description"
        tools:visibility="visible" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_confirm"
        style="@style/submit_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="확인"
        app:layout_constraintEnd_toEndOf="@+id/dialog_guide"
        app:layout_constraintHorizontal_weight="2"
        app:layout_constraintStart_toEndOf="@+id/dialog_footer_cencel"
        app:layout_constraintTop_toBottomOf="@+id/dialog_description" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/dialog_guide"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        app:layout_constraintGuide_begin="300dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

![스크린샷 2021-11-30 오후 5 04 51](https://user-images.githubusercontent.com/39250642/144016015-5528d9f7-1954-435a-bae3-193de3fa43cd.png)


### ✏️ Dialog class 만들어 보기

> ModuleDialog.kt

```kotlin
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
```

### ✏️ 아래에서 중간으로 올라오는 슬라이드 애니매니션 구현 해 보기

```kotlin
package com.yotdark.example_dialog

class ModuleDialog(private val context: Context, @LayoutRes private val res: Int) {
						.
						.
						.
    private val dialog by lazy {
        Dialog(context)
    }

    private val window by lazy {
        dialog.window
    }

    fun setSlideBottomToTop(res: Int){
        window?.attributes?.windowAnimations = res
    }
    				.
    				.
    				.
}
```

## ✏️ 하단 고정 Dialog 설정

### ✏️ layout 설정

> dialog_button.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/dialog_slide_background">

    <TextView
        android:id="@+id/dialog_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="30dp"
        android:text="제목"
        android:textSize="30sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@id/dialog_description"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:paddingTop="10dp"
        android:paddingEnd="60dp"
        android:paddingBottom="30dp"
        android:text="상세내용"
        app:layout_constraintStart_toStartOf="@id/dialog_title"
        app:layout_constraintTop_toBottomOf="@id/dialog_title"
        tools:ignore="RtlSymmetry" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_cencel"
        style="@style/cancel_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="취소"
        app:layout_constraintBottom_toBottomOf="@id/guideline_horizontal"
        app:layout_constraintStart_toStartOf="parent" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_confirm"
        style="@style/submit_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="확인"
        app:layout_constraintBottom_toBottomOf="@id/guideline_horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@id/dialog_footer_cencel" />

    <androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline_horizontal"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_begin="300dp" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

![스크린샷 2021-11-30 오후 5 04 59](https://user-images.githubusercontent.com/39250642/144016052-eec8196f-c588-4503-aa10-4aa2122e745c.png)


### ✏️ 하단 고정 레이아웃 설정 하기

```kotlin
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
							.
  						.
  						.

}
```

## ✏️MainActivity 에서 적용 해보기

> MainActivity.kt

```kotlin
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
                Toast.makeText(
                  this@MainActivity,
                  "자라나라 머리머리!!!!",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            setNegative {
                Toast.makeText(
                  this@MainActivity,
                  "그냥 탈모로 살래...",
                  Toast.LENGTH_SHORT
                ).show()
                
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
          	setMessage("당신은 탈모 빔을 맞았습니다.\n" +
                       "지금 바로 자라나라 머리머리를 말하지 않는다면 탈모가 걸릴 것입니다")
						setPositive {
                Toast.makeText(
                  this@MainActivity,
                  "자라나라 머리머리!!!!",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            setNegative {
                Toast.makeText(
                  this@MainActivity,
                  "그냥 탈모로 살래...",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            show()
        }
    }
}
```





