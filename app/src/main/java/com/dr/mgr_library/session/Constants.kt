package com.dr.mgr.session

import android.Manifest

object Constants {
    object ApplicationConstants {
        const val API_AUTH_TYPE = "sha256"
        const val BUNDLE_KEY_OPEN_CART = "openCart"

        //rebuild first
        const val BASE_URL = "http://devapi.onlineprograms.in/"
        const val SOCKET_BASE_URL = "http://devchat.onlineprograms.in"
      //  const val BASE_URL = "http://onlineprograms.in:8002/"
      //  const val SOCKET_BASE_URL = "http://onlineprograms.in:8008"
       // const val BASE_URL = "https://api.onlineprograms.in/"
       // const val SOCKET_BASE_URL = "https://chat.onlineprograms.in"
        const val API_USER_NAME = "mobikul"
        const val API_PASSWORD = "eVNhTQl3i1fSsdwo"

        const val DEMO_USERNAME = ""
        const val DEMO_PASSWORD = ""


        /* FCM Topic */
        val DEFAULT_FCM_TOPICS = arrayOf("EPO_android")

        /* ALLOWED PAYMENT METHODS */
        private const val PAYMENT_CODE_COD = "cashondelivery"
        private const val PAYMENT_CODE_BANK_TRANSFER = "banktransfer"
        private const val PAYMENT_CODE_CHECK_MONEY_ORDER = "checkmo"

        val AVAILABLE_PAYMENT_METHOD =
            arrayOf(PAYMENT_CODE_COD, PAYMENT_CODE_BANK_TRANSFER, PAYMENT_CODE_CHECK_MONEY_ORDER)

        /* Font Path */
        const val CALLIGRAPHY_FONT_PATH_SEMI_BOLD = "fonts/Montserrat-SemiBold.ttf"
        const val CALLIGRAPHY_FONT_PATH_REGULAR = "fonts/Montserrat-Regular.ttf"

        /* Features Constants */
        const val ENABLE_WEBSITE = true
        const val ENABLE_STORES = true
        const val ENABLE_CURRENCIES = true
        const val ENABLE_COMPARE_PRODUCTS = true
        const val ENABLE_WISHLIST = true
        const val ENABLE_CMS_PAGES = true
        const val ENABLE_OFFLINE_MODE = true
        const val ENABLE_HOME_BANNER_AUTO_SCROLLING = true
        const val ENABLE_AR_CORE = true
        var ENABLE_IMAGE_ZOOMING = false

        const val ENABLE_SPLASH_ANIMATION = false
        const val ENABLE_VERSION_CHECKER = true
        const val ENABLE_FIREBASE_ANALYTICS = false
        const val ENABLE_DYNAMIC_THEME_COLOR = true
        const val ENABLE_ON_BOARDING = true

        /* Configuration Constants */
        const val DEFAULT_WEBSITE_ID = "1"
        const val DEFAULT_STORE_ID = "0"
        const val DEFAULT_STORE_CODE = "en"
        const val DEFAULT_CURRENCY_CODE = ""
        const val DEFAULT_ON_BOARD_VERSION = "1.0"


        /* Miscellaneous Constants */
        const val DEFAULT_TIME_TO_SWITCH_BANNER_IN_MILLIS = 5 * 1000
        const val DEFAULT_OS = "android"
        const val DEFAULT_NUMBER_OF_RECENTLY_VIEWED_PRODUCTS = 15
        const val DEFAULT_TIME_FOR_ABANDONED_CART_NOTIFICATION =2 * 3600000 // 2 hours

        /* Configurations for Testing */
        const val ENABLE_KEYBOARD_OBSERVER = true

        /*Advance booking*/
        const val LOG_PARAMS = 0
        const val LOG_RESPONSE = 0

        const val DEFAULT_MAX_QTY = 9999
        const val BACKSTACK_SUFFIX = "backstack"

    }
    object ConstantsHelper {
        const val GSO_REQ_ID_TOKEN = "250061033071-p96mbc983u32fdil4ov1abbkqlaq29iq.apps.googleusercontent.com"
        const val BASE_URL = Constants.ApplicationConstants.BASE_URL

