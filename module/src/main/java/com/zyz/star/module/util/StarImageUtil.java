package com.zyz.star.module.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StarImageUtil {

    private StarImageUtil() {
    }

    public static String getFirstImage(String images) {
        if (images == null || images.isBlank()) {
            return null;
        }

        return images.split("\\$")[0];
    }

    public static List<String> splitImages(String images) {
        if (images == null || images.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.asList(images.split("\\$"));
    }
}