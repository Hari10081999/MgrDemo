package com.dr.mgr.session

import android.content.Context
import com.dr.mgr.models.SampleJson
import com.dr.mgr.response.GetRoleScopeResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedHelper(context: Context) {

    private var sharedPreference: SharedPref = SharedPref(context)

    var systemThemeMode: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.SYSTEM_THEME_MODE)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.SYSTEM_THEME_MODE, value)
        }

    var appThemeMode: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.APP_THEME_MODE)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.APP_THEME_MODE, value)
        }

    var isDarkMode: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_DARK_MODE)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_DARK_MODE, value)
        }

    var isInstallFirst: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_INSTALL_FIRST)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_INSTALL_FIRST, value)
        }

    var isPieOpenFirst: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_PIE_OPEN_FIRST)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_PIE_OPEN_FIRST, value)
        }

    var isChipOpenFirst: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_CHIP_OPEN_FIRST)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_CHIP_OPEN_FIRST, value)
        }

    var token: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.TOKEN)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.TOKEN, value)
        }

    var id: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.ID)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.ID, value)
        }

    var fcmToken: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.FCM_TOKEN)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.FCM_TOKEN, value)
        }

    var isfcmTokenUpdated: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.UPDATED_FCM)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.UPDATED_FCM, value)
        }

    var language: String
        get() : String {
            return if (sharedPreference.getKey(Constants.SessionKeys.LANGUAGE) == "") {
                "en"
            } else {
                sharedPreference.getKey(Constants.SessionKeys.LANGUAGE)
            }

        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.LANGUAGE, value)
        }

    var dob: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.DOB)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.DOB, value)
        }

    var role: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.ROLE)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.ROLE, value)
        }

    var name: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.NAME)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.NAME, value)
        }

    var imgUrl: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.SHOP_ID)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.SHOP_ID, value)
        }

    var firstname: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.FIRST_NAME)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.FIRST_NAME, value)
        }


    var lastname: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.LAST_NAME)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.LAST_NAME, value)
        }

    var email: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.EMAIL)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.EMAIL, value)
        }

    var mobileNumber: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.MOBILE_NUMBER)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.MOBILE_NUMBER, value)
        }

    var countryCode: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.COUNTRY_CODE)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.COUNTRY_CODE, value)
        }

    var loggedIn: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.LOGGED_IN)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.LOGGED_IN, value)
        }

    var isBioMetric: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.BIO_METRIC)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.BIO_METRIC, value)
        }

    var pin: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.PIN)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.PIN, value)
        }

    var location1: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.LOCATION1)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.LOCATION1, value)
        }

    var myLat: Float
        get() : Float {
            return sharedPreference.getFloat(Constants.SessionKeys.LAT)
        }
        set(value) {
            sharedPreference.putFloat(Constants.SessionKeys.LAT, value)
        }

    var myLng: Float
        get() : Float {
            return sharedPreference.getFloat(Constants.SessionKeys.LNG)
        }
        set(value) {
            sharedPreference.putFloat(Constants.SessionKeys.LNG, value)
        }

    var imageUploadPath: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.IMAGE_UPLOAD_PATH)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.IMAGE_UPLOAD_PATH, value)
        }

    var notifyCount: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.NOTIFY_COUNT)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.NOTIFY_COUNT, value)
        }

    var pOrderCount: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.P_ORDER_COUNT)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.P_ORDER_COUNT, value)
        }

    var cOrderCount: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.C_ORDER_COUNT)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.C_ORDER_COUNT, value)
        }

    var tOrderCount: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.T_ORDER_COUNT)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.T_ORDER_COUNT, value)
        }

    var lastNotify: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.LAST_NOTIFY)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.LAST_NOTIFY, value)
        }

    var topic: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.TOPIC)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.TOPIC, value)
        }

    var topicId: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.TOPIC_ID)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.TOPIC_ID, value)
        }

    var isActive: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.IS_ACTIVE)
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.IS_ACTIVE, value)
        }

    var isOrganization: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_ORGANIZATION)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_ORGANIZATION, value)
        }

    var isPersonal: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_PERSONAL)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_PERSONAL, value)
        }

    var isSwap: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_SWAP)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_SWAP, value)
        }

    var calendarTiming: Int
        get() : Int {
            return sharedPreference.getInt("calendarTiming")
        }
        set(value) {
            sharedPreference.putInt("calendarTiming", value)
        }

    var isHrAccessed: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_HR_ACCESSED)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_HR_ACCESSED, value)
        }

    var statusBarColor: Int
        get() : Int {
            return sharedPreference.getInt(Constants.SessionKeys.STATUS_BAR_COLOR)
        }
        set(value) {
            sharedPreference.putInt(Constants.SessionKeys.STATUS_BAR_COLOR, value)
        }

    var isMute: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_MUTE)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_MUTE, value)
        }

    var primaryColor: String
        get() : String {
            return sharedPreference.getKey(Constants.SessionKeys.PRIMARY_COLOR,"#A3A3A3")
        }
        set(value) {
            sharedPreference.putKey(Constants.SessionKeys.PRIMARY_COLOR, value)
        }

    var isCreateCircle: Boolean
        get() : Boolean {
            return sharedPreference.getBoolean(Constants.SessionKeys.IS_CREATE_CIRCLE)
        }
        set(value) {
            sharedPreference.putBoolean(Constants.SessionKeys.IS_CREATE_CIRCLE, value)
        }

    var cookies: MutableSet<String>?
        get() : MutableSet<String>? {
            return sharedPreference.getStringSet(Constants.SessionKeys.COOKIES)
        }
        set(value) {
            sharedPreference.putStringSet(Constants.SessionKeys.COOKIES, value)
        }

    var sampleList: ArrayList<SampleJson.Sample>
        get() : ArrayList<SampleJson.Sample> {
            val myType = object : TypeToken<List<SampleJson.Sample>>() {}.type
            val vsl = sharedPreference.getKey(Constants.SessionKeys.BRAND_LIST)

            if (vsl == "") {
                return ArrayList()
            }
            val logs: ArrayList<SampleJson.Sample> = Gson().fromJson(vsl, myType)
            return logs as ArrayList<SampleJson.Sample>
        }
        set(value) {
            val jsonString = Gson().toJson(value)
            sharedPreference.putKey(Constants.SessionKeys.BRAND_LIST, jsonString)
        }

    var roleScope: GetRoleScopeResponse.Result
        get() : GetRoleScopeResponse.Result {
            val myType = object : TypeToken<GetRoleScopeResponse.Result>() {}.type
            val vsl = sharedPreference.getKey(Constants.SessionKeys.PRODUCT_UNIT_LIST)

            if (vsl == "") {
                return GetRoleScopeResponse.Result()
            }
            val logs: GetRoleScopeResponse.Result = Gson().fromJson(vsl, myType)
            return logs as GetRoleScopeResponse.Result
        }
        set(value) {
            val jsonString = Gson().toJson(value)
            sharedPreference.putKey(Constants.SessionKeys.PRODUCT_UNIT_LIST, jsonString)
        }
}