        const val CHECK_APP_VERSION = "check-app-version"
        const val SIGNOUT = "user/logout"
        const val UPLOAD_FILE = "upload/subject"
        const val SEND_OTP_MOBILE = "otp/send"
        const val SEND_OTP_WHATSAPP = "https://aimwindow.authlink.me"
        const val VERIFY_OTP_MOBILE = "otp/verify"
        const val LOGIN = "portal/login"
        const val GET_CHAT_LIST = "chat/get-room?chat_type="
        const val GET_POST_LIST = "social/post/?perPage=100&currentPage=0"
        const val GET_SAMPLE = "social/post/?perPage=100&currentPage=0"
        const val CREATE_POST = "social/post"

      //  const val GET_EVENT_LIST = BASE_URL+"event?"
      //  const val GET_NOTICE_BOARD = BASE_URL+"noticeBoard"

        const val GET_EVENT_LIST = BASE_URL+"upcomming/event?types=liveClass"
        const val GET_NOTICE_BOARD_LIST = BASE_URL+"upcomming/event?types=noticeBoard"
        const val GET_EXAM_LIST = BASE_URL+"upcomming/event?types=exam"

        const val GET_EVENT = BASE_URL+"event/"
        const val GET_NOTICE_BOARD = BASE_URL+"noticeBoard/"
        const val GET_EXAM = BASE_URL+"exam/"
        const val EVENT_ACKNOWLEDGED = BASE_URL+"event/acknowledge/"
        const val NOTICE_BOARD_ACKNOWLEDGED = BASE_URL+"noticeBoard/acknowledge/"
        const val GET_ACKNOWLEDGE_LIST = BASE_URL+"event/acknowledge/"
        const val GET_NOTICE_BOARD_ACKNOWLEDGE_LIST = BASE_URL+"noticeBoard/acknowledge/"
        const val GET_DASH_BOARD_ADO = BASE_URL+"dashboard/ado"
        const val GET_PROFILE = BASE_URL+"portaluser/profile"
        const val GET_STUDENT_PROFILE = BASE_URL+"my/profile"
        const val GET_GUEST_PROFILE = BASE_URL+"user/profile"
        const val GET_ROLE_SCOPE = BASE_URL+"chat/role_scope"
        const val GET_CHAT_USER_LIST = BASE_URL+"chat/get-users-list/?"
        const val GET_CHAT = BASE_URL+"chat/get-room-messages/"
        const val CREATE_ROOM = BASE_URL+"chat/create-room"
        const val READ_ALL_CHAT = BASE_URL+"chat/room/read-all-message/"
        const val GET_DEPT_LIST = BASE_URL+""
        const val GET_RECENT_SIGNUP_LIST = "guest/recent/signup"
        const val CALLING_INIT = BASE_URL+"tele/call"
        const val GUEST_RECORD_LIST = BASE_URL+"guest/response?guest_id="
        const val ADD_GUEST_RECORD = BASE_URL+"guest/response"
        const val UPDATE_GUEST_RECORD = BASE_URL+"guest/response/"
        const val BLOCK_USER = BASE_URL+"chat/block-user/?block_user_id="
        const val UN_BLOCK_USER = BASE_URL+"chat/block-user/?unblock_user_id="
        const val BLOCK_LIST = BASE_URL+"chat/blocked-user-list"
        const val GET_CHAT_ROOM = BASE_URL+"chat/check-user-chatroom?user_id="

        const val GET_COMMENTS = BASE_URL+"comment?post_id="
        const val UPDATE_COMMENT = "comment/"
        const val DELETE_COMMENT = "comment/"
        const val ADD_COMMENT = "comment"

        const val LIKE_POST = "like"
        const val DISLIKE_POST = "like/"
        const val GET_POST_LIKE_LIST = BASE_URL+"like?post_id="
        const val REPORT_USER = "chat/report-user"
        const val GET_BATCH = "batch-dropdown"
        const val GET_PROGRAM = BASE_URL+"program-dropdown?batch_id="

        const val SEND_FEEDBACK = "feedback"


