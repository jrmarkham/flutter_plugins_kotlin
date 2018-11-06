package com.example.pluginskotlin
import android.os.Bundle
import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import android.content.Intent
import android.net.Uri

class MainActivity(): FlutterActivity() {
  private val CHANNEL = "com.channels/test"
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    MethodChannel(flutterView, CHANNEL).setMethodCallHandler{call, result ->
      if(call.method == "channel"){

        val res = kotChannel()
        if(res){
          result.success("POSTED")
        }else{
          result.error("ERROR", "Post failed.", null)
        }
      }else{
        result.notImplemented()
      }
    }
  }

  private fun kotChannel():Boolean{
    return true
  }
}