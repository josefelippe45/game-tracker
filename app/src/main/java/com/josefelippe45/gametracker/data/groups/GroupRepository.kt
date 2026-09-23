package com.josefelippe45.gametracker.data.auth

import com.josefelippe45.gametracker.domain.model.Group

interface GroupRepository {
    suspend fun getAll(): Result<List<Group>>;
    suspend fun create(group: Group): Result<Unit>;
}