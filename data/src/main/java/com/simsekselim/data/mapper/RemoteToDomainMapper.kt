package com.simsekselim.data.mapper

import com.simsekselim.data.dto.ProjectResponse
import com.simsekselim.domain.model.Project

/**
 * @Author: Selim Simsek
 * @Date: 7.03.2023
 */

fun ProjectResponse.toDomainModel() = Project(
    description = this.description,
    image = this.image,
    link = this.link,
    title = this.title
)