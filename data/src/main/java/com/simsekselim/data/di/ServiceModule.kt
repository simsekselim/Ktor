package com.simsekselim.data.di

import android.util.Log
import com.simsekselim.data.BuildConfig
import com.simsekselim.data.repository.ProjectsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.network.*
import javax.inject.Singleton


/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesHttpClient(): HttpClient {
        return try {
            HttpClient(CIO) {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(
                        kotlinx.serialization.json.Json {
                            prettyPrint = true
                            isLenient = true
                            ignoreUnknownKeys = true
                        })
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 10000L
                }
                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Log.v("client", message)
                        }
                    }
                    level = LogLevel.ALL

                }
                install(ResponseObserver) {
                    onResponse { response ->
                        Log.d("HTTP status : ", "${response.status.value}")
                    }
                }
                install(DefaultRequest) {
                    header(
                        key = HttpHeaders.ContentType,
                        value = ContentType.Application.Json
                    )
                }
            }
        } catch (e: UnresolvedAddressException) {
            throw UnresolvedAddressException()
        } catch (e: Exception) {
            throw Exception()
        }
    }

    @Provides
    @Singleton
    fun providesRepository(client: HttpClient): ProjectsRepositoryImpl {
        return ProjectsRepositoryImpl(client = client)
    }
}