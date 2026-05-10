package catcafe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CatCafeTest {

  @Test
  void cat_count_is_zero_initially() {
    // given
    var cafe = new CatCafe();

    // when
    long count = cafe.getCatCount();

    // then
    assertEquals(0, count);
  }

  @Test
  void cat_count_increases_after_adding_cat() {
    // given
    var cafe = new CatCafe();
    var cat = new FelineOverLord("Mimi", 4);

    // when
    cafe.addCat(cat);
    long count = cafe.getCatCount();

    // then
    assertEquals(1, count);
  }

  @Test
  void get_cat_by_name_returns_correct_cat() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));
    cafe.addCat(new FelineOverLord("Simba", 5));

    // when
    var result = cafe.getCatByName("Simba");

    // then
    assertNotNull(result);
    assertEquals("Simba", result.name());
  }

  @Test
  void get_cat_by_name_returns_null_when_not_found() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    var result = cafe.getCatByName("Garfield");

    // then
    assertNull(result);
  }

  @Test
  void get_cat_by_name_returns_null_when_name_is_null() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    var result = cafe.getCatByName(null);

    // then
    assertNull(result);
  }

  @Test
  void get_cat_by_weight_returns_cat_in_range() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));
    cafe.addCat(new FelineOverLord("Simba", 5));

    // when
    var result = cafe.getCatByWeight(4, 6);

    // then
    assertNotNull(result);
    assertEquals("Simba", result.name());
  }

  @Test
  void get_cat_by_weight_returns_null_when_no_cat_in_range() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    var result = cafe.getCatByWeight(10, 20);

    // then
    assertNull(result);
  }

  @Test
  void get_cat_by_weight_returns_null_when_min_weight_negative() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    var result = cafe.getCatByWeight(-1, 10);

    // then
    assertNull(result);
  }

  @Test
  void get_cat_by_weight_returns_null_when_max_less_than_min() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 3));

    // when
    var result = cafe.getCatByWeight(5, 3);

    // then
    assertNull(result);
  }

  @Test
  void get_cat_by_weight_returns_first_matching_cat() {
    // given
    var cafe = new CatCafe();
    cafe.addCat(new FelineOverLord("Luna", 4));
    cafe.addCat(new FelineOverLord("Simba", 4)); // gleicher Bereich

    // when
    var result = cafe.getCatByWeight(4, 5);

    // then
    assertNotNull(result);
    assertEquals(4, result.weight());
  }
}
