package com.grandi.lorenzo.gymtracker;

public enum KeyLoader {
    /*===================================== PREFERENCE KEYS ======================================*/
    LOGIN_PREFERENCE_FILE ("com.grandi.lorenzo.gymtracker.loginPreference"),
    SETTINGS_PREFERENCE_FILE("com.grandi.lorenzo.gymtracker.settingsPreference"),
    emailKey ("emailKey"),
    nameKey ("nameKey"),
    passwordKey ("passwordKey"),
    loggedKey ("loggedKey"),
    trainingKey ("trainingKey"),
    colorKey ("colorKey"),
    temperatureKey ("temperatureKey"),
    stepCounterKey ("stepCounterKey"),

    /*======================================= FILE STRINGS =======================================*/
    REGISTRATION_FILE ("personal_backup"),

    /*====================================== QRCODE STRINGS ======================================*/
    strQRFlag (""),

    /*======================================= EXTRAS KEYS ========================================*/
    EXTRA_ACCOUNT ("com.grandi.lorenzo.gymtracker.ACCOUNT"),
    EXTRA_TASK_SELECTOR ("com.grandi.lorenzo.gymtracker.TASK_SELECTOR");

    /*======================================= CONSTRUCTOR ========================================*/
    private final String value;
    KeyLoader(String value) {
        this.value = value;
    }
    public java.lang.String getValue() {
        return value;
    }
}
