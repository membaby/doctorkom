package com.example.doctorkom.EntitySearch;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
public class SearchFilter {
    public enum QueryOperator {
        EQUALS, NOT_EQUALS, LIKE, LESS_THAN, GREATER_THAN
    }

    private String field;
    private QueryOperator operator;
    private String value;
}