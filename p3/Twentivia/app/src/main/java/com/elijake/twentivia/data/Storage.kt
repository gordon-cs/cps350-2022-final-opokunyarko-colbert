package com.elijake.twentivia.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.elijake.twentivia.model.Stat
import kotlinx.coroutines.flow.*

class Storage(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "stats")

    private suspend fun save(key: String, value: Stat) {
        context.dataStore.edit { settings ->
            settings[intPreferencesKey(key)] = value
        }
    }

    private suspend fun read(key: String): Stat {
        return context.dataStore.data.first()[intPreferencesKey(key)] as Stat
    }

}