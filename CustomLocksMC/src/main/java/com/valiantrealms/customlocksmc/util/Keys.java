package com.valiantrealms.customlocksmc.util;

import com.valiantrealms.customlocksmc.CustomLocksMC;
import org.bukkit.NamespacedKey;

public class Keys {
    public static final NamespacedKey CUSTOM_LOCK = new NamespacedKey(CustomLocksMC.getInstance(), "CustomLock");
    public static final NamespacedKey CUSTOM_KEY = new NamespacedKey(CustomLocksMC.getInstance(), "CustomKey");
    public static final NamespacedKey ADMIN_KEY = new NamespacedKey(CustomLocksMC.getInstance(), "AdminKey");
    public static final NamespacedKey LOCK_LIST = new NamespacedKey(CustomLocksMC.getInstance(), "LockList");
    public static final NamespacedKey DIFFICULTY_SETTING = new NamespacedKey(CustomLocksMC.getInstance(), "DifficultySetting");
    public static final NamespacedKey AUTO_LOCK = new NamespacedKey(CustomLocksMC.getInstance(), "AutoLock");
    public static final NamespacedKey LOCKABLE = new NamespacedKey(CustomLocksMC.getInstance(), "Lockable");
}
