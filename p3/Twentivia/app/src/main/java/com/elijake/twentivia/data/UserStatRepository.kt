/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.elijake.twentivia.data

import android.util.Log
import androidx.datastore.core.DataStore
import com.elijake.twentivia.UserStat
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first

/**
 * Class that handles saving and retrieving user preferences
 */
class UserPreferencesRepository(private val userPreferencesStore: DataStore<UserStat>) {

    private val TAG: String = "UserPreferencesRepo"

    val userPreferencesFlow: Flow<UserStat> = userPreferencesStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
            if (exception is IOException) {
                Log.e(TAG, "Error reading sort order preferences.", exception)
                emit(UserStat.getDefaultInstance())
            } else {
                throw exception
            }
        }

    /**
     * Enable / disable sort by deadline.
     */
    suspend fun incrementScore(correct: Boolean) {
        // updateData handles data transactionally, ensuring that if the sort is updated at the same
        // time from another thread, we won't have conflicts
        userPreferencesStore.updateData { currentPreferences ->
            val newCorrectScore =
                if (correct) {
                    currentPreferences.correctQuestionsAnswered + 1
                } else {
                    currentPreferences.correctQuestionsAnswered
                }
            currentPreferences.toBuilder().setQuestionsAnswered(currentPreferences.questionsAnswered + 1).build()
            currentPreferences.toBuilder().setCorrectQuestionsAnswered(newCorrectScore).build()
        }
    }

    suspend fun fetchInitialPreferences() = userPreferencesStore.data.first()
}