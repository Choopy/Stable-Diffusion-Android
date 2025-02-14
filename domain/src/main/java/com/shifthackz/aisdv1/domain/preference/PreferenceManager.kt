package com.shifthackz.aisdv1.domain.preference

import com.shifthackz.aisdv1.domain.entity.ServerSource
import com.shifthackz.aisdv1.domain.entity.Settings
import io.reactivex.rxjava3.core.Flowable

interface PreferenceManager {
    var serverUrl: String
    var demoMode: Boolean
    var monitorConnectivity: Boolean
    var autoSaveAiResults: Boolean
    var saveToMediaStore: Boolean
    var formAdvancedOptionsAlwaysShow: Boolean
    var source: ServerSource
    var hordeApiKey: String
    var forceSetupAfterUpdate: Boolean
    var localUseNNAPI: Boolean

    val useSdAiCloud: Boolean

    fun observe(): Flowable<Settings>
}