        const val CUSTOMER_NOT_EXIST = "customerNotExist"
        const val ORDER_STATUS_COMPLETE = "complete"
        const val ORDER_STATUS_PENDING = "pending"
        const val ORDER_STATUS_PROCESSING = "processing"
        const val ORDER_STATUS_HOLD = "holded"
        const val ORDER_STATUS_CANCELLED = "canceled"
        const val ORDER_STATUS_NEW = "new"
        const val ORDER_STATUS_CLOSED = "closed"
        const val VIEW_TYPE_LIST = 1
        const val VIEW_TYPE_GRID = 2
        const val OPEN_LOGIN_PAGE = 1
        const val OPEN_SIGN_UP_PAGE = 2
        const val DEFAULT_DATE_FORMAT = "MM/dd/yy"
        const val LENGTH = 100

        val GOOGLE_API_BASE_URL = "https://maps.googleapis.com/maps/api/"
        /*val GOOGLE_API_DIRECTION_BASE_URL = GOOGLE_API_BASE_URL + "directions/json?"
        val GOOGLE_API_AUTOCOMPLETE_BASE_URL = GOOGLE_API_BASE_URL + "place/autocomplete/json?"
        val GOOGLE_API_PLACE_DETAILS_BASE_URL = GOOGLE_API_BASE_URL + "place/details/json?"
        val GOOGLE_API_STATIC_MAP_BASE_URL = GOOGLE_API_BASE_URL + "staticmap?"*/
        private val GOOGLE_API_GEOCODE_BASE_URL = GOOGLE_API_BASE_URL +"geocode/json?"
        fun getAddress(latitude: Double, longitude: Double): String {
            val lat = latitude.toString()
            val lng = longitude.toString()
            return (GOOGLE_API_GEOCODE_BASE_URL + "latlng=" + lat + ","
                    + lng + "&sensor=true&key=")
        }

    }
    object ApiKeys {
        const val AUTHORIZATION = "Authorization"
        const val BEARER = "Bearer "
        const val SHOP_IS_OPEN = "Shop is open"
        const val SMALL_HOME_BANNER = "smallhomebanner"
        const val PRODUCT_MIDDLE = "productmiddle"
        const val DD = "dd"
        const val YYYY = "yyyy"
        const val MMMM = "MMMM"
        const val HH_MM_AAA = "hh:mm aaa"
        const val TIME_INPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        const val ERROR = "error"
        const val STATUS = "status"
        const val DATA = "data"
        const val ORIGINAL_FILES = "original_files"
        const val FILES = "files"
        const val SHOPPER_ID = "shopper_id"
        const val PRODUCT_ID = "product_id"
        const val QUANTITY = "quantity"
        const val QUANTITY_ID = "quantity_id"
        const val CART_ID = "cart_id"
        const val CART_ID1 = "cartid"
        const val IS_EMPTY = "is_empty"
        const val ID = "id"
        const val PIN_CODE = "pincode"
        const val COUPON = "coupon"
        const val LOCATION_NAME = "location_name"
        const val ADDRESS = "address"
        const val LANDMARK = "landmark"
        const val LOCATION_LAT = "location_lat"
        const val LOCATION_LONG = "location_long"
        const val CUSTOMER_ID = "customer_id"
        const val CREDIT_AMOUNT = "credit_amount"
        const val PAYMENT_ID = "paymentid"
        const val TYPE = "type"
        const val DEVICE = "device"
        const val DEVICE_ID = "device_id"
        const val NAME = "name"
        const val MOBILE = "mobile"
        const val FEEDBACK = "feedback"
        const val UNIT_ID = "unit_id"
        const val SHOP_ID = "shop_id"
        const val DESCRIPTION = "description"
        const val EMAIL = "email"
        const val NEW_PASSWORD = "new_password"
        const val CONFIRM_PASSWORD = "confirm_password"
        const val OTP = "otp"
        const val PASSWORD = "password"
        const val PASSWORD_CONFIRMATION = "password_confirmation"
        const val USER_TYPE = "user_type"
        const val LOCATION = "location"
        const val COUNTRY_CODE = "country_code"
        const val REFERRAL_CODE = "referral_code"
        const val BRAND_ID = "brand_id"
        const val SEARCH = "search"
        const val LIMIT = "limit"
        const val OFFSET = "offset"
        const val CATEGORY_ID = "category_id"
        const val SUB_CATEGORY_ID = "sub_category_id"
        const val PRODUCT = "product"
        const val PRODUCTS = "products"
        const val ITEMS = "items"
        const val ORDER = "order"

    }

