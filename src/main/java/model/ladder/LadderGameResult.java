package model.ladder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LadderGameResult {

    private final Map<String, String> result;

    public LadderGameResult(final Map<String, String> result) {
        this.result = new HashMap<>(result);
    }

    public String getResult(final String name) {
        return result.get(name);
    }

    public Set<Map.Entry<String, String>> getAllResult() {
        return result.entrySet();
    }

    public int getSize() {
        return result.size();
    }

    public boolean containName(final String name) {
        if (result.containsKey(name)) {
            return true;
        }
        throw new IllegalArgumentException("존재하지 않는 플레이어의 이름을 입력하였습니다.");
    }
}
