package com.elijake.twentivia.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class Storage(val context: Context) {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "stats")

}