    object NotificationKeys {
        const val WELCOME = 1
        const val ORDER_PLACED = 2
        const val CART_NOTIFY = 3
        const val LOGIN = 4
//        const val ORDER_PROCESSING = 5
//        const val ORDER_OUR_FOR_DELIVERY = 6
//        const val ORDER_DELIVERED = 7
//        const val RETURNING_CUSTOMER = 8
//        const val DORMANT_CUSTOMER = 9
    }

    object SessionKeys {
        const val COOKIES = "cookies"
        const val IS_INSTALL_FIRST = "isinstallfirst"
        const val IS_PIE_OPEN_FIRST = "isPieOpenFirst"
        const val IS_CHIP_OPEN_FIRST = "isChipOpenFirst"
        const val SYSTEM_THEME_MODE = "systemThemeMode"
        const val APP_THEME_MODE = "appThemeMode"
        const val IS_DARK_MODE = "isDarkMode"
        const val TOKEN = "token"
        const val REFER_CODE = "refercode"
        const val ID = "id"
        const val FCM_TOKEN = "fcmToken"
        const val LANGUAGE = "language"
        const val SHOP_ID = "shopid"
        const val BASEURL = "baseurl"
        const val BASE_ID = "baseid"
        const val ROLE = "role"
        const val NAME = "name"
        const val FIRST_NAME = "firstname"
        const val LAST_NAME = "lastname"
        const val DOB = "dob"
        const val EMAIL = "email"
        const val MOBILE_NUMBER = "mobileNumber"
        const val IDENTITY = "identity"
        const val PASSWORD = "password"
        const val COUNTRY_CODE = "countryCode"
        const val LOGGED_IN = "loggedIn"
        const val BIO_METRIC = "bioMetric"
        const val PIN = "pin"
        const val UPDATED_FCM = "updatedFcm"
        const val LOCATION1 = "location1"
        const val LAT = "lat"
        const val LNG = "lng"
        const val LOCATION2 = "location2"
        const val PRIMARY_COLOR = "primarycolor"
        const val SECONDARY_COLOR = "secondarycolor"
        const val IMAGE_UPLOAD_PATH = "imageUploadPath"
        const val LAST_NOTIFY = "lastnotify"
        const val SHOW_BRANCH = "showbranch"
        const val NOTIFY_COUNT = "notifycount"
        const val WALLET_AMOUNT = "walletamount"
        const val REFERRAL_AMOUNT = "referalamount"
        const val CART_ID_TEMP = "cartid_temp"
        const val SHOP_LIST = "shoplist"
        const val CART_LIST = "cartlist"
        const val BANNERS = "banners"
        const val WISHLIST = "wishlist"
        const val NOTIFY_LIST = "notifylist"
        const val CONTACT_LIST = "contactlist"
        const val REPORT_LIST = "reportlist"
        const val USER_CIRCLES_LIST = "usercirclelist"
        const val RECENT_CIRCLES_LIST = "recentcirclelist"
        const val RECENT_USERS_LIST = "recentuserlist"
        const val USER_PROFILE = "userProfile"
        const val IMAGE_LIST = "imagelist"
        const val CUSTOMER_TYPE_LIST = "ctlist"
        const val CATEGORY_LIST = "categorylist"
        const val SUB_CATEGORY_LIST = "subcategorylist"
        const val BRAND_LIST = "brandlist"
        const val PRODUCT_UNIT_LIST = "unitlist"
        const val SHOP_WEB_DATA = "shopwebdata"
        const val P_ORDER_COUNT = "pordercount"
        const val C_ORDER_COUNT = "cordercount"
        const val T_ORDER_COUNT = "tordercount"
        const val TOPIC = "topic"
        const val TOPIC_ID = "topic_id"
        const val IS_ACTIVE = "isactive"
        const val IS_ORGANIZATION = "isOrganization"
        const val IS_PERSONAL = "isPersonal"
        const val IS_SWAP = "isSwap"
        const val IS_HR_ACCESSED = "isHrAccessed"
        const val STATUS_BAR_COLOR = "StatusBarColor"
        const val IS_MUTE = "isMute"
        const val IS_CREATE_CIRCLE = "isCreateCircle"
    }

