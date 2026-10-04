package com.willian.ourofino

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import okhttp3.OkHttpClient

class OuroFinoApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        // O Wikimedia Commons pede um User-Agent que identifique o aplicativo.
        val cliente = OkHttpClient.Builder()
            .addInterceptor { cadeia ->
                cadeia.proceed(
                    cadeia.request().newBuilder()
                        .header("User-Agent", "OuroFinoTurismo/2.0 (willian.wrr1@gmail.com)")
                        .build()
                )
            }
            .build()
        return ImageLoader.Builder(this)
            .okHttpClient(cliente)
            .crossfade(true)
            .build()
    }
}
