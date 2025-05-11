package  com.ChatMicroservice.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RootResponseModel<T> {
    private boolean success;
    private Map<String, List<String>> errorMessages = new HashMap<>();
    private Map<String, List<String>> messages = new HashMap<>();
    private T responseData;
}
