package com.dr.mgr.session

import com.dr.mgr.models.FileFacer
import okhttp3.MultipartBody

class TempSingleton private constructor() {
    companion object {
        private var instane: TempSingleton? = null
        fun getInstance(): TempSingleton {
            if (instane == null) {
                instane = TempSingleton()
            }
            return instane!!
        }

        fun clearAllValues() {
            instane = TempSingleton()
        }
    }
    var apiUrl: String = ""

    var name: String = ""
    var isMultiple: Boolean = false
    var isVideo: Boolean = false
    var isImage: Boolean = true
    var isFile: Boolean = false
    var files: String = ""

    var fileList:ArrayList<FileFacer> = ArrayList()

    var isCommentUpdate: Boolean = false
    var isUserPost: Boolean = false

    var isWhatsApp: Boolean = false

}