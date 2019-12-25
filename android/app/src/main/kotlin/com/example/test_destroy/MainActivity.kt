package com.example.test_destroy
import android.content.Context
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import android.view.MenuItem
import android.widget.Button
import android.widget.*
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.*
import io.flutter.embedding.engine.dart.DartExecutor.DartEntrypoint
import io.flutter.app.FlutterApplication
import io.flutter.plugins.GeneratedPluginRegistrant
class PrewarmFlutterApplication: FlutterApplication() {
    override fun onCreate() {
        super.onCreate()
        io.flutter.Log.setLogLevel( android.util.Log.VERBOSE)
    }
}
const val CACHE_ENGINE_ID = "cache"
fun prewarm(context: Context) {
    if(!FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
        val flutterEngine = FlutterEngine(context)
        GeneratedPluginRegistrant.registerWith(flutterEngine)
        flutterEngine.dartExecutor.executeDartEntrypoint(DartEntrypoint.createDefault())
        FlutterEngineCache.getInstance().put(CACHE_ENGINE_ID, flutterEngine)
        Toast.makeText(context, "The engine prepared!", Toast.LENGTH_SHORT)
    }
}

class MainActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(
                Button(this@MainActivity).apply {
                    text = "prewarm engine"
                    setOnClickListener {
                        if (FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
                            Toast.makeText(applicationContext, "Already prewarmed!", Toast.LENGTH_SHORT)
                        } else {
                            prewarm(applicationContext)
                        }
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
            addView(
                Button(this@MainActivity).apply {
                    text = "open flutter with prewarm engine"
                    setOnClickListener {
                        if (!FlutterEngineCache.getInstance().contains(CACHE_ENGINE_ID)) {
                            Toast.makeText(applicationContext, "Already destroyed!", Toast.LENGTH_SHORT)
                        } else {
                            startActivity(
                                FlutterActivity.withCachedEngine(CACHE_ENGINE_ID)
                                    .destroyEngineWithActivity(false)
                                    .build(applicationContext)
                            )
                        }
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
            
            addView(
                Button(this@MainActivity).apply {
                    text = "destroy prewarmed engine"
                    setOnClickListener {
                        FlutterEngineCache.getInstance().get(CACHE_ENGINE_ID)?.destroy()
                        FlutterEngineCache.getInstance().remove(CACHE_ENGINE_ID)
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
            
            addView(
                Button(this@MainActivity).apply {
                    text = "open flutter with new engine"
                    setOnClickListener {
                        startActivity(
                            FlutterActivity.withNewEngine()
                                .build(applicationContext)
                        )
                    }
                },
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
            )
        })
    }
}