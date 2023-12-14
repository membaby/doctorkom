package com.example.doctorkom.EntitySearch;

import com.example.doctorkom.EntitySearch.SearchFilter;
import com.example.doctorkom.EntitySearch.SearchSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

@SpringBootTest
class SearchSpecificationTest {
    @Autowired
    private SearchSpecification<Object> searchSpecification;

    @Test
    void union_shouldReturnSpecification() {
        List<Specification<Object>> specifications = List.of(mock(Specification.class), mock(Specification.class));
        Specification<Object> result = searchSpecification.union(specifications);
        System.out.println(result.toString());
        assertNotNull(result);
    }

    @Test
    void intersection_shouldReturnSpecification() {
        List<Specification<Object>> specifications = List.of(mock(Specification.class), mock(Specification.class));
        Specification<Object> result = searchSpecification.intersection(specifications);
        assertNotNull(result);
    }

    @Test
    void createSpecification_equalsOperator_shouldReturnSpecification() {
        SearchFilter searchFilter = SearchFilter.builder()
                .field("fieldName")
                .operator(SearchFilter.QueryOperator.EQUALS)
                .value("fieldValue")
                .build();

        Specification<Object> result = searchSpecification.createSpecification(searchFilter);
        assertNotNull(result);
    }

    @Test
    void createSpecification_notEqualsOperator_shouldReturnSpecification() {
        SearchFilter searchFilter = SearchFilter.builder()
                .field("fieldName")
                .operator(SearchFilter.QueryOperator.NOT_EQUALS)
                .value("fieldValue")
                .build();

        Specification<Object> result = searchSpecification.createSpecification(searchFilter);
        assertNotNull(result);
    }

    @Test
    void createSpecification_greaterThanOperator_shouldReturnSpecification() {
        SearchFilter searchFilter = SearchFilter.builder()
                .field("fieldName")
                .operator(SearchFilter.QueryOperator.GREATER_THAN)
                .value("42")
                .build();

        Specification<Object> result = searchSpecification.createSpecification(searchFilter);
        assertNotNull(result);
    }

    @Test
    void createSpecification_lessThanOperator_shouldReturnSpecification() {
        SearchFilter searchFilter = SearchFilter.builder()
                .field("fieldName")
                .operator(SearchFilter.QueryOperator.LESS_THAN)
                .value("42")
                .build();

        Specification<Object> result = searchSpecification.createSpecification(searchFilter);
        assertNotNull(result);
    }

    @Test
    void createSpecification_likeOperator_shouldReturnSpecification() {
        SearchFilter searchFilter = SearchFilter.builder()
                .field("fieldName")
                .operator(SearchFilter.QueryOperator.LIKE)
                .value("fieldValue")
                .build();

        Specification<Object> result = searchSpecification.createSpecification(searchFilter);
        assertNotNull(result);
    }
}
