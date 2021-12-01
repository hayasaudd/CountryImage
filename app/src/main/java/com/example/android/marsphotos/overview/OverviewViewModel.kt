/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.overview

import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.android.marsphotos.network.ConntryPhoto
import com.example.android.marsphotos.network.countryApi
import com.example.android.marsphotos.network.photoResposmodul
import kotlinx.coroutines.launch


/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<List<ConntryPhoto>>()
    val photo: LiveData<List<ConntryPhoto>> = _photos

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getContryPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
    private fun getContryPhotos() {
        viewModelScope.launch {
            try{
                _photos.value =countryApi.retrofitService.getPhotos().data
                _status.value = "Success: Mars properties retrieved"
            }catch (e:Exception){
                _status.value = "Failure: ${e.message}" }

        }
    }

}
