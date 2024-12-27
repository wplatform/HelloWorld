package com.github.mmo.dbc.defines;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CriteriaTreeOperator {
    Complete(0), // Complete
    NotComplete(1), // Not Complete
    CompleteAll(4), // Complete All
    Sum(5), // Sum Of Criteria Is
    Highest(6), // Highest Criteria Is
    StartedAtLeast(7), // Started At Least
    CompleteAtLeast(8), // Complete At Least
    ProgressBar(9);  // Progress Bar
    public final int value;
}
