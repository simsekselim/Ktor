package com.simsekselim.data.repository

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.simsekselim.data.BuildConfig
import com.simsekselim.data.dto.ProjectResponse
import com.simsekselim.data.mapper.toDomainModel
import com.simsekselim.data.utils.safeApiCall
import com.simsekselim.domain.model.Project
import com.simsekselim.domain.repository.ProjectsRepository
import com.simsekselim.domain.utils.Resource
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */
class ProjectsRepositoryImpl @Inject constructor(
    private val client: HttpClient
) : ProjectsRepository {
    override suspend fun getAllProjects(): Flow<Resource<List<Project>>> {
        return flow {
            emit(Resource.Loading())
            emit(
                safeApiCall(
                    response = client.request<List<ProjectResponse>>(BuildConfig.API_URL) {
                        method = HttpMethod.Get
                        timeout {
                            requestTimeoutMillis = 10000L
                        }
                    }.map {
                        it.toDomainModel()
                    }
                )
            )
        }
    }
}