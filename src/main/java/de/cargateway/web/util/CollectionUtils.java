package de.cargateway.web.util;

import java.util.Collection;

public class CollectionUtils {

    public static <T> boolean atLeastOneMatch(Collection<T> a, Collection<T> b) {
        return a.stream().anyMatch(b::contains);
    }
}
