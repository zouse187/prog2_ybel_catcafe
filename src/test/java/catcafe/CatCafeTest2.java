package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest2 {

    @Test
    void cat_count_is_zero_initially() {
        // given
        var cafe = new CatCafe();

        // when
        long count = cafe.getCatCount();

        // then
        assertEquals(0, count);
    }

}
