package ua.dpw.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JsonConverter {
    private static final Gson GSON = new Gson();

    public static <T> List<T> convertJsonStringToList(String response,
        Class<T> typeListElementClass) {
        Type type = TypeToken.getParameterized(List.class, typeListElementClass).getType();
        return GSON.fromJson(response, type);
    }
}
