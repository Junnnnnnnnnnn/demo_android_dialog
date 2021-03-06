# ๐[Android] Dialog demo

## โ๏ธ Study

## ๐ Setting

- CompileSdk = 30
- Minsdk = 24
- TargetSdk = 30

## ๐คจ Why

- `Toast`, `SnackBar` ๋ก ํํ ํ๊ธฐ ํ๋  ๊ฒ๋ค์ `Dialog`๋ฅผ ํตํด์ ์ฒ๋ฆฌ ํ๊ธฐ ์ํด ์ฌ์ฉ

## ๐ Try 

- ๊ธฐ๋ณธ `AlertDialog` ์ค์ 
- ์ปค์คํ `Dialog` ์ค์ 
- ํ๋จ ๊ณ ์  `Dialog` ์ค์ 

## โ๏ธ ๊ธฐ๋ณธ Dialog ์ค์ 

### โ๏ธ AlertDialog ์ฌ์ฉํด ๊ธฐ๋ณธ Dialog ์ค์  ํด๋ณด๊ธฐ

> MainActivity.kt

```kotlin
private fun initDialog(){
    val dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("์๋ฆผ!")
        dialog.setMessage("์๋์ฐฝ ๊ธฐ๋ณธ์๋๋ค~")
        dialog.setPositiveButton("ํ์ธ") { popup, _ ->
            Toast.makeText(this@MainActivity, "ํ์ธ๋์์ต๋๋ค", Toast.LENGTH_SHORT).show()
            popup.dismiss()
        }
        dialog.setNegativeButton("์ทจ์"){ popup, _ ->
            Toast.makeText(this@MainActivity, "์ทจ์๋์์ต๋๋ค", Toast.LENGTH_SHORT).show()
            popup.dismiss()
        }
        dialog.show()
}
```

![แแณแแณแแตแซแแฃแบ 2021-11-30 แแฉแแฎ 5 04 10](https://user-images.githubusercontent.com/39250642/144015913-ad7ff0ba-f613-4128-998f-1bc3fd4b0ea7.png)


## โ๏ธ ์ปค์คํ Dialog ์ค์ 

### โ๏ธ ์ปค์คํ Dialog layout ๊ตฌ์ฑ ํ๊ธฐ

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
        android:text="์ ๋ชฉ"
        app:layout_constraintBottom_toTopOf="@+id/dialog_description"
        app:layout_constraintTop_toBottomOf="@+id/dialog_header"
        app:layout_constraintStart_toStartOf="parent"/>

    <TextView
        android:id="@+id/dialog_description"
        style="@style/text_description_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="์ค๋ช"
        app:layout_constraintBottom_toTopOf="@+id/dialog_footer_confirm"
        app:layout_constraintEnd_toEndOf="@+id/dialog_guide"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/dialog_title" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_cencel"
        style="@style/cancel_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="์ทจ์"
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
        android:text="ํ์ธ"
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

![แแณแแณแแตแซแแฃแบ 2021-11-30 แแฉแแฎ 5 04 51](https://user-images.githubusercontent.com/39250642/144016015-5528d9f7-1954-435a-bae3-193de3fa43cd.png)


### โ๏ธ Dialog class ๋ง๋ค์ด ๋ณด๊ธฐ

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

### โ๏ธ ์๋์์ ์ค๊ฐ์ผ๋ก ์ฌ๋ผ์ค๋ ์ฌ๋ผ์ด๋ ์ ๋๋งค๋์ ๊ตฌํ ํด ๋ณด๊ธฐ

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

## โ๏ธ ํ๋จ ๊ณ ์  Dialog ์ค์ 

### โ๏ธ layout ์ค์ 

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
        android:text="์ ๋ชฉ"
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
        android:text="์์ธ๋ด์ฉ"
        app:layout_constraintStart_toStartOf="@id/dialog_title"
        app:layout_constraintTop_toBottomOf="@id/dialog_title"
        tools:ignore="RtlSymmetry" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_cencel"
        style="@style/cancel_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="์ทจ์"
        app:layout_constraintBottom_toBottomOf="@id/guideline_horizontal"
        app:layout_constraintStart_toStartOf="parent" />

    <androidx.appcompat.widget.AppCompatButton
        android:id="@+id/dialog_footer_confirm"
        style="@style/submit_button_dialog"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:text="ํ์ธ"
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

![แแณแแณแแตแซแแฃแบ 2021-11-30 แแฉแแฎ 5 04 59](https://user-images.githubusercontent.com/39250642/144016052-eec8196f-c588-4503-aa10-4aa2122e745c.png)


### โ๏ธ ํ๋จ ๊ณ ์  ๋ ์ด์์ ์ค์  ํ๊ธฐ

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

## โ๏ธMainActivity ์์ ์ ์ฉ ํด๋ณด๊ธฐ

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
            dialog.setTitle("์๋ฆผ!")
            dialog.setMessage("์๋์ฐฝ ๊ธฐ๋ณธ์๋๋ค~")
            dialog.setPositiveButton("ํ์ธ") { popup, _ ->
                Toast.makeText(this@MainActivity, "ํ์ธ๋์์ต๋๋ค", Toast.LENGTH_SHORT).show()
                popup.dismiss()
            }
            dialog.setNegativeButton("์ทจ์"){ popup, _ ->
                Toast.makeText(this@MainActivity, "์ทจ์๋์์ต๋๋ค", Toast.LENGTH_SHORT).show()
                popup.dismiss()
            }
        
            dialog.show()
    }

    private fun initCustomDialog(){
        ModuleDialog(this@MainActivity, R.layout.dialog_layout).apply {
            setDefaultDialog()
            setCancelButton(true)
            setSlideBottomToTop(R.style.animation_dialog)
            setTitle("๊ฒฝ๊ณ !")
          	setMessage("๋น์ ์ ํ๋ชจ ๋น์ ๋ง์์ต๋๋ค.\n" +
                       "์ง๊ธ ๋ฐ๋ก ์๋ผ๋๋ผ ๋จธ๋ฆฌ๋จธ๋ฆฌ๋ฅผ ๋งํ์ง ์๋๋ค๋ฉด ํ๋ชจ๊ฐ ๊ฑธ๋ฆด ๊ฒ์๋๋ค")

            setPositive {
                Toast.makeText(
                  this@MainActivity,
                  "์๋ผ๋๋ผ ๋จธ๋ฆฌ๋จธ๋ฆฌ!!!!",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            setNegative {
                Toast.makeText(
                  this@MainActivity,
                  "๊ทธ๋ฅ ํ๋ชจ๋ก ์ด๋...",
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
            setTitle("๊ฒฝ๊ณ !")
          	setMessage("๋น์ ์ ํ๋ชจ ๋น์ ๋ง์์ต๋๋ค.\n" +
                       "์ง๊ธ ๋ฐ๋ก ์๋ผ๋๋ผ ๋จธ๋ฆฌ๋จธ๋ฆฌ๋ฅผ ๋งํ์ง ์๋๋ค๋ฉด ํ๋ชจ๊ฐ ๊ฑธ๋ฆด ๊ฒ์๋๋ค")
						setPositive {
                Toast.makeText(
                  this@MainActivity,
                  "์๋ผ๋๋ผ ๋จธ๋ฆฌ๋จธ๋ฆฌ!!!!",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            setNegative {
                Toast.makeText(
                  this@MainActivity,
                  "๊ทธ๋ฅ ํ๋ชจ๋ก ์ด๋...",
                  Toast.LENGTH_SHORT
                ).show()
                
              dismiss()
            }
            show()
        }
    }
}
```





