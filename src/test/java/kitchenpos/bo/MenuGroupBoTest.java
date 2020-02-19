package kitchenpos.bo;

import kitchenpos.dao.DefaultMenuGroupDao;
import kitchenpos.dao.InMemoryMenuGroupDao;
import kitchenpos.model.MenuGroup;
import kitchenpos.model.MenuGroupTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuGroupBoTest {

    DefaultMenuGroupDao menuGroupDao = new InMemoryMenuGroupDao();
    MenuGroupBo menuGroupBo;

    @BeforeEach
    void setUp() {
        menuGroupBo = new MenuGroupBo(menuGroupDao);
    }

    @Test
    @DisplayName("메뉴그룹은 추가될 수 있다.")
    void createTest() {
        MenuGroup menuGroup = MenuGroupTest.ofSet();
        menuGroupBo.create(menuGroup);
    }

    @Test
    @DisplayName("메뉴그룹 리스트를 조회할 수 있다.")
    void readAllMenuGroupListTest() {
        MenuGroup menuGroup = MenuGroupTest.ofSet();
        menuGroupDao.save(menuGroup);
        assertThat(menuGroupBo.list()).contains(menuGroup);
    }
}