    object IntentKeys {
        const val IS_CHECKOUT = "is_checkout"
        const val PIN_CODE = "pin_code"
        const val LOCATION = "location"
        const val CAMERA = "camera"
        const val CONTACTS = "contacts"
        const val GALLERY = "gallery"
        const val STORAGE = "storage"
        const val PHONE = "phone"
        const val SMS = "sms"
        const val MIC = "mic"
        const val INR = "INR"
        const val IS_CART = "is_cart"
        const val IS_ORDER = "is_order"
        const val IS_NOTIFY = "is_notify"
        const val PAGE = "page"
        const val PAGE_NAME = "pageName"
        const val DASHBOARD = "dashboard"
        const val CATEGORY = "category"
        const val CNAME = "cname"
        const val IMG_URL = "imgurl"
        const val COVER_IMG_URL = "cimgurl"
        const val COVER_IMG_COLOR = "cimgcolor"
        const val IS_PUBLIC = "is_public"
        const val NAME = "name"
        const val IS_COME = "is_come"
        const val IS_SIGNUP = "is_signup"
        const val IS_FORGET = "is_forget"
        const val IS_MOBILE = "is_mobile"
        const val IS_UPDATE = "is_update"
        const val IS_MAIL = "is_mail"
        const val BUNDLE = "bundle"
        const val KEY = "key"
        const val KEY1 = "key1"
        const val KEY2 = "key2"
        const val KEY3 = "key3"
        const val SEESION_ID = "session_id"
        const val USER_ID = "user_id"
        const val CID = "cid"
        const val UID = "uid"
        const val S_C_ID = "s_c_id"
        const val BID = "bid"
        const val DESCRIPTION = "desc"
        const val QUANTITIES = "quantity"
        const val FILES = "files"
        const val LOAD_CATEGORY_P = "load_category_p"
        const val LOAD_SUBCATEGORY_P = "load_subcategory_p"
        const val LOAD_SUBCATEGORY_LIST = "load_subcategory_list"
        const val LOAD_BRAND_P = "load_brand_p"
        const val PRODUCT = "product"
        const val SUBCATEGORY = "subcategory"
        const val COUPON = "coupon"
        const val VAR1 = "{{var1}}"
        const val VAR2 = "{{var2}}"
        const val VAR3 = "{{var3}}"
        const val MOBILE = "mobile"
        const val LOGIN = "login"
        const val NULL = "null"
        const val AMOUNT_DUMMY = "0.00"
        const val FORGET = "forget"
        const val SIGNUP = "signup"
        const val ALL = "all"
        const val LABEL = "label"
        const val DEFAULT_MODE = "default_mode"
        const val LIGHT_MODE = "light_mode"
        const val DARK_MODE = "dark_mode"
        const val UNDEFINED = "undefined"
        const val START = "start"
        const val END = "end"
        const val SEARCH_TYPE = "search_type"
        const val TITLE = "title"
        const val DATA = "data"
        const val IS_CAT = "is_cat"
        const val HOME = "home"
        const val NEW_ARRIVALS = "new_arrivals"
        const val BESTSELLER = "bestseller"
        const val POST = "POST"
        const val GET = "GET"
        const val BODY = "body"
        const val WHATSAPP_SHARE = "https://api.whatsapp.com/send?phone="
        // const val REQUEST_CODE = "RequestCode"
        const val IS_SINGLE_POST = "issinglepost"
        const val IS_COMMUNITY = "iscommunity"
        const val IS_COMMUNITY_VIEW = "iscommunityview"
        const val IS_COMMUNITY_LIST = "iscommunitylist"
        const val IS_CIRCLE = "iscircle"
        const val IS_CIRCLE_VIEW = "iscircleview"
        const val IS_CIRCLE_VIEW_TOP = "iscircleviewtop"
        const val IS_POST = "isPost"
        const val IS_LIKE = "isLike"
        const val IS_CUSTOM_AVATAR = "isCustomAvatar"
        const val IS_BIO = "isbio"
        const val IS_BIO_VIEW = "isbioview"
        const val IS_COMMENT = "isComment"
        const val IS_COMMENT_SUB = "isCommentSub"
        const val IS_JOB = "isjob"
        const val IS_BLOCK = "isblock"
        const val IS_CREATE_JOB = "iscreatejob"
        const val IS_ADD = "isadd"
        const val IS_EDIT = "isedit"
        const val IS_INTERVIEW = "isinterview"
        const val IS_ORGANIZATION = "isorganization"
        const val IS_SPECIAL = "isspecial"
        const val IS_RECOMMEND = "isrecommend"
        const val IS_SAVED = "issaved"
        const val IS_APPLIED = "isapplied"
        const val IS_INTERN = "isintern"
        const val IS_HR = "ishr"
        const val IS_SELECTED = "isselected"
        const val IS_SEE_ALL = "isseeall"
        const val IS_USER = "isuser"
        const val IS_FULLTIME = "isfulltime"
        const val IS_MAIN_FEED = "ismainfeed"
        const val IS_CHIP = "isChip"
        const val IS_CHIP_VIEW = "isChipView"
        const val IS_HOME_VIEW = "isHomeView"
        const val IS_EXPLORE_VIEW = "isExploreView"
        const val IS_PEOPLE = "isPeople"
        const val IS_FAVOURITE = "isfavourite"
        const val IS_SHARE = "isShare"
        const val IS_GROUP_CHAT = "isGroupChat"
        const val IS_PERSONAL_CHAT = "isPersonalChat"
        const val IS_CREATE_GROUP = "isCreateGroup"
        const val IS_RECENT = "isRecent"
        const val IS_SUGGEST_MAIN = "isSuggestMain"
        const val IS_SUGGEST_CIRCLE = "isSuggestCircle"
        const val IS_SUGGEST_CHIP = "isSuggestChip"
    }

