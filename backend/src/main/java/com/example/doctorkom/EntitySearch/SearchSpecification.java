package com.example.doctorkom.EntitySearch;

import jakarta.persistence.criteria.Expression;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchSpecification<T> {
    public Specification<T> union(List<Specification<T>> specifications) {
        return Specification.anyOf(specifications);
    }

    public Specification<T> intersection(List<Specification<T>> specifications) {
        return Specification.allOf(specifications);
    }

    public Specification<T> createSpecification(SearchFilter searchFilter) {
        return switch (searchFilter.getOperator()) {
            case EQUALS ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(searchFilter.getField()), fieldValue(root.get(searchFilter.getField()), searchFilter));
            case NOT_EQUALS ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.notEqual(root.get(searchFilter.getField()), fieldValue(root.get(searchFilter.getField()), searchFilter));
            case GREATER_THAN ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(searchFilter.getField()), searchFilter.getValue());
            case LESS_THAN ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(searchFilter.getField()), searchFilter.getValue());
            case LIKE ->
                    (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(searchFilter.getField()), "%" + fieldValue(root.get(searchFilter.getField()), searchFilter) + "%");
        };
    }

    private Object fieldValue(Expression<Object> field, SearchFilter searchFilter) {
        if (field.getJavaType().isEnum()) {
            return Enum.valueOf((Class<Enum>) field.getJavaType(), searchFilter.getValue());
        } else {
            return searchFilter.getValue();
        }
    }
}