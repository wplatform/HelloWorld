package com.github.mmo.defines;

public enum ResetFailedReason {
    INSTANCE_RESET_FAILED, // "Cannot reset %s.  There are players still inside the instance."
    INSTANCE_RESET_FAILED_ZONING, // "Cannot reset %s.  There are players in your party attempting to zone into an instance."
    INSTANCE_RESET_FAILED_OFFLINE     // "Cannot reset %s.  There are players offline in your party."
}