    object Common {
        var CURRENCY = "₹"
        var IS_FIRST_OPEN = true
        var IS_FIRST_OPEN_1 = 0
        var LIMIT = 50
    }

    object Permission {
        //  val VIDEO_CALL_LIST = arrayOf(Manifest.permission.RECORD_AUDIO, Manifest.permission.CAMERA)
        val ALL_LIST =  arrayOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_PHONE_NUMBERS,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_SMS,
            Manifest.permission.SEND_SMS,
            Manifest.permission.RECEIVE_SMS
        )
        val LOCATION_LIST = arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
        val CAMERA_LIST = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val CAMERA_LIST_NEW = arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO)
        val GALLERY_LIST = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
        val GALLERY_LIST_NEW = arrayOf(Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO)
        val STORAGE_LIST = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val STORAGE_LIST_NEW = arrayOf(Manifest.permission.READ_MEDIA_IMAGES,Manifest.permission.READ_MEDIA_VIDEO,Manifest.permission.READ_MEDIA_AUDIO)
        val PHONE_LIST = arrayOf(Manifest.permission.CALL_PHONE,Manifest.permission.READ_PHONE_NUMBERS,Manifest.permission.READ_PHONE_STATE)
        val CONTACT_LIST = arrayOf(Manifest.permission.READ_CONTACTS)
        val MIC_LIST = arrayOf(Manifest.permission.RECORD_AUDIO)
        val SMS_LIST = arrayOf(Manifest.permission.READ_SMS,Manifest.permission.SEND_SMS,Manifest.permission.RECEIVE_SMS)
    }

    object RequestCode {
        const val ALL_PERMISSION_REQUEST = 200
        const val GPS_REQUEST = 106
        const val LOCATION_REQUEST = 107
        const val CAMERA_REQUEST = 201
        const val VIDEO_REQUEST = 2001
        const val GALLERY_REQUEST = 202
        const val STORAGE_REQUEST = 203
        const val PHONE_REQUEST = 204
        const val CONTACT_REQUEST = 205
        const val MIC_REQUEST = 206
        const val SMS_REQUEST = 207
        //  const val VIDEO_CALL_REQUEST = 206
    }
}