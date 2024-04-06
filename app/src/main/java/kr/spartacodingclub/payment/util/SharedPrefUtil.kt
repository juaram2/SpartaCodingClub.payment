package kr.spartacodingclub.payment.util

import android.content.Context

class SharedPrefUtil(context: Context) {

    private val fileName = "userInfo"
    private val pref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)


    /**
     * Set String data
     * */
    fun setStringPreferences(key: String, value: String?) {
        pref.edit().apply {
            putString(key, value)
            apply()
        }
    }

    /**
     * Get String data
     * */
    fun getStringPreferences(key: String, defaultValue: String?): String? {
        return pref.getString(key, defaultValue)
    }

    /**
     * Set Int data
     * */
    fun setIntPreferences(key: String, value: Int) {
        pref.edit().apply {
            putInt(key, value)
            apply()
        }
    }

    /**
     * Get Int data
     * */
    fun getIntPreferences(key: String, defaultValue: Int): Int {
        return pref.getInt(key, defaultValue)
    }

    /**
     * Set Boolean data
     * */
    fun setBooleanPreferences(key: String, value: Boolean) {
        pref.edit().apply {
            putBoolean(key, value)
            apply()
        }
    }

    /**
     * Get Boolean data
     * */
    fun getBooleanPreferences(key: String, defaultValue: Boolean): Boolean {
        return pref.getBoolean(key, defaultValue)
    }

    /**
     * Preferences key, value 삭제
     * */
    fun removeKeyPreferences(key: String) {
        pref.edit().apply {
            remove(key)
            apply()
        }
    }

    /**
     * Preference 초기화
     * */
    fun clearPreferences() {
        pref.edit().apply {
            clear()
            apply()
        }
    }

}