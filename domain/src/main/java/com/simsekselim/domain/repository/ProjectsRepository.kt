package com.simsekselim.domain.repository

import com.simsekselim.domain.model.Project
import com.simsekselim.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * @Author: Selim Simsek
 * @Date: 6.03.2023
 */
interface ProjectsRepository {
    suspend fun getAllProjects(): Flow<Resource<List<Project>>>
}